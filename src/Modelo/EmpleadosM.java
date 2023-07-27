/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VEmpleados;
import Vista.PrimerEmpleado;
import Vista.PrimerUsuario;
import Vista.VEmpleados;
import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosM {
        
    private int idEmpleado;
    private String Emp_nombre;
    private String Emp_documento;
    private String Emp_fecha;
    private String Emp_direccion;
    private String Emp_telefono;
    private String Emp_correo;
    private String idGenero;
    private String idTipoEmpleado;

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

    public String getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(String idTipoEmpleado) {
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
            JOptionPane.showMessageDialog(null, "Error en cbx genero "+ e.toString());
        }
    }
    
    private PrimerEmpleado PMEmpleado;
    
    
    
    public boolean AgregarEmpleado(EmpleadosM modeloEmpleados, PrimerEmpleado vistaEmpleado){        
        try {
            
            String sql="insert into tbEmpleados(emp_nombre,emp_fecha, emp_direccion, emp_telefono, emp_correo, idGenero, idTipoEmpleado) values(?, ?, ?, ?, ?, ?, 1)";

        
        PreparedStatement AEmpleado= CConexion.getConexion().prepareStatement(sql);
        AEmpleado.setString(1, modeloEmpleados.getEmp_nombre());
        AEmpleado.setString(2, modeloEmpleados.getEmp_fecha());
        AEmpleado.setString(3, modeloEmpleados.getEmp_direccion());
        AEmpleado.setString(4, modeloEmpleados.getEmp_telefono());
        AEmpleado.setString(5, modeloEmpleados.getEmp_correo());
        AEmpleado.setInt(6, Integer.parseInt(modeloEmpleados.getIdGenero()));
        AEmpleado.execute();
        JOptionPane.showMessageDialog(null, "El Empleado  se agrego correctamente");            
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error en agregar empleado "+ e.toString()); 
        }
        return true;
    }
    
    public void llenarCBXGenero(JComboBox combox){
        String sql="select idGenero from tbGeneros";
        Statement st;
    CConexion con = new CConexion();
    Connection conexion=con.getConexion();
        try {
            st= conexion.createStatement();
            ResultSet rs= st.executeQuery(sql) ;
            while(rs.next()){
                combox.addItem(rs.getString("idGenero"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en idgenero cbx "+ e.toString());
        }
    }
    
    public void llenarCBXTipo(JComboBox combox){
        String sql="select idTipoEmpleado from tbTiposEmpleados";
        Statement st;
    CConexion con = new CConexion();
    Connection conexion=con.getConexion();
        try {
            st= conexion.createStatement();
            ResultSet rs= st.executeQuery(sql) ;
            while(rs.next()){
                combox.addItem(rs.getString("idTipoEmpleado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en tipo empleado cbx "+ e.toString());
        }
    }
    
    public boolean MAgregarEmpleado(EmpleadosM modeloEmpleados){
        try {
            
            String sql="insert into tbEmpleados(emp_nombre,emp_fecha, emp_direccion, emp_telefono, emp_correo, idGenero, idTipoEmpleado) "
                    + "values(?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement ANEmpleado= CConexion.getConexion().prepareStatement(sql);
        ANEmpleado.setString(1, modeloEmpleados.getEmp_nombre());
        ANEmpleado.setString(2, modeloEmpleados.getEmp_fecha());
        ANEmpleado.setString(3, modeloEmpleados.getEmp_direccion());
        ANEmpleado.setString(4, modeloEmpleados.getEmp_telefono());
        ANEmpleado.setString(5, modeloEmpleados.getEmp_correo());
        ANEmpleado.setInt(6, Integer.parseInt(modeloEmpleados.getIdGenero()));
        ANEmpleado.setInt(7, Integer.parseInt(modeloEmpleados.getIdTipoEmpleado()));
        ANEmpleado.execute();
        JOptionPane.showMessageDialog(null, "El Empleado  se agrego correctamente");
        } catch (Exception e) {
            System.out.println(e);        
            
        
        System.out.println("ESTE ES EL correo//"+           getEmp_correo().toString());
            System.out.println("ESTE ES EL direccion //"+   getEmp_direccion().toString());
            System.out.println("ESTE ES EL tipo  empleado///"+getIdTipoEmpleado().toString());
            System.out.println("ESTE ES EL fecha//"+        getEmp_fecha().toString());
            System.out.println("ESTE ES EL nombre//"+       getEmp_nombre().toString());
            System.out.println("ESTE ES EL telefono//"+     getEmp_telefono().toString());
            System.out.println("ESTE ES EL genero//"+       getIdGenero().toString());
        }
        return true;
    }
    
    public void eliminar(VEmpleados vistaEmpleados){
    
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = vistaEmpleados.tbTEmpleados.getSelectedRow();
        
        //Obtenemos el id de la fila seleccionada
        String miId = vistaEmpleados.tbTEmpleados.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbEmpleados where idEmpleado = '" + miId + "'");
            JOptionPane.showMessageDialog(null, "El empleado se elimino correctamente ");
            deleteUser.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "el empleado esta en uso por un usuario, elimine el usuario antes del empleado");                

        }
    }
    
     public void actualizar(VEmpleados vistaEmpleados){  

        //obtenemos que fila seleccionó el usuario

        int filaSeleccionada = vistaEmpleados.tbTEmpleados.getSelectedRow();  
        //Obtenemos el id de la fila seleccionada
        String miId = vistaEmpleados.tbTEmpleados.getValueAt(filaSeleccionada, 0).toString();        

       String nuevoValorIngresadoNombre = vistaEmpleados.txtNombre_emp.getText();
       String nuevoValorIngresadoFecha = vistaEmpleados.txtFN_emp.getText();
       String nuevoValorIngresadoDireccion = vistaEmpleados.txtDireccion_emp.getText();
       String nuevoValorIngresadoTelefono = vistaEmpleados.txtTelefono_emp.getText();
       String nuevoValorIngresadoCorreo = vistaEmpleados.txtCorreo_emp.getText(); 

        try {
            PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbEmpleados set emp_nombre = ?, emp_fecha = ?, emp_direccion=?, emp_telefono=?, emp_correo=? where idEmpleado = ?");
            updateUser.setString(1, nuevoValorIngresadoNombre);
            updateUser.setString(2, nuevoValorIngresadoFecha);
            updateUser.setString(3, nuevoValorIngresadoDireccion);
            updateUser.setString(4, nuevoValorIngresadoTelefono);
            updateUser.setString(5, nuevoValorIngresadoCorreo);
            updateUser.setString(6, miId);
            updateUser.executeUpdate();
        JOptionPane.showMessageDialog(null, "Se actualizo el empleado");                
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error Actualizar empleados "+e.getMessage());                

        }
     }


    
    public void MostrarEmpleados(VEmpleados vistaEmpleados){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"IDEmpleado","Nombre", "Fecha Nacimiento", "Direccion", "Telefono","Correo", "Genero", "Tipo Empleado"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql ="select idEmpleado, emp_nombre, emp_fecha, emp_direccion, emp_telefono, emp_correo, tbGeneros.Genero from tbEmpleados inner join tbGeneros on tbEmpleados.idGenero=tbGeneros.idGenero";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idEmpleado"), rs.getString("emp_nombre"), rs.getString("emp_fecha"), rs.getString("emp_direccion"), rs.getString("emp_telefono"), rs.getString("emp_correo"),rs.getString("Genero")});
            }
            vistaEmpleados.tbTEmpleados.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla empleados "+e.getMessage());                
        }
    }
    
}
