/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import Vista.Producto;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Javier
 */
public class MarcaProductos {
    private int id_MP;
    private String MP_nombre;
    private String MP_NumeroContacto;
    private String MP_correo;

    public int getId_MP() {
        return id_MP;
    }

    public void setId_MP(int id_MP) {
        this.id_MP = id_MP;
    }

    public String getMP_nombre() {
        return MP_nombre;
    }

    public void setMP_nombre(String MP_nombre) {
        this.MP_nombre = MP_nombre;
    }

    public String getMP_NumeroContacto() {
        return MP_NumeroContacto;
    }

    public void setMP_NumeroContacto(String MP_NumeroContacto) {
        this.MP_NumeroContacto = MP_NumeroContacto;
    }

    public String getMP_correo() {
        return MP_correo;
    }

    public void setMP_correo(String MP_correo) {
        this.MP_correo = MP_correo;
    }
    
    
    public boolean AgregarMarca(MarcaProductos marcamodelo){
        String SQL="insert into tbMarcaProductos (MP_Nombre, MP_NumeroContacto, MP_Correo) values(?,?,?)";
        try {
            PreparedStatement AMarca = CConexion.getConexion().prepareStatement(SQL);
            AMarca.setString(1, marcamodelo.getMP_nombre());
            AMarca.setString(2, marcamodelo.getMP_NumeroContacto());
            AMarca.setString(3, marcamodelo.getMP_correo());
            AMarca.executeUpdate();
            JOptionPane.showMessageDialog(null, "La Marca se agrego correctamente");
            Producto ProductoVista = new Producto();
            ProductoVista.MostrarMarcas();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO marca"+ e.toString());                        
            return false;
        }
    }
}
