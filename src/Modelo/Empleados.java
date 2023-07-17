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
public class Empleados {
    private int idEmpleado;
    private String Emp_nombre;
    private String Emp_documento;
    private String Emp_direccion;
    private String Emp_correo;
    private int idGenero;
    private int idTipoEmpleado;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEmp_nombre() {
        return Emp_nombre;
    }

    public void setEmp_nombre(String Emp_nombre) {
        this.Emp_nombre = Emp_nombre;
    }

    public String getEmp_documento() {
        return Emp_documento;
    }

    public void setEmp_documento(String Emp_documento) {
        this.Emp_documento = Emp_documento;
    }

    public String getEmp_direccion() {
        return Emp_direccion;
    }

    public void setEmp_direccion(String Emp_direccion) {
        this.Emp_direccion = Emp_direccion;
    }

    public String getEmp_correo() {
        return Emp_correo;
    }

    public void setEmp_correo(String Emp_correo) {
        this.Emp_correo = Emp_correo;
    }
    
}
