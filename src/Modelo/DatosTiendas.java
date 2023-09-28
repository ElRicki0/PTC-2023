/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Controlador.CCliente_DatosTiendas;
import Vista.VMain;
import Vista.Repartidor.RTiendas;
import Vista.Usuario.UTiendas;
import Vista.VCliente_DatosTiendas;
import Vista.VCliente_Tiendas;
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
public class DatosTiendas {

    private int idDatosTienda;
    private String DT_NumeroTelefono;
    private String DT_PersonaDestinatario;
    private String idCliente;
    private String idTienda;

    public int getIdDatosTienda() {
        return idDatosTienda;
    }

    public void setIdDatosTienda(int idDatosTienda) {
        this.idDatosTienda = idDatosTienda;
    }

    public String getDT_NumeroTelefono() {
        return DT_NumeroTelefono;
    }

    public void setDT_NumeroTelefono(String DT_NumeroTelefono) {
        this.DT_NumeroTelefono = DT_NumeroTelefono;
    }

    public String getDT_PersonaDestinatario() {
        return DT_PersonaDestinatario;
    }

    public void setDT_PersonaDestinatario(String DT_PersonaDestinatario) {
        this.DT_PersonaDestinatario = DT_PersonaDestinatario;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public void llenarcmbBuscador(JComboBox combo) {
        String sql = "select clie_Nombre from tbClientes";
        Statement st;
        CConexion con = new CConexion();
        Connection conexion = con.getConexion();
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString("clie_Nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en cliente buscador  " + e.toString());
        }
    }

    public void llenarcmbCliente(JComboBox combo) {
        Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

        String SSQL = "select idCliente, clie_Nombre from tbClientes";
        combo.removeAllItems();

        // Usamos un Map para almacenar pares de ID y nombre
        Map<Integer, String> idNombreCli = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            pst = conectar.prepareStatement(SSQL);
            result = pst.executeQuery();

            while (result.next()) {
                int id = result.getInt("idCliente");
                String nombre = result.getString("clie_Nombre");
                idNombreCli.put(id, nombre); // Almacenamos el ID y el nombre en el Map
                combo.addItem(nombre);
            }

            // Almacenamos el Map en las propiedades del combo box
            combo.putClientProperty("idCliente", idNombreCli);

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

    public void llenarcmbTienda(JComboBox combo) {
        Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

        String SSQL = "select idTienda, Tien_Nombre from tbTiendas";
        combo.removeAllItems();

        // Usamos un Map para almacenar pares de ID y nombre
        Map<Integer, String> idNombreTie = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            pst = conectar.prepareStatement(SSQL);
            result = pst.executeQuery();

            while (result.next()) {
                int id = result.getInt("idTienda");
                String nombre = result.getString("Tien_Nombre");
                idNombreTie.put(id, nombre); // Almacenamos el ID y el nombre en el Map
                combo.addItem(nombre);
            }

            // Almacenamos el Map en las propiedades del combo box
            combo.putClientProperty("idTienda", idNombreTie);

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

    ////////////Administrador///////////////////////////////////////////////////////////
    public void ABuscador(VCliente_DatosTiendas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas \n"
                    + "inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente \n"
                    + "inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda where tbClientes.clie_Nombre='" + vista.jcbBuscador.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }

    public void MostrarTabla(VCliente_DatosTiendas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas \n"
                    + "inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }

    public boolean Agregar(DatosTiendas modelo, JComboBox comboCliente, JComboBox comboTienda) {
        String SQL = "INSERT INTO tbDatosTiendas (DT_NumeroTelefono, DT_PersonaDestinatario, idCliente, idTienda) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ADTiendas = CConexion.getConexion().prepareStatement(SQL);
            ADTiendas.setString(1, modelo.getDT_NumeroTelefono());
            ADTiendas.setString(2, modelo.getDT_PersonaDestinatario());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboCliente.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idNombreCli = (Map<Integer, String>) comboCliente.getClientProperty("idCliente");
                int selectedMarcaID = (int) idNombreCli.keySet().toArray()[selectedMarcaIndex];
                ADTiendas.setInt(3, selectedMarcaID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de marcas.");
                return false;
            }

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboTienda.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idNombreTie = (Map<Integer, String>) comboTienda.getClientProperty("idTienda");
                int selectedBodegaID = (int) idNombreTie.keySet().toArray()[selectedBodegaIndex];
                ADTiendas.setInt(4, selectedBodegaID); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una bodega válida del ComboBox de bodegas.");
                return false;
            }

            ADTiendas.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos agregós correctamente");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO: " + e.toString());
            return false;
        }
    }

