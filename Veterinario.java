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
public class Veterinario {
  private int idVete;
  private String nombreVet;
  private String fechaVet;
  private String horarioAtencioVet;
  private String mapsVet;
  private String nombreUsuarioVet;
  private String contrasennVet;
  private String correoVet;

    public String getCorreoVet() {
        return correoVet;
    }

    public void setCorreoVet(String correoVet) {
        this.correoVet = correoVet;
    }

    public String getNombreUsuarioVet() {
        return nombreUsuarioVet;
    }

    public void setNombreUsuarioVet(String nombreUsuarioVet) {
        this.nombreUsuarioVet = nombreUsuarioVet;
    }

    public String getContrasennVet() {
        return contrasennVet;
    }

    public void setContrasennVet(String contrasennVet) {
        this.contrasennVet = contrasennVet;
    }
  
    public int getIdVete() {
        return idVete;
    }
    public void setIdVete(int idVete) {
        this.idVete = idVete;
    }
    public String getNombreVet() {
        return nombreVet;
    }
    public void setNombreVet(String nombreVet) {
        this.nombreVet = nombreVet;
    }
    public String getFechaVet() {
        return fechaVet;
    }
    public void setFechaVet(String fechaVet) {
        this.fechaVet = fechaVet;
    }
    public String getHorarioAtencioVet() {
        return horarioAtencioVet;
    }
    public void setHorarioAtencioVet(String horarioAtencioVet) {
        this.horarioAtencioVet = horarioAtencioVet;
    }
    public String getMapsVet() {
        return mapsVet;
    }
    public void setMapsVet(String mapsVet) {
        this.mapsVet = mapsVet;
    }    
}
