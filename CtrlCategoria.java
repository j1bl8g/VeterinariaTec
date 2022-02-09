/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Controlador;

import Modulo.Categoria;
import Modulo.ConsultaCategoria;
import Vista.vistaadministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author julian
 */
    public  class CtrlCategoria implements ActionListener{
    private Categoria cat;
    private ConsultaCategoria modS;
    private vistaadministrador frm2;
    
    //constructor de clase
    public CtrlCategoria(Categoria cat, ConsultaCategoria modS, vistaadministrador frm2 ){
      this.cat = cat;
      this.modS = modS;
      this.frm2 = frm2;
      
//botones
      this.frm2.btnCrearCat.addActionListener(this);
      this.frm2.Delate1.addActionListener(this);
      this.frm2.Update1.addActionListener(this);
      //this.frm2.botonLeerVet.addActionListener(this);
    }
    
//metodo para iniciar vista
    public void iniciar(){
      frm2.setTitle("Categoria");
      frm2.setLocationRelativeTo(null);
    }
    
//clics botones   
    @Override
    public void actionPerformed(ActionEvent e) {
    
//detectar que boton se preciona
    if(e.getSource() == frm2.btnCrearCat){
        //tomar valores de caja de texto y meterlos al modelo
        //cat.setIdCategoria    (frm2.box_tipoSer.getSelectedItem().toString());;
        cat.setCodCategoria(frm2.boxcrearCat32.getSelectedItem().toString());
        cat.setDescripCategoria(frm2.txt_des.getText());
        cat.setEstadoCategoria(frm2.box_estado.getSelectedItem().toString());
        cat.setNombreCategoria(frm2.boxcrearCat3.getSelectedItem().toString());
       
       
    if (modS.registrar(cat)){
            JOptionPane.showMessageDialog(null, "Registro guardado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
    }
            
  
    //detectar que boton se preciona
    if(e.getSource() == frm2.Update1){
         //tomar valores de caja de texto y metrlos al modelo
        cat.setIdCategoria(Integer.parseInt(frm2.txtidCat3.getText()));
        cat.setCodCategoria(frm2.boxcrearCat3.getSelectedItem().toString());
        cat.setDescripCategoria(frm2.txt_des.getText());
        cat.setEstadoCategoria(frm2.box_estado.getSelectedItem().toString());
        cat.setNombreCategoria(frm2.boxcrearCat3.getSelectedItem().toString());
        
        
    if (modS.modificar(cat)){
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
     if(e.getSource() == frm2.Delate1){
         //tomar valores de caja de texto y metrlos al modelo
         cat.setIdCategoria(Integer.parseInt(frm2.txtidCat3.getText()));
         
    if(modS.eliminar(cat)){
            JOptionPane.showMessageDialog(null, "Registro eliminado");
        } else{
            JOptionPane.showMessageDialog(null, ":<");
        }
            
    }
    
     
    
} 
    }
