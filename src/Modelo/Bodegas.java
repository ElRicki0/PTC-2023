/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Javier
 */
public class Bodegas {
    private int idBodega;
    private String bdg_nombre;
    private String bdg_ubicacion;
    private String bdg_correo;

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getBdg_nombre() {
        return bdg_nombre;
    }

    public void setBdg_nombre(String bdg_nombre) {
        this.bdg_nombre = bdg_nombre;
    }

    public String getBdg_ubicacion() {
        return bdg_ubicacion;
    }

    public void setBdg_ubicacion(String bdg_ubicacion) {
        this.bdg_ubicacion = bdg_ubicacion;
    }

    public String getBdg_correo() {
        return bdg_correo;
    }

    public void setBdg_correo(String bdg_correo) {
        this.bdg_correo = bdg_correo;
    }
    
}
