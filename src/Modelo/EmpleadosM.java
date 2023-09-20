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
import java.util.HashMap;
import java.util.Map;
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
    
    public void llenarCBXGenero(JComboBox combox){
    Connection conectar = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select idGenero, Genero from tbGeneros";
    combox.removeAllItems();
    Map<Integer, String> idGenero = new HashMap<>();
    
        try {
            conectar=CConexion.getConexion();
            ps=conectar.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("idGenero");
                String genero = rs.getString("Genero");
                idGenero.put(id, genero);
                combox.addItem(genero);
            }
            combox.putClientProperty("idGenero", idGenero);
            
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error cbx genero "+e.toString());
        }finally{
            if (conectar!=null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar=null;
                    rs=null;
                    
                } catch (Exception e) {
                }
            }
        }
        
//        String sql="select idGenero from tbGeneros";
//        Statement st;
//    CConexion con = new CConexion();
//    Connection conexion=con.getConexion();
//        try {
//            st= conexion.createStatement();
//            ResultSet rs= st.executeQuery(sql) ;
//            while(rs.next()){
//                combox.addItem(rs.getString("idGenero"));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error en idgenero cbx "+ e.toString());
//        }
    }
    
    public void llenarCBXTipo(JComboBox combox){
        
        Connection conectar = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select idTipoEmpleado, Tipo_Emp from tbTiposEmpleados";
    combox.removeAllItems();
    Map<Integer, String> idTipoEmpleado = new HashMap<>();
    
        try {
            conectar=CConexion.getConexion();
            ps=conectar.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("idTipoEmpleado");
                String TEmpleado = rs.getString("Tipo_Emp");
                idTipoEmpleado.put(id, TEmpleado);
                combox.addItem(TEmpleado);
            }
            combox.putClientProperty("idTipoEmpleado", idTipoEmpleado);
            
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error cbx T. Empleado "+e.toString());
        }finally{
            if (conectar!=null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar=null;
                    rs=null;
                    
                } catch (Exception e) {
                }
            }
        }
    }
    
    public boolean AgregarEmpleado(EmpleadosM modeloEmpleados, JComboBox jcbGenero){        
        try {
            
            String sql="insert into tbEmpleados(emp_nombre,emp_fecha, emp_direccion, emp_telefono, emp_correo, idGenero, idTipoEmpleado) values(?, ?, ?, ?, ?, ?, 1)";

        
        PreparedStatement AEmpleado= CConexion.getConexion().prepareStatement(sql);
        AEmpleado.setString(1, modeloEmpleados.getEmp_nombre());
        AEmpleado.setString(2, modeloEmpleados.getEmp_fecha());
        AEmpleado.setString(3, modeloEmpleados.getEmp_direccion());
        AEmpleado.setString(4, modeloEmpleados.getEmp_telefono());
        AEmpleado.setString(5, modeloEmpleados.getEmp_correo());
        
        int SelectGenero= jcbGenero.getSelectedIndex();
            if (SelectGenero!=-1) {
                Map<Integer, String> idGenero = (Map<Integer, String>)jcbGenero.getClientProperty("idGenero");
                int selID=(int) idGenero.keySet().toArray()[SelectGenero];
                AEmpleado.setInt(6, selID);
            } else {
            }
        
        AEmpleado.execute();
        JOptionPane.showMessageDialog(null, "El Empleado se agrego correctamente");            
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error en agregar empleado "+ e.toString()); 
        }
        return true;
    }
    
    public boolean MAgregarEmpleado(EmpleadosM modeloEmpleados, JComboBox jcbGenero, JComboBox jcbTipo ){
        try {
            
            String sql="insert into tbEmpleados(emp_nombre,emp_fecha, emp_direccion, emp_telefono, emp_correo, idGenero, idTipoEmpleado) "
                    + "values(?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement ANEmpleado= CConexion.getConexion().prepareStatement(sql);
        ANEmpleado.setString(1, modeloEmpleados.getEmp_nombre());
        ANEmpleado.setString(2, modeloEmpleados.getEmp_fecha());
        ANEmpleado.setString(3, modeloEmpleados.getEmp_direccion());
        ANEmpleado.setString(4, modeloEmpleados.getEmp_telefono());
        ANEmpleado.setString(5, modeloEmpleados.getEmp_correo());
        
        int SelectGenero= jcbGenero.getSelectedIndex();
            if (SelectGenero!=-1) {
                Map<Integer, String> idGenero = (Map<Integer, String>)jcbGenero.getClientProperty("idGenero");
                int selID=(int) idGenero.keySet().toArray()[SelectGenero];
                ANEmpleado.setInt(6, selID);
            } else {
            }  
            
        int SelectTEmpl= jcbTipo.getSelectedIndex();
            if (SelectTEmpl!=-1) {
                Map<Integer, String> idTipoEmpleado = (Map<Integer, String>)jcbTipo.getClientProperty("idTipoEmpleado");
                int selTEP=(int) idTipoEmpleado.keySet().toArray()[SelectTEmpl];
                ANEmpleado.setInt(7, selTEP);
            } else {
            }     
        ANEmpleado.execute();
        JOptionPane.showMessageDialog(null, "El Empleado  se agrego correctamente123");
        } catch (Exception e) {
            System.out.println(e);        
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
    
    public void actualizar(EmpleadosM modeloEmpleados, JComboBox jcbGenero, JComboBox jcbTipo, VEmpleados vistaEmpleados){  

         try {
            
            String sql="update tbEmpleados set emp_nombre=?, emp_fecha=?, emp_direccion=?, emp_telefono=?, emp_correo=?, idGenero=?, idTipoEmpleado=? where idEmpleado=?";
        
        PreparedStatement UEmpleado= CConexion.getConexion().prepareStatement(sql);
        UEmpleado.setString(1, modeloEmpleados.getEmp_nombre());
        UEmpleado.setString(2, modeloEmpleados.getEmp_fecha());
        UEmpleado.setString(3, modeloEmpleados.getEmp_direccion());
        UEmpleado.setString(4, modeloEmpleados.getEmp_telefono());
        UEmpleado.setString(5, modeloEmpleados.getEmp_correo());
        
        int SelectGenero= jcbGenero.getSelectedIndex();
            if (SelectGenero!=-1) {
                Map<Integer, String> idGenero = (Map<Integer, String>)jcbGenero.getClientProperty("idGenero");
                int selID=(int) idGenero.keySet().toArray()[SelectGenero];
                UEmpleado.setInt(6, selID);
            } else {
            }  
            
        int SelectTEmpl= jcbTipo.getSelectedIndex();
            if (SelectTEmpl!=-1) {
                Map<Integer, String> idTipoEmpleado = (Map<Integer, String>)jcbTipo.getClientProperty("idTipoEmpleado");
                int selTEP=(int) idTipoEmpleado.keySet().toArray()[SelectTEmpl];
                UEmpleado.setInt(7, selTEP);
            } else {
            }     
        
        int filaSeleccionada = vistaEmpleados.tbTEmpleados.getSelectedRow();  
        String miId = vistaEmpleados.tbTEmpleados.getValueAt(filaSeleccionada, 0).toString();    
        UEmpleado.setString(8, miId);   
        UEmpleado.execute();
        JOptionPane.showMessageDialog(null, "El Empleado  se Modifico correctamente123");
        } catch (Exception e) {
            System.out.println(e);        
        }

          
     }
    
    public void MostrarEmpleados(VEmpleados vistaEmpleados){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID","Nombre", "Fecha Nacimiento", "Direccion", "Telefono","Correo", "Genero", "Tipo Empleado"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql ="select idEmpleado, emp_nombre, emp_fecha, emp_direccion, emp_telefono, emp_correo, tbGeneros.Genero,  tbTiposEmpleados.Tipo_Emp from tbEmpleados inner join tbGeneros on tbEmpleados.idGenero=tbGeneros.idGenero inner join tbTiposEmpleados on tbEmpleados.idTipoEmpleado=tbTiposEmpleados.idTipoEmpleado";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idEmpleado"), rs.getString("emp_nombre"), rs.getString("emp_fecha"), rs.getString("emp_direccion"), rs.getString("emp_telefono"), rs.getString("emp_correo"),rs.getString("Genero"), rs.getString("Tipo_Emp")});
            }
            vistaEmpleados.tbTEmpleados.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla empleados "+e.getMessage());                
        }
    }
    
    ///////////////////////////////Controlador /////////////////////////////////////////////
}
