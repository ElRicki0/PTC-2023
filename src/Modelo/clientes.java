/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.beans.Statement;
import java.sql.*;
import Vista.*;
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
    
//    public void MostrarClientes(Cliente vistaClientes){
//        DefaultTableModel modelo= new DefaultTableModel();
//        modelo.setColumnIdentifiers(new Object[]{"ID Cliente", "Nombre", "Edad", "Telefono", "Correo", "Genero"});
//        try {
//            
//            java.sql.Statement st= CConexion.getConexion().createStatement();
//            String SQL ="select idCliente, clie_Nombre, clie_Edad, clie_Telefono, clie_Correo, tbGeneros.idGenero from tbClientes inner join tbGeneros on tbClientes.idGenero=tbGeneros.idGenero ";
//            ResultSet rs = st.executeQuery(SQL);
//            
//            while (rs.next()) {
//                modelo.addRow(new Object[]{rs.getInt("idCliente"), rs.getString("clie_Nombre"), rs.getInt("clie_Edad"), rs.getString("clie_Telefono"), rs.getString("clie_Correo"), rs.getInt("tbGeneros.idGenero")});
//            }
//            vistaClientes.tbClientes.setModel(modelo);
////            vistaClientes..setModel(modelo);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, " error en en tb cliente "+e.getMessage());                
//        }
//    }
    public void AgregarCliente(clientes modeloCliente){
        String SQL = "insert into tbClientes(clie_Nombre, clie_Edad, clie_Telefono, clie_Correo, idGenero) values(?,?,?,?,?)";
        try {
            PreparedStatement AProducto = CConexion.getConexion().prepareStatement(SQL);
            AProducto.setString (1, modeloCliente.getClie_Nombre());
            AProducto.setInt(2, modeloCliente.getClie_Edad());
            AProducto.setString(3, modeloCliente.getClie_telefono());
            AProducto.setString (4, modeloCliente.getClie_correo());
            AProducto.setInt(5, Integer.parseInt(modeloCliente.getIdGenero()));
            AProducto.executeUpdate();
            JOptionPane.showMessageDialog(null, "El cliente  se agrego correctamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en el modelo del cliente"+ e.toString());   
        }
    }
}
