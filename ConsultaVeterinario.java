/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Modulo;

//import static Vista.vistaadministrador.jtVeterinario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julian
 */
public class ConsultaVeterinario extends Conexion {
  
    public int maximoIdC(){
        int nummax = 0;
        try {
    Connection con = getConexion();     
     if (con!=null) {
         System.out.println("Conectado");
     } 
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT id FROM VETERINARIO where id = (Select MAX(id) FROM VETERINARIO) ORDER BY id;");//sentencia de seleccion
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
    
  public boolean registrar (Veterinario vet1, DireccionVeterinario vet2){
    LinkedList<Veterinario> ListadoVeterinarios = new LinkedList<Veterinario>();
    String cadena = "";
    int id = maximoIdC();
    PreparedStatement ps = null; 
    PreparedStatement ps2 = null;
    //Veterinario vet1 = new Veterinario(); 
    ListadoVeterinarios.add(vet1);
    
    Connection con = getConexion();
    String sql = "INSERT INTO VETERINARIO(id, nombre, fecha, horarioAtencion, ubicacionMaps) VALUES(?,?,?,?,?)";
    int largo = ListadoVeterinarios.size();
    
    String sql2 = "INSERT INTO DIRECCION_VETERINARIO (id_vet, provincia, canton, distrito, señas, telefono, correo, web) VALUES(?,?,?,?,?,?,?,?)";
//interacion con los datos del modelo
        try{ 
        ps = con.prepareStatement(sql);
        for (int i = 0; i < largo; i++) {
        ps.setInt(1, id);
        ps.setString(2, vet1.getNombreVet() );
        ps.setString(3, vet1.getFechaVet());
        ps.setString(4, vet1.getHorarioAtencioVet());
        ps.setString(5, vet1.getMapsVet());
        ps.execute();
        }
        
        ps2 = con.prepareStatement(sql2);
        ps2.setInt(1, id);
        ps2.setString(2, vet2.getProvinciaVet());
        ps2.setString(3, vet2.getProvinciaVet());
        ps2.setString(4, vet2.getDistritoVet());
        ps2.setString(5, vet2.getSennasVet());
        ps2.setInt(6, vet2.getTelefonoVet());
        ps2.setString(7, vet2.getCorreoVet());
        ps2.setString(8, vet2.getWebVet());
        ps2.execute();
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
  
  
  public boolean modificar (Veterinario vet1, DireccionVeterinario vet2){
    PreparedStatement ps = null; 
    PreparedStatement ps2 = null;
    Connection con = getConexion();
    String sql = "UPDATE  VETERINARIO SET nombre=?, horarioAtencion=?, ubicacionMaps=? WHERE id = ?";
    String sql2 = "UPDATE DIRECCION_VETERINARIO SET provincia=?, canton=?, distrito=?, señas=?, telefono=?, correo=?, web=?";
    try{
        //veterinario
        ps = con.prepareStatement(sql);
        ps.setString(1, vet1.getNombreVet() );
        ps.setString(2, vet1.getHorarioAtencioVet());
        ps.setString(3, vet1.getMapsVet());
        ps.setInt(4, vet1.getIdVete());
        
        //direccion veterinario
        ps2 = con.prepareStatement(sql2);
        ps2.setString(1, vet2.getProvinciaVet() );
        ps2.setString(2, vet2.getDistritoVet());
        ps2.setString(3, vet2.getDistritoVet());
        ps2.setString(4, vet2.getSennasVet());
        ps2.setInt(5, vet2.getTelefonoVet());
        ps2.setString(6, vet2.getCorreoVet());
        ps2.setString(7, vet2.getWebVet());
       ps.execute();
       ps2.execute();
        
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
  
  
   public boolean eliminar  ( Veterinario vet1, DireccionVeterinario vet2){
    PreparedStatement ps = null; 
    PreparedStatement ps2 = null; 
    Connection con = getConexion();
    String sql2 = "DELETE FROM DIRECCION_VETERINARIO WHERE id_vet= ?";
    String sql = "DELETE FROM VETERINARIO WHERE id=?";
   
    try{
        ps2 = con.prepareStatement(sql2);
        ps2.setInt(1, vet1.getIdVete());
        ps2.execute();
        
        ps = con.prepareStatement(sql);
        ps.setInt (1, vet1.getIdVete());
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

  
  

   


  



    
  










    
        
    
  
 
  















