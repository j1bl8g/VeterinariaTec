/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Controlador;

import Modulo.ConsultaServicio;
import Modulo.Servicio;
import Vista.vistaVeterinario;
import Vista.vistaadministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author julian
 */
    public  class CtrlServicio implements ActionListener{
    private Servicio ser1;
    private ConsultaServicio modW;
    private vistaVeterinario frm5;
    
    //constructor de clase
    public CtrlServicio(Servicio ser1, ConsultaServicio modW, vistaVeterinario frm5){
      this.ser1 = ser1;
      this.modW = modW;
      this.frm5 = frm5;
      
//botones
      this.frm5.botonCrearSer.addActionListener(this);
      this.frm5.botonEliminarServicio.addActionListener(this);
      this.frm5.botonActualizarSer.addActionListener(this);
      //this.frm2.botonLeerVet.addActionListener(this);
    }
    
//metodo para iniciar vista
    public void iniciar(){
      frm5.setTitle("Servicio");
      frm5.setLocationRelativeTo(null);
    }
    
//clics botones   
    @Override
    public void actionPerformed(ActionEvent e) {
    
//detectar que boton se preciona
    if(e.getSource() == frm5.botonCrearSer){
        //tomar valores de caja de texto y meterlos al modelo
        ser1.setTipoServ(frm5.box_tipoSer.getSelectedItem().toString());;
        ser1.setCodigoServ(Integer.parseInt(frm5.txtCodigoSer.getText()));
        ser1.setDescripServ(frm5.txtDescripSer.getText());
        ser1.setEstadoServ(frm5.box_estadoSer.getSelectedItem().toString());
        ser1.setMontoExtraServ(Integer.parseInt(frm5.txtExtraSer.getText()));
        ser1.setMontoExtraServ(Integer.parseInt(frm5.txtmontoSer1.getText()));
        
       
    if (modW.registrar(ser1)){
            JOptionPane.showMessageDialog(null, "Registro guardado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
    }
            
  
    //detectar que boton se preciona
    if(e.getSource() == frm5.botonActualizarSer){
         //tomar valores de caja de texto y metrlos al modelo
        //ser1.setId_serv(Integer.parseInt(frm5.txtIdSer.getText()));
        ser1.setTipoServ(frm5.box_tipoSer.getSelectedItem().toString());;
        ser1.setCodigoServ(Integer.parseInt(frm5.txtCodigoSer.getText()));
        ser1.setDescripServ(frm5.txtDescripSer.getText());
        ser1.setEstadoServ(frm5.box_estadoSer.getSelectedItem().toString());
        ser1.setMontoExtraServ(Integer.parseInt(frm5.txtExtraSer.getText()));
        ser1.setMontoExtraServ(Integer.parseInt(frm5.txtmontoSer1.getText()));
        
        
    if (modW.modificar(ser1)){
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
     if(e.getSource() == frm5.botonEliminarServicio){
         //tomar valores de caja de texto y metrlos al modelo
         ser1.setId_serv(Integer.parseInt(frm5.txtIdSer.getText()));
         
    if(modW.eliminar(ser1)){
            JOptionPane.showMessageDialog(null, "Registro eliminado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
     
     //if(e.getSource() == frm5.){
     
     
     
     
    
     
    
} 
    }
    
    
