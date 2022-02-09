/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Modulo;

import Modulo.Categoria;
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
public class ConsultaCategoria extends Conexion{
    public int maximoIdC(){
        int nummax = 0;
        try {
    Connection con = getConexion();     
     if (con!=null) {
         System.out.println("Conectado");
     } 
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT id_cat FROM CATEGORIA where id_cat = (Select MAX(id_cat) FROM CATEGORIA) ORDER BY id_cat;");//sentencia de seleccion
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
    
  public boolean registrar (Categoria cat){
    LinkedList<Categoria>ListadoCategorias = new LinkedList<Categoria>();
    String cadena = "";
    int idCategoria = maximoIdC();
    PreparedStatement ps = null; 
    ListadoCategorias.add(cat);
    Connection con = getConexion();
    String sql = "INSERT INTO CATEGORIA(codCategoria, nombreCategoria, descripcion, estado, id_cat) VALUES(?,?,?,?,?)";
    int largo = ListadoCategorias.size();
    
    try{
        for (int i = 0; i < largo; i++) {
        ps = con.prepareStatement(sql);
        ps.setString(1, cat.getCodCategoria());
        ps.setString(2, cat.getNombreCategoria());
        ps.setString(3, cat.getDescripCategoria());
        ps.setString(4, cat.getEstadoCategoria());
        ps.setInt(5, idCategoria);
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
  
  public boolean modificar (Categoria cat){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "UPDATE  CATEGORIA SET codCategoria=?, nombreCategoria=?, descripcion=?, estado=? WHERE id_cat = ?";

    try{
        //veterinario
        ps = con.prepareStatement(sql);
        ps.setString(1, cat.getCodCategoria());
        ps.setString(2, cat.getNombreCategoria());
        ps.setString(3, cat.getDescripCategoria());
        ps.setString(4, cat.getEstadoCategoria());
        ps.setInt(5, cat.getIdCategoria());
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
  public boolean eliminar  (Categoria cat ){
    PreparedStatement ps = null; 
    Connection con = getConexion();
    String sql = "DELETE FROM CATEGORIA WHERE id_cat=?";
    try{
        ps = con.prepareStatement(sql);
        ps.setInt (1, cat.getIdCategoria());
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
  
    

