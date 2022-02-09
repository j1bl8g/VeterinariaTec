/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Modulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
/**
 *
 * @author julian
 */
public class ConsultaServicio extends Conexion {
    public int maximoIdC(){
        int nummax = 0;
        try {
    Connection con = getConexion();     
     if (con!=null) {
         System.out.println("Conectado");
     } 
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT id_serv FROM SERVICIO where id_serv = (Select MAX(id_serv) FROM SERVICIO) ORDER BY id_serv;");//sentencia de seleccion
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
  
    public boolean registrar (Servicio ser1){
    LinkedList<Servicio>ListadoServicios = new LinkedList<Servicio>();
    String cadena = "";
    int id_serv = maximoIdC();
    PreparedStatement ps = null; 
    ListadoServicios.add(ser1);
    Connection con = getConexion();
    String sql = "INSERT INTO SERVICIO(id_serv, tipo, codigo, nombre, descripcion, estado, montoServicio, montoExtraDomicilio) VALUES(?,?,?,?,?,?,?,?)";
    int largo = ListadoServicios.size();
    
    try{
        for (int i = 0; i < largo; i++) {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id_serv);
        ps.setString(2, ser1.getTipoServ()  );
        ps.setInt(3, ser1.getCodigoServ());
        ps.setString(4, ser1.getNombreServ());
        ps.setString(5, ser1.getDescripServ()  );
        ps.setString(6, ser1.getEstadoServ());
        ps.setInt(7, ser1.getMontoServ());
        ps.setInt(8, ser1.getMontoExtraServ());
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
   
  public boolean modificar (Servicio ser1){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "UPDATE  SERVICIO SET tipo=?, codigo=?, nombre=?, descripcion=?, estado=?, montoServicio =?, montoExtraDomicilio=? WHERE id_serv = ?";

    try{
        //veterinario
        ps = con.prepareStatement(sql);
        ps.setString(1, ser1.getTipoServ());
        ps.setInt(2, ser1.getCodigoServ());
        ps.setString(3, ser1.getNombreServ());
        ps.setString(4, ser1.getDescripServ());
        ps.setString(5, ser1.getEstadoServ());
        ps.setInt(6, ser1.getMontoServ());
        ps.setInt(7, ser1.getMontoExtraServ());
        ps.setInt(8, ser1.getId_serv());
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
  public boolean eliminar  (Servicio ser1 ){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "DELETE FROM SERVICIO WHERE id_serv=?";
    try{
        ps = con.prepareStatement(sql);
        ps.setInt (1, ser1.getId_serv());
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
  
  public boolean Mostrar  (Servicio ser1 ){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "SELECT * FROM SERVICIO  WHERE id_serv=?";
    try{
        ps = con.prepareStatement(sql);
        ps.setInt (1, ser1.getId_serv());
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

  
