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
public class Categoria {
  private String codCategoria;
  private String tipoCategoria;
  private String descripCategoria;
  private String estadoCategoria;
  private int idCategoria;

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombreCategoria() {
        return tipoCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.tipoCategoria = nombreCategoria;
    }

    public String getDescripCategoria() {
        return descripCategoria;
    }

    public void setDescripCategoria(String descripCategoria) {
        this.descripCategoria = descripCategoria;
    }

    public String getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(String estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
  
  
    
}
