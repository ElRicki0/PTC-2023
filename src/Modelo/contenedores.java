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
public class contenedores {
    private int idContenedor;
    private String ctd_nombre;
    private String ctd_empresa;
    private String ctd_correo;
    private int idProducto;
    private int idPqueteria;

    public int getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(int idContenedor) {
        this.idContenedor = idContenedor;
    }

    public String getCtd_nombre() {
        return ctd_nombre;
    }

    public void setCtd_nombre(String ctd_nombre) {
        this.ctd_nombre = ctd_nombre;
    }

    public String getCtd_empresa() {
        return ctd_empresa;
    }

    public void setCtd_empresa(String ctd_empresa) {
        this.ctd_empresa = ctd_empresa;
    }

    public String getCtd_correo() {
        return ctd_correo;
    }

    public void setCtd_correo(String ctd_correo) {
        this.ctd_correo = ctd_correo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPqueteria() {
        return idPqueteria;
    }

    public void setIdPqueteria(int idPqueteria) {
        this.idPqueteria = idPqueteria;
    }
    
}
