/*
 * Bases Datos
 * Proyecto I
 * Tec
 * 2020
 */
package Modulo;

/**
 *
 * @author julian
 */
public class DireccionVeterinario {
  //table direccion veterinario
  private int id_direcVet;  
  private String provinciaVet;
  private String distritoVet;
  private String sennasVet;
  private int telefonoVet;
  private String correoVet;
  private String webVet;
    
    public int getIdDirecVet(){
        return id_direcVet;
    }
    public void setIdDirectVet(int id_directVet){
        this.id_direcVet = id_direcVet;
    }
    public String getProvinciaVet() {
        return provinciaVet;
    }

    public void setProvinciaVet(String provinciaVet) {
        this.provinciaVet = provinciaVet;
    }

    public String getDistritoVet() {
        return distritoVet;
    }

    public void setDistritoVet(String distritoVet) {
        this.distritoVet = distritoVet;
    }

    public String getSennasVet() {
        return sennasVet;
    }

    public void setSennasVet(String sennasVet) {
        this.sennasVet = sennasVet;
    }

    public int getTelefonoVet() {
        return telefonoVet;
    }

    public void setTelefonoVet(int telefonoVet) {
        this.telefonoVet = telefonoVet;
    }

    public String getCorreoVet() {
        return correoVet;
    }

    public void setCorreoVet(String correoVet) {
        this.correoVet = correoVet;
    }

    public String getWebVet() {
        return webVet;
    }

    public void setWebVet(String webVet) {
        this.webVet = webVet;
    }
    
}
