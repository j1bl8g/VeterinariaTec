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

public class ConsultaPaciente extends Conexion{
    public int maximoIdC(){
    int nummax = 0;
        try {
    Connection con = getConexion();     
     if (con!=null) {
         System.out.println("Conectado");
     } 
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT id FROM PACIENTES where id = (Select MAX(id) FROM PACIENTES) ORDER BY id;");//sentencia de seleccion
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
  
    public boolean registrar (Paciente paa){
    LinkedList<Paciente> ListadoPacientes = new LinkedList<Paciente>();
    String cadena = "";
    int id = maximoIdC();
    PreparedStatement ps = null; 
    Connection con = getConexion();
    ListadoPacientes.add(paa);
    String sql = "INSERT INTO PACIENTES (id, raza, nombre, edad) VALUES(?,?,?,?)";
    try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, paa.getRaza());
        ps.setString(3, paa.getNombrePaciente());
        ps.setInt(4, paa.getEdadPaciente());
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
  
  public boolean modificar (Paciente paa){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "UPDATE  PACIENTES SET raza=?, nombre=?, edad=? WHERE id = ?";

    try{
        //veterinario
        ps = con.prepareStatement(sql);
        ps.setString(1, paa.getRaza());
        ps.setString(2, paa.getNombrePaciente());
        ps.setInt(3, paa.getEdadPaciente());
        ps.setInt(4, paa.getIdPaciente());
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
  public boolean eliminar  (Paciente paa ){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "DELETE FROM PACIENTES WHERE id=?";
    try{
        ps = con.prepareStatement(sql);
        ps.setInt (1, paa.getIdPaciente());
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
  

    

