/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Main;

import Controlador.CtrlCategoria;
import Controlador.CtrlCita;
import Controlador.CtrlCliente;
import Controlador.CtrlCliente2;
import Controlador.CtrlPaciente;
import Controlador.CtrlServicio;
import Controlador.CtrlVeterinario;
import Modulo.Categoria;
import Modulo.Cita;
import Modulo.Cliente;
import Modulo.ConsultaCategoria;
import Modulo.ConsultaCita;
import Modulo.ConsultaCliente;
import Modulo.ConsultaPaciente;
import Modulo.ConsultaServicio;
import Modulo.ConsultaVeterinario;
import Modulo.DireccionVeterinario;
import Modulo.Paciente;
import Modulo.Servicio;
import Modulo.Veterinario;
import Vista.menuGestiones;
import Vista.tablaCita;
import Vista.tablaServicio;
import Vista.tablaVeterinario;
import Vista.vistaCliente;
import Vista.vistaVeterinario;
import Vista.vistaadministrador;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class maskoTika {
  
  
    
    public static void main(String[] args){
        //veterinario
        Veterinario vet1 = new Veterinario();
        DireccionVeterinario vet2 = new DireccionVeterinario();
        ConsultaVeterinario modC = new ConsultaVeterinario();
        
        //servicio
        Servicio ser1 = new Servicio();
        ConsultaServicio modW = new ConsultaServicio();
        
        //Cita
        Cita cit = new Cita();
        ConsultaCita modH = new ConsultaCita();
        
        //categoria
        Categoria cat = new Categoria();
        ConsultaCategoria modS = new ConsultaCategoria();
        
        //Pachente
        Paciente paa = new Paciente();
        ConsultaPaciente modZ = new ConsultaPaciente();
        
        //Cliente
        Cliente clie = new Cliente();
        ConsultaCliente modJ = new ConsultaCliente();
        
        Cliente clie2 = new Cliente();
        ConsultaCliente modzz = new ConsultaCliente();
        
         
        //vistas
        vistaadministrador frm = new vistaadministrador();
        vistaadministrador frm2 = new vistaadministrador();
        vistaadministrador frm3 = new vistaadministrador();
        
        vistaVeterinario frm4 = new vistaVeterinario();
        vistaVeterinario frm5 = new vistaVeterinario();
        vistaVeterinario frm7 = new vistaVeterinario();
        menuGestiones frm42 = new menuGestiones();
        
        tablaVeterinario frm28 = new tablaVeterinario();
        tablaServicio frm2811 = new tablaServicio();
        tablaCita frm333 = new tablaCita();
        
        vistaCliente frm777 = new vistaCliente();
        
        
        
        
        
        //llamar controlador
        CtrlVeterinario ctrl;
        ctrl = new CtrlVeterinario (vet1, vet2, modC, frm, frm28);
        ctrl.iniciar();
        
        CtrlCategoria ctrl2;
        ctrl2 = new CtrlCategoria(cat, modS,  frm2);
        ctrl2.iniciar();
        
        CtrlCita ctrl3;
        ctrl3 = new CtrlCita(cit, modH, frm3, frm333);
        ctrl3.iniciar();
        
        CtrlPaciente ctrl4;
        ctrl4 = new CtrlPaciente(paa, modZ, frm4);
        ctrl4.iniciar();
        
        CtrlServicio ctrl5;
        ctrl5 = new CtrlServicio(ser1, modW, frm5);
        ctrl5.iniciar();
        
        CtrlCliente ctrl6;
        ctrl6 = new CtrlCliente(clie, modJ, frm7);
        ctrl6.iniciar();
        
        CtrlCliente2 ctrl777;
        ctrl777 = new CtrlCliente2(clie2, modzz, frm777);
        ctrl777.iniciar();
                
        
       
        
        
        
        
        
        //Pruebas de ventanas por separado 
        //frm.setVisible(true);
        //frm2.setVisible(true);
        //frm5.setVisible(true);
        //frm3.setVisible(true);
        //frm4.setVisible(true);
        //frm7.setVisible(true);
        frm42.setVisible(true);
        //tablaVeterinario.setVisible(true);
    }
    
}
