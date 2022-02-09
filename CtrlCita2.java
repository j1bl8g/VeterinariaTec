/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modulo.Cita;
import Modulo.ConsultaCita;
import Vista.tablaCita;
import Vista.vistaVeterinario;
import Vista.vistaadministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author julian
 */
public class CtrlCita2 implements ActionListener{
  private Cita cit;
  private ConsultaCita modH;
  private vistaVeterinario frm3;
  private tablaCita frm333;
  
  //constructor de clase
    public CtrlCita2(Cita cit, ConsultaCita modH, vistaVeterinario frm3, tablaCita frm333){
      this.cit = cit;
      this.modH = modH;
      this.frm3 = frm3;
      this.frm333 = frm333;
      
      //botones
      this.frm3.botonCrearCita.addActionListener(this);
      this.frm3.botonEliminarCita.addActionListener(this);
      this.frm3.botonActCita.addActionListener(this);
      //this.frm3.botonLeerVet.addActionListener(this);
    }
    
    //metodo para iniciar la vista
    public void iniciar(){
      frm3.setTitle("Cita");
      frm3.setLocationRelativeTo(null);
    }
    
    //clics botones   
    @Override
    public void actionPerformed(ActionEvent e) {
    
    //detectar que boton se preciona
    if(e.getSource() == frm3.botonCrearCita){
        //tomar valores de caja de texto y meterlos al modelo
        cit.setEstadoCitas(frm3.box_estadoCita.getSelectedItem().toString());
        
        
        
    if (modH.registrar(cit)){
            JOptionPane.showMessageDialog(null, "Registro guardado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
    
    if(e.getSource() == frm3.botonEliminarCita){
         //tomar valores de caja de texto y metrlos al modelo
         cit.setIdCistas(Integer.parseInt(frm3.txtidCita.getText()));
       
        
        
    if (modH.eliminar(cit)){
            JOptionPane.showMessageDialog(null, "Registro eliminado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
    if(e.getSource() == frm3.botonActCita){
         //tomar valores de caja de texto y metrlos al modelo
        cit.setIdCistas(Integer.parseInt(frm3.txtidCita.getText()));
        
        
        
    if (modH.modificar(cit)){
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
}  
}
