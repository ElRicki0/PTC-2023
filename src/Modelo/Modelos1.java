/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Controlador.CVehiculo_Modelo;
import Vista.VVehiculo_Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class Modelos1 {
    private int idModelo;
    private String modelo;
    private int Mo_anio;
    private String Marcavehiculo;

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMo_anio() {
        return Mo_anio;
    }

    public void setMo_anio(int Mo_anio) {
        this.Mo_anio = Mo_anio;
    }

    public String getMarcavehiculo() {
        return Marcavehiculo;
    }

    public void setMarcavehiculo(String Marcavehiculo) {
        this.Marcavehiculo = Marcavehiculo;
    }
    
    public void RellenarBuscadorCBX(JComboBox combo){
        combo.removeAllItems();
        String sql = "select Mo_marca from tbModelos";
        Statement st;
        CConexion con = new CConexion();
        Connection conexion = con.getConexion();
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString("Mo_marca"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en marca vehiculo buscador  " + e.toString());
        }
    }
    
    ////////////Administrador///////////////////////////////////////////////////////////
    public void Buscador(VVehiculo_Modelo vistaModelos){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Modelo","anualidad","Marca"});
        try {
            Statement st= CConexion.getConexion().createStatement();
                String SQL ="select *from tbModelos where Mo_marca='"+vistaModelos.jcbBuscador.getSelectedItem()+"'";
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idModelo"), rs.getString("Modelo"), rs.getString("Mo_anio"), rs.getString("Mo_marca")});
            }
            vistaModelos.tbModelos.setModel(modelo);            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error tabla modelos A "+e.getMessage());                
        }
    }
    
    public void MostrarTabla(VVehiculo_Modelo vistaModelos){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Modelo","anualidad","Marca"});
        try {
            Statement st= CConexion.getConexion().createStatement();
                String SQL ="select *from tbModelos";
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idModelo"), rs.getString("Modelo"), rs.getString("Mo_anio"), rs.getString("Mo_marca")});
            }
            vistaModelos.tbModelos.setModel(modelo);            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error tabla modelos A "+e.getMessage());                
        }
    }
    
    public void Agregar(Modelos1 modelo, VVehiculo_Modelo vista){
        
        String SQL = "INSERT INTO tbModelos (Modelo, Mo_anio, Mo_marca) VALUES (?, ?, ?)";
    try {
        PreparedStatement AModelo = CConexion.getConexion().prepareStatement(SQL);
        AModelo.setString(1, modelo.getModelo());
        AModelo.setInt(2, modelo.getMo_anio());
        AModelo.setString(3, modelo.getMarcavehiculo());
        
        AModelo.executeUpdate();
        JOptionPane.showMessageDialog(null, "El modelo se agregó correctamente");
        RellenarBuscadorCBX(vista.jcbBuscador);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO: " + e.toString());
        }
    }
    
    public void Eliminar(VVehiculo_Modelo vista){
        try {
            int filaSeleccionada = vista.tbModelos.getSelectedRow();

            String miId = vista.tbModelos.getValueAt(filaSeleccionada, 0).toString();
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbModelos where idModelo = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "El modelo se elimino correctamente");
            } catch (Exception e) {             
                JOptionPane.showMessageDialog(null, "Error eliminar modelo "+e.toString());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato para eliminar");
        }
    }
    
    public void Editar(VVehiculo_Modelo vista){
        try {
            int filaSeleccionada = vista.tbModelos.getSelectedRow();      

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbModelos.getValueAt(filaSeleccionada, 0).toString();
            String nuevoValorIngresadoModelo = vista.txtModelo.getText();
            String nuevoValorIngresadoAnio = vista.txtAnio.getText();
            String nuevoValorIngresadoMarca = vista.txtMarca.getText();
            try {

                PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbModelos set Modelo= ?, Mo_anio=?, Mo_marca= ? where idModelo = ?");
                updateUser.setString(1, nuevoValorIngresadoModelo);
                updateUser.setString(2, nuevoValorIngresadoAnio);
                updateUser.setString(3, nuevoValorIngresadoMarca);
                updateUser.setString(4, miId);
                JOptionPane.showMessageDialog(null, "El modelo se actualizo correctamente");                           
                updateUser.executeUpdate();
                RellenarBuscadorCBX(vista.jcbBuscador);
                } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Error en actualizar modelo");  
                }
        } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "Seleccione un dato");  
        }
        
    }
    
    ////////////Controlador///////////////////////////////////////////////////////////
    public void CBuscador(CVehiculo_Modelo vistaModelos){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Modelo","anualidad","Marca"});
        try {
            Statement st= CConexion.getConexion().createStatement();
                String SQL ="select *from tbModelos where Mo_marca='"+vistaModelos.jcbBuscador.getSelectedItem()+"'";
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idModelo"), rs.getString("Modelo"), rs.getString("Mo_anio"), rs.getString("Mo_marca")});
            }
            vistaModelos.tbModelos.setModel(modelo);            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error tabla modelos A "+e.getMessage());                
        }
    }
    
    public void CMostrarTabla(CVehiculo_Modelo vistaModelos){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Modelo","anualidad","Marca"});
        try {
            Statement st= CConexion.getConexion().createStatement();
                String SQL ="select *from tbModelos";
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idModelo"), rs.getString("Modelo"), rs.getString("Mo_anio"), rs.getString("Mo_marca")});
            }
            vistaModelos.tbModelos.setModel(modelo);            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error tabla modelos A "+e.getMessage());                
        }
    }
    
    public void CAgregar(Modelos1 modelo, CVehiculo_Modelo vista){
        
        String SQL = "INSERT INTO tbModelos (Modelo, Mo_anio, Mo_marca) VALUES (?, ?, ?)";
    try {
        PreparedStatement AModelo = CConexion.getConexion().prepareStatement(SQL);
        AModelo.setString(1, modelo.getModelo());
        AModelo.setInt(2, modelo.getMo_anio());
        AModelo.setString(3, modelo.getMarcavehiculo());
        
        AModelo.executeUpdate();
        JOptionPane.showMessageDialog(null, "El modelo se agregó correctamente");
        RellenarBuscadorCBX(vista.jcbBuscador);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO: " + e.toString());
        }
    }
    
    public void CEliminar(CVehiculo_Modelo vista){
        try {
            int filaSeleccionada = vista.tbModelos.getSelectedRow();

            String miId = vista.tbModelos.getValueAt(filaSeleccionada, 0).toString();
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbModelos where idModelo = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "El modelo se elimino correctamente");
            } catch (Exception e) {             
                JOptionPane.showMessageDialog(null, "Error eliminar modelo "+e.toString());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato para eliminar");
        }
    }
    
    public void CEditar(CVehiculo_Modelo vista){
        try {
            int filaSeleccionada = vista.tbModelos.getSelectedRow();      

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbModelos.getValueAt(filaSeleccionada, 0).toString();
            String nuevoValorIngresadoModelo = vista.txtModelo.getText();
            String nuevoValorIngresadoAnio = vista.txtAnio.getText();
            String nuevoValorIngresadoMarca = vista.txtMarca.getText();
            try {

                PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbModelos set Modelo= ?, Mo_anio=?, Mo_marca= ? where idModelo = ?");
                updateUser.setString(1, nuevoValorIngresadoModelo);
                updateUser.setString(2, nuevoValorIngresadoAnio);
                updateUser.setString(3, nuevoValorIngresadoMarca);
                updateUser.setString(4, miId);
                JOptionPane.showMessageDialog(null, "El modelo se actualizo correctamente");                           
                updateUser.executeUpdate();
                RellenarBuscadorCBX(vista.jcbBuscador);
                } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Error en actualizar modelo");  
                }
        } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "Seleccione un dato");  
        }
        
    }
}
