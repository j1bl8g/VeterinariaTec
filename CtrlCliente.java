/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Controlador;

import Modulo.Cliente;
import Modulo.ConsultaCliente;
import Vista.vistaVeterinario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author julian
 */
public class CtrlCliente implements ActionListener{
  private Cliente clie;
  private ConsultaCliente modJ;
  private vistaVeterinario frm7;
  
  
  //constructor de clase
    public CtrlCliente(Cliente clie, ConsultaCliente modJ, vistaVeterinario frm7){
      this.clie = clie;
      this.modJ = modJ;
      this.frm7 = frm7;
      
      //botones
      this.frm7.botonCrearCliente.addActionListener(this);
      this.frm7.deleteClie.addActionListener(this);
      this.frm7.botonActCita.addActionListener(this);
      this.frm7.UpdateCliente.addActionListener(this);
      
      //this.frm3.botonLeerVet.addActionListener(this);
    }
    
    //metodo para iniciar la vista
    public void iniciar(){
      frm7.setTitle("Cliente");
      frm7.setLocationRelativeTo(null);
    }
    
    //clics botones   
    @Override
    public void actionPerformed(ActionEvent e) {
    
        //detectar que boton se preciona
         if(e.getSource() == frm7.botonCrearCliente){
        //tomar valores de caja de texto y meterlos al modelo
        //cat.setIdCategoria    (frm2.box_tipoSer.getSelectedItem().toString());;
        clie.setContraCliente(frm7.txtxContraClie.getText());
        clie.setCorreoCliente(frm7.txtCorreoCliente.getText());
//        clie.setIdCliente(Integer.parseInt(frm7.txt_id.getText()));
        clie.setNombreCliente(frm7.txtNombreCliente.getText());
        clie.setNumeroCedula(Integer.parseInt(frm7.txtCedCliente.getText()));
        clie.setTelefonoCliente(Integer.parseInt(frm7.txtUbiCliente.getText()));
        clie.setUbicacionCliente(frm7.txtUbiCliente.getText());
        clie.setUsuarioCliente(frm7.txtNomUsu.getText());
        
        //paa.setHistorial(frm4.);
       
       
    if (modJ.registrar(clie)){
            JOptionPane.showMessageDialog(null, "Cliente guardado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
    }
    
    //detectar que boton se preciona
    if(e.getSource() == frm7.UpdateCliente){
         //tomar valores de caja de texto y metrlos al modelo
        clie.setIdCliente(Integer.parseInt(frm7.txtConClie.getText())); //recolecta de GUI id, y update ese id
        clie.setContraCliente(frm7.txtxContraClie.getText());
        clie.setCorreoCliente(frm7.txtCorreoCliente.getText());
//        clie.setIdCliente(Integer.parseInt(frm7.txt_id.getText()));
        clie.setNombreCliente(frm7.txtNombreCliente.getText());
        clie.setNumeroCedula(Integer.parseInt(frm7.txtCedCliente.getText()));
        clie.setTelefonoCliente(Integer.parseInt(frm7.txtUbiCliente.getText()));
        clie.setUbicacionCliente(frm7.txtUbiCliente.getText());
        clie.setUsuarioCliente(frm7.txtNomUsu.getText());
        
        
        
        
    if (modJ.modificar(clie)){
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
    if(e.getSource() == frm7.deleteClie){
         //tomar valores de caja de texto y metrlos al modelo
         clie.setIdCliente(Integer.parseInt(frm7.txtConClie.getText()));
         
    if(modJ.eliminar(clie)){
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
         
         
    }
    
    
    
}



            
  
    
    
    
    
            
    
    
     
    

