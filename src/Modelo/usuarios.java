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
public class usuarios {
    private int idUsuario;
    private String usr_nombre;
    private String usr_contra;
    private int idEmpleado;
    private int idnivelUser;
    private int idBodega;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsr_nombre() {
        return usr_nombre;
    }

    public void setUsr_nombre(String usr_nombre) {
        this.usr_nombre = usr_nombre;
    }

    public String getUsr_contra() {
        return usr_contra;
    }

    public void setUsr_contra(String usr_contra) {
        this.usr_contra = usr_contra;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdnivelUser() {
        return idnivelUser;
    }

    public void setIdnivelUser(int idnivelUser) {
        this.idnivelUser = idnivelUser;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }
    
}
