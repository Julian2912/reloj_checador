/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;
import java.sql.*;
import javax.swing.JOptionPane;
 
/**
 * Clase que permite conectar con la base de datos
 * @author chenao
 *
 */
public class DbConnection {
   /**Parametros de conexion*/
   static String bd = "Topicos";
   static String login = "postgres";
   static String password = "1234";
   static String url = "jdbc:postgresql://localhost/"+bd;
 
   Connection connection = null;
 
   /** Constructor de DbConnection */
   public DbConnection() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("org.postgresql.Driver");
         //obtenemos la conexión
         connection = DriverManager.getConnection(url,login,password);
      }
      catch(SQLException e){
         //System.out.println(e);
      }catch(ClassNotFoundException e){
         //System.out.println(e);
      }catch(Exception e){
         //System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}