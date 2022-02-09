/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Controlador;

import Modulo.ConsultaVeterinario;
import Modulo.Veterinario;
import Modulo.DireccionVeterinario;
import Vista.tablaServicio;
import Vista.tablaVeterinario;
import Vista.vistaadministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author julian
 */
public  class CtrlVeterinario implements ActionListener{
    private Veterinario vet1;
    private DireccionVeterinario vet2;
    private ConsultaVeterinario modC;
    private vistaadministrador frm;
    private tablaVeterinario frm28;
    private tablaServicio frm2811;

    
    
    //constructor de clase
    public CtrlVeterinario(Veterinario vet1,DireccionVeterinario vet2, ConsultaVeterinario modC, vistaadministrador frm, tablaVeterinario frm28){
      this.vet1 = vet1;
      this.vet2 = vet2;
      this.modC = modC;
      this.frm = frm;
      this.frm28 = frm28;
    
      
      
//botones
      this.frm.botonActualizarVet.addActionListener(this);
      this.frm.botonCrearVet.addActionListener(this);
      this.frm.botonEliminarVet.addActionListener(this);
      //this.frm.botonLeerVet.addActionListener(this);
    }
    
//metodo para iniciar vista
    public void iniciar(){
      frm.setTitle("Veterinario");
      frm.setLocationRelativeTo(null);
      
      
    }
    
//clics botones   
    @Override
    public void actionPerformed(ActionEvent e) {
    //detectar que boton se preciona
    if(e.getSource() == frm.botonCrearVet){
        //tomar valores de caja de texto y meterlos al modelo
        vet1.setMapsVet(frm.txtMaps.getText());
        vet2.setTelefonoVet(Integer.parseInt(frm.c.getText()));
        vet1.setContrasennVet(frm.txtContra.getText());
        vet2.setCorreoVet(frm.txtCorreoVet1.getText());
        vet2.setSennasVet(frm.txtSennasVet.getText());
        vet2.setWebVet(frm.txtWebVe.getText());
        vet2.setWebVet(frm.txtSociales.getText());
        //mod.s(frm.txtNickVet.getText());
        vet1.setNombreVet(frm.txtNombreVet.getText());
        vet2.setProvinciaVet(frm.box_provincia.getSelectedItem().toString());
        vet2.setDistritoVet(frm.box_can2.getSelectedItem().toString());
        vet2.setDistritoVet(frm.box_dis1.getSelectedItem().toString());
        vet1.setHorarioAtencioVet(frm.box_hor2.getSelectedItem().toString());
        
    if (modC.registrar(vet1, vet2)){
            JOptionPane.showMessageDialog(null, "Registro guardado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
  
    //detectar que boton se preciona
    if(e.getSource() == frm.botonActualizarVet){
         //tomar valores de caja de texto y metrlos al modelo
         vet1.setIdVete(Integer.parseInt(frm.txtIdConsultas.getText()));
        vet1.setMapsVet(frm.txtMaps.getText());
        //vet2.setTelefonoVet(Integer.parseInt(frm.txtCelVet2.getText()));
        vet1.setContrasennVet(frm.txtContra.getText());
        vet2.setCorreoVet(frm.c.getText());
        vet2.setSennasVet(frm.txtSennasVet.getText());
        vet2.setWebVet(frm.txtWebVe.getText());
        vet2.setWebVet(frm.txtSociales.getText());
        //mod.s(frm.txtNickVet.getText());
        vet1.setNombreVet(frm.txtNombreVet.getText());
        vet2.setProvinciaVet(frm.box_provincia.getSelectedItem().toString());
        vet2.setDistritoVet(frm.box_can2.getSelectedItem().toString());
        vet2.setDistritoVet(frm.box_dis1.getSelectedItem().toString());
        vet1.setHorarioAtencioVet(frm.box_hor2.getSelectedItem().toString());
        
    if (modC.modificar(vet1, vet2)){
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
     if(e.getSource() == frm.botonEliminarVet){
         //tomar valores de caja de texto y metrlos al modelo
         vet1.setIdVete(Integer.parseInt(frm.txtIdConsultas.getText()));
       
        
        
    if (modC.eliminar(vet1, vet2)){
            JOptionPane.showMessageDialog(null, "Registro eliminado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }  
} 

    
    }

    

    


