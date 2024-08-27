/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionjdbc;

/**
 *
 * @author ACER
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/prueba";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = java.sql.DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("select * from usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            // Insercion de datos
            statement.execute("INSERT INTO `usuario` (`Idusuario`, `nombre`, `password`) VALUES (NULL, 'Eric', '02358');");
            rs = statement.executeQuery("select * from usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            // actualizacion
            statement.execute("UPDATE `usuario` SET `nombre` = 'Kelys' WHERE `usuario`.`Idusuario` = 'Marcelo';");
            System.out.println("");
            rs = statement.executeQuery("select * from usuario");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            //elimincacion
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
