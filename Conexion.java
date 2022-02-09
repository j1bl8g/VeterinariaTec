/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Vista;

import Modulo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author danBoga
 */
public class Conexion {
    public  Connection getConexion() {
        Connection con= null;
        String Url;
        Url = "jdbc:sqlserver://proyectouno.database.windows.net:1433;database=BasesDatos;user=neef506@proyectouno;password={megustaelPOLLO69@};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
        try {
             con = DriverManager.getConnection(Url);
             if (con != null){
                 System.out.println("Conectado");
             }
        } catch (SQLException e) {
            System.out.println("no se puede Conectado");
        }
        return con; 
   }
    
}
   


    

