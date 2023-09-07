/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.beans.Statement;
import java.sql.*;
import Vista.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class clientes {
    private int idCliente;
    private String clie_Nombre;
    private int clie_Edad;
    private String clie_telefono;
    private String clie_correo;
    private String idGenero;

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

    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
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
    }
    
    public void AgregarCliente(clientes modeloCliente, JComboBox jcbGenero){
        String SQL = "insert into tbClientes(clie_Nombre, clie_Edad, clie_Telefono, clie_Correo, idGenero) values(?,?,?,?,?)";
        try {
            PreparedStatement ACliente = CConexion.getConexion().prepareStatement(SQL);
            ACliente.setString (1, modeloCliente.getClie_Nombre());
            ACliente.setInt(2, modeloCliente.getClie_Edad());
            ACliente.setString(3, modeloCliente.getClie_telefono());
            ACliente.setString (4, modeloCliente.getClie_correo());
            int SelectGenero= jcbGenero.getSelectedIndex();
            if (SelectGenero!=-1) {
                Map<Integer, String> idGenero = (Map<Integer, String>)jcbGenero.getClientProperty("idGenero");
                int selID=(int) idGenero.keySet().toArray()[SelectGenero];
                ACliente.setInt(5, selID);
            } else {
            }
            ACliente.executeUpdate();
            JOptionPane.showMessageDialog(null, "El cliente  se agrego correctamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en el modelo del cliente"+ e.toString());   
        }
    }
    
    public void MostrarTabla(VCliente vista){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID","Nombre", "Edad", "Telefono", "Correo","Genero"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql ="select idCliente, clie_Nombre, clie_Edad, clie_Telefono, clie_Correo, tbGeneros.Genero from tbClientes inner join tbGeneros on tbClientes.idGenero=tbGeneros.idGenero";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idCliente"), rs.getString("clie_Nombre"), rs.getInt("clie_Edad"), rs.getString("clie_Telefono"), rs.getString("clie_Correo"), rs.getString("Genero")});
            }
            vista.tbClientes.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla clientes "+e.getMessage());                
        }
    }
    
    public void eliminar(VCliente vistaCliente){
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vistaCliente.tbClientes.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vistaCliente.tbClientes.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbClientes where idCliente = '" + miId + "'");
                JOptionPane.showMessageDialog(null, "El cliente se elimino correctamente ");
                deleteUser.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "el cliente esta en uso , elimine el usuario antes del empleado wichi wzchi wa");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Seleccione un cliente para elminar");
        }        
    }
    
    public void Editar(VCliente vistaCliente, clientes modeloCliente, JComboBox jcbGenero){
        
        
        
        String SQL = "update tbClientes set clie_Nombre = ?, clie_Edad = ?, clie_Telefono=?, clie_Correo=?, idGenero=? where idCliente = ?";
        try {
            PreparedStatement UpCliente = CConexion.getConexion().prepareStatement(SQL);
            UpCliente.setString (1, modeloCliente.getClie_Nombre());
            UpCliente.setInt(2, modeloCliente.getClie_Edad());
            UpCliente.setString(3, modeloCliente.getClie_telefono());
            UpCliente.setString (4, modeloCliente.getClie_correo());
            
            int SelectGenero= jcbGenero.getSelectedIndex();
            if (SelectGenero!=-1) {
                Map<Integer, String> idGenero = (Map<Integer, String>)jcbGenero.getClientProperty("idGenero");
                int selID=(int) idGenero.keySet().toArray()[SelectGenero];
                UpCliente.setInt(5, selID);
            } else {
            }
            
            int filaSeleccionada = vistaCliente.tbClientes.getSelectedRow();  
            //Obtenemos el id de la fila seleccionada
            String miId = vistaCliente.tbClientes.getValueAt(filaSeleccionada, 0).toString();
            
            UpCliente.setString(6, miId);
            
            UpCliente.executeUpdate();
            JOptionPane.showMessageDialog(null, "El cliente  se modifico correctamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a modificar");   
        }
    }
}
