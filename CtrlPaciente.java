/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Controlador;


import Modulo.ConsultaPaciente;
import Modulo.Paciente;
import Vista.vistaVeterinario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

    /**
 *
 * @author julian
 */    
    public  class CtrlPaciente implements ActionListener{
    private Paciente paa;
    private ConsultaPaciente modZ;
    private vistaVeterinario frm4;
    
    //constructor de clase
    public CtrlPaciente(Paciente paa, ConsultaPaciente modZ, vistaVeterinario frm4 ){
      this.paa = paa;
      this.modZ = modZ;
      this.frm4 = frm4;
      
      //botones
      this.frm4.botonCrearPaa.addActionListener(this);
      this.frm4.botonActPaa.addActionListener(this);
      this.frm4.botonEliminarPaa.addActionListener(this);
      //this.frm2.botonLeerVet.addActionListener(this);
    }
    
//metodo para iniciar vista
    public void iniciar(){
      frm4.setTitle("Paciente");
      frm4.setLocationRelativeTo(null);
    }
    
//clics botones   
    @Override
    public void actionPerformed(ActionEvent e) {
    
//detectar que boton se preciona
    if(e.getSource() == frm4.botonCrearPaa){
        //tomar valores de caja de texto y meterlos al modelo
        //cat.setIdCategoria    (frm2.box_tipoSer.getSelectedItem().toString());;
        paa.setRaza(frm4.txtRaza.getText());
        paa.setNombrePaciente(frm4.txtnombrePaa.getText());
        paa.setEdadPaciente(Integer.parseInt(frm4.txtedadPaa.getText()));
        //paa.setHistorial(frm4.);
       
       
    if (modZ.registrar(paa)){
            JOptionPane.showMessageDialog(null, "Paciente guardado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
    }
            
  //detectar que boton se preciona
    if(e.getSource() == frm4.botonActPaa){
         //tomar valores de caja de texto y metrlos al modelo
        paa.setIdPaciente(Integer.parseInt(frm4.txtIdSer.getText()));
        paa.setRaza(frm4.txtedadPaa.getText());
        paa.setNombrePaciente(frm4.txtnombrePaa.getText());
        paa.setEdadPaciente(Integer.parseInt(frm4.txtedadPaa.getText()));
        
        
    if (modZ.modificar(paa)){
            JOptionPane.showMessageDialog(null, "Paciente modificado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }       
    }
    
    if(e.getSource() == frm4.botonEliminarPaa){
         //tomar valores de caja de texto y metrlos al modelo
         paa.setIdPaciente(Integer.parseInt(frm4.txtIdSer.getText()));
         
    if(modZ.eliminar(paa)){
            JOptionPane.showMessageDialog(null, "Paciente eliminado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
    
    
    
            
    
    
     
    
} 
    }
    
    
      

