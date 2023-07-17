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
public class clientes {
    private int idCliente;
    private String clie_Nombre;
    private int clie_Edad;
    private String clie_telefono;
    private String clie_correo;
    private int idGenero;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getClie_Nombre() {
        return clie_Nombre;
    }

    public void setClie_Nombre(String clie_Nombre) {
        this.clie_Nombre = clie_Nombre;
    }

    public int getClie_Edad() {
        return clie_Edad;
    }

    public void setClie_Edad(int clie_Edad) {
        this.clie_Edad = clie_Edad;
    }

    public String getClie_telefono() {
        return clie_telefono;
    }

    public void setClie_telefono(String clie_telefono) {
        this.clie_telefono = clie_telefono;
    }

    public String getClie_correo() {
        return clie_correo;
    }

    public void setClie_correo(String clie_correo) {
        this.clie_correo = clie_correo;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
}
