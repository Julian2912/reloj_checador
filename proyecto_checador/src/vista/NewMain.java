/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.EmpleadoDAO;
import modelo.EmpleadoVO;

/**
 *
 * @author Julian
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpleadoDAO edao= new EmpleadoDAO();
        EmpleadoVO e=edao.consultarEmpleado(1416);
        System.out.println(e.getApellidoMaterno()==null);
        if(e.getApellidoMaterno()==null){System.out.println("esta mal");}
    }
    
}
