/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Julian
 */
import conexionBD.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AdministradorDAO {
    
    public ArrayList<AdministradorVO> consultarEmpleado(String name,String pass) {
  ArrayList< AdministradorVO> miEmpleado = new ArrayList< AdministradorVO>();
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("select * from empleado.administrador where nombre= ? and contrasenia= ?;" );
   consulta.setString(1, name);
   consulta.setString(2, pass);  
   ResultSet res = consulta.executeQuery();
  if(res.next()){
    AdministradorVO persona= new AdministradorVO ();
    persona.setId(res.getInt("id")); 
    persona.setNombre(res.getString("nombre"));
    persona.setContrasenia(res.getString("contrasenia"));
    miEmpleado.add(persona);
          }
          res.close();
          consulta.close();
          conex.desconectar();
    
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar sobre el empleado\n"+e);
  }
  return miEmpleado;
 }
        
}
