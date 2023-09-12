/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VVehiculo_Mantenimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class Mantenimiento {
    private int idMantenimineto;
    private String Mecanico;
    private String TFTaller;
    private String idTaller;

    public int getIdMantenimineto() {
        return idMantenimineto;
    }

    public void setIdMantenimineto(int idMantenimineto) {
        this.idMantenimineto = idMantenimineto;
    }

    public String getMecanico() {
        return Mecanico;
    }

    public void setMecanico(String Mecanico) {
        this.Mecanico = Mecanico;
    }

    public String getTFTaller() {
        return TFTaller;
    }

    public void setTFTaller(String TFTaller) {
        this.TFTaller = TFTaller;
    }

    public String getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(String idTaller) {
        this.idTaller = idTaller;
    }
    
    public void RellenarTallerCBX(JComboBox combo) {
    Connection conectar = null;
    PreparedStatement pst = null;
    ResultSet result = null;

    String SSQL = "SELECT idTaller, Tall_Nombre FROM tbTalleres";
    combo.removeAllItems();
    
    // Usamos un Map para almacenar pares de ID y nombre
    Map<Integer, String> idMantenimiento = new HashMap<>();

    try {
        conectar = CConexion.getConexion();
        pst = conectar.prepareStatement(SSQL);
        result = pst.executeQuery();

        while (result.next()) {
            int id = result.getInt("idTaller");
            String nombre = result.getString("Tall_Nombre");
            idMantenimiento.put(id, nombre); // Almacenamos el ID y el nombre en el Map
            combo.addItem(nombre);
        }

        // Almacenamos el Map en las propiedades del combo box
        combo.putClientProperty("idMantenimiento", idMantenimiento);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        if (conectar != null) {
            try {
                conectar.close();
                result.close();
                conectar = null;
                result = null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
    
    public void Mostrartabla(VVehiculo_Mantenimiento vista){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Mecanico","Numero mecanico","Taller"});
        try {
            Statement st= CConexion.getConexion().createStatement();
                String SQL ="select idMantenimiento, Mecanico, TFTaller, tbTalleres.Tall_Nombre from tbMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller";
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idMantenimiento"), rs.getString("Mecanico"), rs.getString("TFTaller"), rs.getString("Tall_Nombre")});
            }
            vista.tbMantenimiento.setModel(modelo);            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error tabla producto "+e.getMessage());                
        }
    }
    
    public void Agregar(Mantenimiento modelo, JComboBox Taller){
        String SQL = "INSERT INTO tbMantenimiento (Mecanico, TFTaller, idTaller) VALUES (?, ?, ?)";
    try {
        PreparedStatement AMantenimiento = CConexion.getConexion().prepareStatement(SQL);
        AMantenimiento.setString(1, modelo.getMecanico());
        AMantenimiento.setString(2, modelo.getTFTaller());
        
        int selectedTallerIndex = Taller.getSelectedIndex();
        if (selectedTallerIndex != -1) {
            Map<Integer, String> idMantenimiento = (Map<Integer, String>) Taller.getClientProperty("idMantenimiento");
            int selectedMarcaID = (int) idMantenimiento.keySet().toArray()[selectedTallerIndex];
            AMantenimiento.setInt(3, selectedMarcaID); // Usar el ID de la marca seleccionada
        } else {
            JOptionPane.showMessageDialog(null, "problema combobox.");
        }

        AMantenimiento.executeUpdate();
        JOptionPane.showMessageDialog(null, "El mantenimiento se agregó correctamente");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO: " + e.toString());
    }
    }
    
    public void Eliminar(VVehiculo_Mantenimiento vista){
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbMantenimiento.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbMantenimiento.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbMantenimiento where idMantenimiento = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "El Mantenimiento se elimino correctamente");
            } catch (Exception e) {             
                JOptionPane.showMessageDialog(null, "Error eliminar mantenimiento "+e.toString());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato para eliminar");
        }
        
    }
    
    public void Editar(Mantenimiento modelo, JComboBox Taller, VVehiculo_Mantenimiento vista){
        String SQL = "update tbMantenimiento set Mecanico = ?, TFTaller = ?, idTaller = ? where idMantenimiento = ?";
    try {
        PreparedStatement EMantenimiento = CConexion.getConexion().prepareStatement(SQL);
        EMantenimiento.setString(1, modelo.getMecanico());
        EMantenimiento.setString(2, modelo.getTFTaller());
        
        int selectedTallerIndex = Taller.getSelectedIndex();
        if (selectedTallerIndex != -1) {
            Map<Integer, String> idMantenimiento = (Map<Integer, String>) Taller.getClientProperty("idMantenimiento");
            int selectedMarcaID = (int) idMantenimiento.keySet().toArray()[selectedTallerIndex];
            EMantenimiento.setInt(3, selectedMarcaID); // Usar el ID de la marca seleccionada
        } else {
            JOptionPane.showMessageDialog(null, "problema combobox.");
        }
        
         int filaSeleccionada = vista.tbMantenimiento.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = vista.tbMantenimiento.getValueAt(filaSeleccionada, 0).toString();
        EMantenimiento.setString(4, miId);
        
        EMantenimiento.executeUpdate();
        JOptionPane.showMessageDialog(null, "El mantenimiento se actualizo correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato para editar");
        }
    }
}
