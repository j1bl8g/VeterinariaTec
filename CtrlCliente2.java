/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modulo.Cliente;
import Modulo.ConsultaCliente;
import Vista.vistaCliente;
import Vista.vistaVeterinario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author julian
 */
public class CtrlCliente2 implements ActionListener{
  private Cliente clie2;
  private ConsultaCliente modJ;
  private vistaCliente frm777;
  
//constructor de clase
    public CtrlCliente2 (Cliente clie2, ConsultaCliente modJ, vistaCliente frm777){
      this.clie2 = clie2;
      this.modJ = modJ;
      this.frm777 = frm777;
      
      //botones
      this.frm777.btnCrearCliente33.addActionListener(this); 
    }
    //metodo para iniciar la vista
    public void iniciar(){
      frm777.setTitle("Cliente");
      frm777.setLocationRelativeTo(null);
    }
    
    //clics botones   
    @Override
    public void actionPerformed(ActionEvent e) {
    
        //detectar que boton se preciona
         if(e.getSource() == frm777.btnCrearCliente33){
        //tomar valores de caja de texto y meterlos al modelo
      

        
        clie2.setContraCliente(frm777.perro.getText());
        clie2.setCorreoCliente(frm777.txtCorreoClie.getText());
//        clie.setIdCliente(Integer.parseInt(frm7.txt_id.getText()));
        clie2.setNombreCliente(frm777.txtNombreCliente.getText());
        clie2.setNumeroCedula(Integer.parseInt(frm777.txtCedulaCliente.getText()));
        clie2.setTelefonoCliente(Integer.parseInt(frm777.txtTelefono.getText()));
        clie2.setUbicacionCliente(frm777.txtUbicaCliente.getText());
        clie2.setUsuarioCliente(frm777.ccc.getText());
        
        //paa.setHistorial(frm4.);
       
       
    
    }
    
    
        
    }
         
         
    }
    
    
    
    

