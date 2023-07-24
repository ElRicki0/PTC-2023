/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.JOptionPane;

public class EmpleadosM {
    private int idEmpleado;
    private String Emp_nombre;
    private String Emp_documento;
    private String Emp_fecha;
    private String Emp_direccion;
    private String Emp_telefono;
    private String Emp_correo;
    private String idGenero;
    private int idTipoEmpleado;

    public String getEmp_telefono() {
        return Emp_telefono;
    }

    public void setEmp_telefono(String Emp_telefono) {
        this.Emp_telefono = Emp_telefono;
    }

    public String getEmp_fecha() {
        return Emp_fecha;
    }

    public void setEmp_fecha(String Emp_fecha) {
        this.Emp_fecha = Emp_fecha;
    }
       
    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
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
    
    public void llenarCMB(JComboBox combo1){
        String sql="select idGenero from tbGeneros";
        Statement st;
        CConexion con = new CConexion();
        Connection conexion = con.getConexion();
        try {
            st= conexion.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                combo1.addItem(rs.getString("idGenero"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en cmdgenero "+ e.toString());
        }
    }
    public boolean AgregarEmpleado(EmpleadosM modeloEmpleados){
        String sql="insert into tbEmpleados(emp_nombre,emp_fecha, emp_direccion, emp_telefono, emp_correo, idGenero) values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement AEmpleado= CConexion.getConexion().prepareStatement(sql);
            AEmpleado.setString(1, modeloEmpleados.getEmp_nombre());
            AEmpleado.setString(2, modeloEmpleados.getEmp_fecha());
            AEmpleado.setString(3, modeloEmpleados.getEmp_direccion());
            AEmpleado.setString(4, modeloEmpleados.getEmp_telefono());
            AEmpleado.setString(5, modeloEmpleados.getEmp_correo());
            AEmpleado.setInt(6, Integer.parseInt(modeloEmpleados.getIdGenero()));

            JOptionPane.showMessageDialog(null, "El Empleado  se agrego correctamente");        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar empleado " +e.toString());        
        }
        return true;
    }
    
}
