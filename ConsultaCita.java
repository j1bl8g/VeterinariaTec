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
public class ConsultaCita extends Conexion {
    
    public int maximoIdC(){
        int nummax = 0;
        try {
    Connection con = getConexion();     
     if (con!=null) {
         System.out.println("Conectado");
     } 
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT id FROM CITASMEDICAS where id = (Select MAX(id) FROM CITASMEDICAS) ORDER BY id;");//sentencia de seleccion
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
  public boolean registrar  (Cita cit){
    LinkedList<Cita> ListadoCITASMEDICAS = new LinkedList<Cita>();
    String cadena = "";
    int id = maximoIdC();
    PreparedStatement ps = null;
    Connection con = getConexion();
    String sql = "INSERT INTO CITASMEDICAS (id, estado) VALUES (?,?) ";
    
    //iteracion datos, modelo
    try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, cit.getEstadoCitas());
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
  
  public boolean eliminar  (Cita cit ){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "DELETE FROM CITASMEDICAS WHERE id=?";
   
    try{  
        ps = con.prepareStatement(sql);
        ps.setInt (1, cit.getIdCistas());
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
  
  public boolean modificar (Cita cit){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "UPDATE  CITASMEDICAS SET estado=? WHERE id = ?";

    try{
        //veterinario
        ps = con.prepareStatement(sql);
        ps.setString(1, cit.getEstadoCitas());
        ps.setInt(2, cit.getIdCistas());
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