    public void Eliminar(VCliente_DatosTiendas vista) {
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbTienda.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbTienda.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbDatosTiendas where idDatosTienda = '" + miId + "'");
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente ");
                deleteUser.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "La tienda esta en uso cuchi");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato para elminar");
        }
    }

    public boolean Modificar(VCliente_DatosTiendas vista, DatosTiendas modelo, JComboBox comboCliente, JComboBox comboTienda) {
        String SQL = "update tbDatosTiendas set DT_NumeroTelefono = ?, DT_PersonaDestinatario=?, idCliente = ?, idTienda=? where idDatosTienda = ?";
        try {
            PreparedStatement MDTiendas = CConexion.getConexion().prepareStatement(SQL);
            MDTiendas.setString(1, modelo.getDT_NumeroTelefono());
            MDTiendas.setString(2, modelo.getDT_PersonaDestinatario());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboCliente.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idNombreCli = (Map<Integer, String>) comboCliente.getClientProperty("idCliente");
                int selectedMarcaID = (int) idNombreCli.keySet().toArray()[selectedMarcaIndex];
                MDTiendas.setInt(3, selectedMarcaID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de marcas.");
                return false;
            }

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboTienda.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idNombreTie = (Map<Integer, String>) comboTienda.getClientProperty("idTienda");
                int selectedBodegaID = (int) idNombreTie.keySet().toArray()[selectedBodegaIndex];
                MDTiendas.setInt(4, selectedBodegaID); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una bodega válida del ComboBox de bodegas.");
                return false;
            }
            int filaSeleccionada = vista.tbTienda.getSelectedRow();
            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbTienda.getValueAt(filaSeleccionada, 0).toString();

            MDTiendas.setString(5, miId);
            MDTiendas.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos modificados correctamente");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a modificar");
            return false;
        }
    }
    
    public void MostrarTablaM(VMain vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas \n"
                    + "inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }
    
    public void ABuscadorM(VMain vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas \n"
                    + "inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente \n"
                    + "inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda where tbClientes.clie_Nombre='" + vista.jcbBuscador.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }

    ////////////Controlador///////////////////////////////////////////////////////////
    public void CBuscador(CCliente_DatosTiendas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas \n"
                    + "inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente \n"
                    + "inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda where tbClientes.clie_Nombre='" + vista.jcbBuscador.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }
    
    public void CMostrarTabla(CCliente_DatosTiendas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas \n"
                    + "inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }

    public boolean CAgregar(DatosTiendas modelo, JComboBox comboCliente, JComboBox comboTienda) {
        String SQL = "INSERT INTO tbDatosTiendas (DT_NumeroTelefono, DT_PersonaDestinatario, idCliente, idTienda) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ADTiendas = CConexion.getConexion().prepareStatement(SQL);
            ADTiendas.setString(1, modelo.getDT_NumeroTelefono());
            ADTiendas.setString(2, modelo.getDT_PersonaDestinatario());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboCliente.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idNombreCli = (Map<Integer, String>) comboCliente.getClientProperty("idCliente");
                int selectedMarcaID = (int) idNombreCli.keySet().toArray()[selectedMarcaIndex];
                ADTiendas.setInt(3, selectedMarcaID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de marcas.");
                return false;
            }

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboTienda.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idNombreTie = (Map<Integer, String>) comboTienda.getClientProperty("idTienda");
                int selectedBodegaID = (int) idNombreTie.keySet().toArray()[selectedBodegaIndex];
                ADTiendas.setInt(4, selectedBodegaID); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una bodega válida del ComboBox de bodegas.");
                return false;
            }

            ADTiendas.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos agregós correctamente");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO: " + e.toString());
            return false;
        }
    }

    public void CEliminar(CCliente_DatosTiendas vista) {
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbTienda.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbTienda.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbDatosTiendas where idDatosTienda = '" + miId + "'");
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente ");
                deleteUser.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "La tienda esta en uso cuchi");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato para elminar");
        }
    }

    public boolean CModificar(CCliente_DatosTiendas vista, DatosTiendas modelo, JComboBox comboCliente, JComboBox comboTienda) {
        String SQL = "update tbDatosTiendas set DT_NumeroTelefono = ?, DT_PersonaDestinatario=?, idCliente = ?, idTienda=? where idDatosTienda = ?";
        try {
            PreparedStatement MDTiendas = CConexion.getConexion().prepareStatement(SQL);
            MDTiendas.setString(1, modelo.getDT_NumeroTelefono());
            MDTiendas.setString(2, modelo.getDT_PersonaDestinatario());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboCliente.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idNombreCli = (Map<Integer, String>) comboCliente.getClientProperty("idCliente");
                int selectedMarcaID = (int) idNombreCli.keySet().toArray()[selectedMarcaIndex];
                MDTiendas.setInt(3, selectedMarcaID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de marcas.");
                return false;
            }

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboTienda.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idNombreTie = (Map<Integer, String>) comboTienda.getClientProperty("idTienda");
                int selectedBodegaID = (int) idNombreTie.keySet().toArray()[selectedBodegaIndex];
                MDTiendas.setInt(4, selectedBodegaID); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una bodega válida del ComboBox de bodegas.");
                return false;
            }
            int filaSeleccionada = vista.tbTienda.getSelectedRow();
            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbTienda.getValueAt(filaSeleccionada, 0).toString();

            MDTiendas.setString(5, miId);
            MDTiendas.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos modificados correctamente");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a modificar");
            return false;
        }
    }

    ////////////Repartidor///////////////////////////////////////////////////////////
    public void RMostrarTabla(RTiendas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }
    
    public void RBuscador(RTiendas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas \n"
                    + "inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente \n"
                    + "inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda where tbClientes.clie_Nombre='" + vista.jcbBuscador.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }
    
    ////////////Usuario///////////////////////////////////////////////////////////
    public void UMostrarTabla(UTiendas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }
    
    public void UBuscador(UTiendas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Telefono", "Encargado", "Cliente", "Tienda", "Direccion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatosTienda, DT_NumeroTelefono, DT_PersonaDestinatario, tbClientes.clie_Nombre, tbTiendas.Tien_Nombre, tbTiendas.Tien_Direccion  from tbDatosTiendas \n"
                    + "inner join tbClientes on tbDatosTiendas.idCliente=tbClientes.idCliente \n"
                    + "inner join tbTiendas on tbDatosTiendas.idTienda = tbTiendas.idTienda where tbClientes.clie_Nombre='" + vista.jcbBuscador.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatosTienda"), rs.getString("DT_NumeroTelefono"), rs.getString("DT_PersonaDestinatario"), rs.getString("clie_Nombre"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion")});
            }
            vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla datos tiendas " + e.getMessage());
        }
    }

}
