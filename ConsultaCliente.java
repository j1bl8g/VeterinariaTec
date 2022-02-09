/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Modulo;
import Modulo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modulo.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author julian
 */
public class ConsultaCliente extends Conexion {
    public int maximoIdC(){
        int nummax = 0;
        try {
    Connection con = getConexion();     
     if (con!=null) {
         System.out.println("Conectado");
     } 
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT id_clint FROM CLIENTE where id_clint = (Select MAX(id_clint) FROM CLIENTE) ORDER BY id_clint;");//sentencia de seleccion
            while (rs.next()){
      
            nummax= rs.getInt(1);
 
}
    
    con.close();
     
     
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    
    nummax += 1;
   
    return nummax;
    }
    
    public boolean registrar (Cliente clie){
    LinkedList<Paciente> ListadoPacientes = new LinkedList<Paciente>();
    String cadena = "";
    int id_clint = maximoIdC();
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "INSERT INTO CLIENTE (id_clint, usuario, contraseña, nombre, numeroCedula, ubicacion, correo, telefono) VALUES(?,?,?,?,?,?,?,?)";
    int largo = ListadoPacientes.size();
    
    try{
        for (int i = 0; i < largo; i++) {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id_clint);
        ps.setString(2, clie.getUsuarioCliente());
        ps.setString(3, clie.getContraCliente());
        ps.setString(4, clie.getNombreCliente());
        ps.setInt(5, clie.getNumeroCedula());
        ps.setString(6, clie.getUbicacionCliente());
        ps.setString(7, clie.getCorreoCliente());
        ps.setInt(8, clie.getTelefonoCliente());
        ps.execute();
        }
        return true;
    } catch (SQLException e)
    {
        System.err.println(e);
        return false;
    } finally {
        try{
            con.close();
        } catch (SQLException e){
        System.err.println(e);
    }
  }     
  }
    
public boolean modificar (Cliente clie){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "UPDATE  CLIENTE SET usuario=?, contraseña=?, nombre=?, numeroCedula=?, ubicacion = ?, correo = ?, telefono=? WHERE id_clint = ?";

    try{
        //veterinario
        ps = con.prepareStatement(sql);
        ps.setString(1, clie.getUsuarioCliente());
        ps.setString(2, clie.getContraCliente());
        ps.setString(3, clie.getNombreCliente());
        ps.setInt(4, clie.getNumeroCedula());
        ps.setString(5, clie.getUbicacionCliente());
        ps.setString(6, clie.getCorreoCliente());
        ps.setInt(7, clie.getTelefonoCliente());
        ps.setInt(8, clie.getIdCliente());
        ps.execute();
       
        
        return true;
    } catch (SQLException e)
    {
        System.err.println(e);
        return false;
    } finally {
        try{
            con.close();
        } catch (SQLException e){
        System.err.println(e);
    }
  }     
  } 

public boolean eliminar  (Cliente clie ){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "DELETE FROM CLIENTE WHERE id_clint=?";
   
    try{  
        ps = con.prepareStatement(sql);
        ps.setInt (1, clie.getIdCliente());
        ps.execute();
        return true;
    } catch (SQLException e)
    {
        System.err.println(e);
        return false;
    } finally {
        try{
            con.close();
        } catch (SQLException e){
        System.err.println(e);
    }
  }     
  }
    
    
}
