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
public class tiendas {
    private int idTienda;
    private String Tien_nombre;
    private String Tien_direccion;
    private String Tien_ReferenciasLDireccion;
    private String Tien_Correo;

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getTien_nombre() {
        return Tien_nombre;
    }

    public void setTien_nombre(String Tien_nombre) {
        this.Tien_nombre = Tien_nombre;
    }

    public String getTien_direccion() {
        return Tien_direccion;
    }

    public void setTien_direccion(String Tien_direccion) {
        this.Tien_direccion = Tien_direccion;
    }

    public String getTien_ReferenciasLDireccion() {
        return Tien_ReferenciasLDireccion;
    }

    public void setTien_ReferenciasLDireccion(String Tien_ReferenciasLDireccion) {
        this.Tien_ReferenciasLDireccion = Tien_ReferenciasLDireccion;
    }

    public String getTien_Correo() {
        return Tien_Correo;
    }

    public void setTien_Correo(String Tien_Correo) {
        this.Tien_Correo = Tien_Correo;
    }
}
