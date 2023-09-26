/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Controlador.CRutas_Paqueteria;
import Vista.VRutas_DatosDis;
import Vista.VRutas_Paqueteria;
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
public class paqueteria {

    private int idPqueteria;
    private String pqt_Nombre;
    private String idEmpleado;
    private String idDatosDistribucion;
    private String Paq_Ubicacion;

    public String getPqt_Nombre() {
        return pqt_Nombre;
    }

    public void setPqt_Nombre(String pqt_Nombre) {
        this.pqt_Nombre = pqt_Nombre;
    }

    public String getPaq_Ubicacion() {
        return Paq_Ubicacion;
    }

    public void setPaq_Ubicacion(String Paq_Ubicacion) {
        this.Paq_Ubicacion = Paq_Ubicacion;
    }

    public int getIdPqueteria() {
        return idPqueteria;
    }

    public void setIdPqueteria(int idPqueteria) {
        this.idPqueteria = idPqueteria;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdDatosDistribucion() {
        return idDatosDistribucion;
    }

    public void setIdDatosDistribucion(String idDatosDistribucion) {
        this.idDatosDistribucion = idDatosDistribucion;
    }

    public void LlenarCbxEmpleado(JComboBox combox) {
        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select idEmpleado, emp_nombre from tbEmpleados";
        combox.removeAllItems();
        Map<Integer, String> IDEmpleado = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idEmpleado");
                String Nombre = rs.getString("emp_nombre");
                IDEmpleado.put(id, Nombre);
                combox.addItem(Nombre);
            }
            combox.putClientProperty("idEmpleado", IDEmpleado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx Empleado " + e.toString());
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar = null;
                    rs = null;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error cbx empleado tipo2 " + e.toString());
                }
            }
        }
    }

    public void LlenarCbxDistru(JComboBox combox) {
        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select idDatoDistribucion, DaDis_Nombre from tbDatosDistribucion";
        combox.removeAllItems();
        Map<Integer, String> IDDistribucion = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idDatoDistribucion");
                String Nombre = rs.getString("DaDis_Nombre");
                IDDistribucion.put(id, Nombre);
                combox.addItem(Nombre);
            }
            combox.putClientProperty("idDatoDistribucion", IDDistribucion);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx Distribucion " + e.toString());
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar = null;
                    rs = null;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error cbx Distribucion tipo2 " + e.toString());
                }
            }
        }
    }

    ////////////Administrador///////////////////////////////////////////////////////////
    public void Agregar(paqueteria modelo, JComboBox Empleado, JComboBox Datos) {
        try {
            String sql = "insert into tbPaqueteria(pqt_Nombre, idEmpleado, idDatoDistribucion, Paq_Ubicacion) values(?, ?, ?, ?)";
            PreparedStatement ADatosDis = CConexion.getConexion().prepareStatement(sql);

            ADatosDis.setString(1, modelo.getPqt_Nombre());

            int SelectEmpleado = Empleado.getSelectedIndex();
            if (SelectEmpleado != -1) {
                Map<Integer, String> IDEmpleado = (Map<Integer, String>) Empleado.getClientProperty("idEmpleado");
                int selID = (int) IDEmpleado.keySet().toArray()[SelectEmpleado];
                ADatosDis.setInt(2, selID);
            } else {
            }

            int SelectDato = Datos.getSelectedIndex();
            if (SelectDato != -1) {
                Map<Integer, String> IDDistribucion = (Map<Integer, String>) Datos.getClientProperty("idDatoDistribucion");
                int selID = (int) IDDistribucion.keySet().toArray()[SelectDato];
                ADatosDis.setInt(3, selID);
            } else {
            }
            ADatosDis.setString(4, getPaq_Ubicacion());
            JOptionPane.showMessageDialog(null, "Datos agregados exitosamente ");
            ADatosDis.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar " + e.toString());
        }

    }

    public void Mostrartabla(VRutas_Paqueteria vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Nombre Empleado", "Datos Distribucion", "Ubicacion"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idPaqueteria, pqt_Nombre, tbEmpleados.emp_nombre, tbDatosDistribucion.DaDis_Nombre, Paq_Ubicacion from tbPaqueteria inner join tbEmpleados on tbPaqueteria.idEmpleado=tbEmpleados.idEmpleado inner join tbDatosDistribucion on tbPaqueteria.idDatoDistribucion=tbDatosDistribucion.idDatoDistribucion";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idPaqueteria"), rs.getString("pqt_Nombre"), rs.getString("emp_nombre"), rs.getString("DaDis_Nombre"), rs.getString("Paq_Ubicacion")});
            }

            vista.tbPaqueteria.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla Paqueteria " + e.getMessage());
        }
    }

    public void Eliminar(VRutas_Paqueteria vista) {
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbPaqueteria.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbPaqueteria.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbPaqueteria where idPaqueteria = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Eliminado con exito ");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "seleccione un elemento a eliminar ");
            }
        } catch (Exception qe) {
            JOptionPane.showMessageDialog(null, "seleccione un elemento a eliminar ");
        }

    }

    public void Actualizar(paqueteria modelo, JComboBox Empleado, JComboBox Datos, VRutas_Paqueteria vista) {
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbPaqueteria.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbPaqueteria.getValueAt(filaSeleccionada, 0).toString();

            String sql = "update tbPaqueteria set idEmpleado = ?, idDatoDistribucion = ?, Paq_Ubicacion = ? where idPaqueteria = ?";
            PreparedStatement ActDatos = CConexion.getConexion().prepareStatement(sql);

            int SelectEmpleado = Empleado.getSelectedIndex();
            if (SelectEmpleado != -1) {
                Map<Integer, String> IDEmpleado = (Map<Integer, String>) Empleado.getClientProperty("idEmpleado");
                int selID = (int) IDEmpleado.keySet().toArray()[SelectEmpleado];
                ActDatos.setInt(1, selID);
            } else {
            }

            int SelectDato = Datos.getSelectedIndex();
            if (SelectDato != -1) {
                Map<Integer, String> IDDistribucion = (Map<Integer, String>) Datos.getClientProperty("idDatoDistribucion");
                int selID = (int) IDDistribucion.keySet().toArray()[SelectDato];
                ActDatos.setInt(2, selID);
            } else {
            }
            ActDatos.setString(3, getPaq_Ubicacion());

            ActDatos.setString(4, miId);

            JOptionPane.showMessageDialog(null, "Datos Actualizados exitosamente ");
            ActDatos.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "seleccione un valor");
        }
    }

    ///////////Controlador////////////////////////////////////////////////////////////
    public void CAgregar(paqueteria modelo, JComboBox Empleado, JComboBox Datos) {
        try {
            String sql = "insert into tbPaqueteria(pqt_Nombre, idEmpleado, idDatoDistribucion, Paq_Ubicacion) values(?, ?, ?, ?)";
            PreparedStatement ADatosDis = CConexion.getConexion().prepareStatement(sql);

            ADatosDis.setString(1, modelo.getPqt_Nombre());

            int SelectEmpleado = Empleado.getSelectedIndex();
            if (SelectEmpleado != -1) {
                Map<Integer, String> IDEmpleado = (Map<Integer, String>) Empleado.getClientProperty("idEmpleado");
                int selID = (int) IDEmpleado.keySet().toArray()[SelectEmpleado];
                ADatosDis.setInt(2, selID);
            } else {
            }

            int SelectDato = Datos.getSelectedIndex();
            if (SelectDato != -1) {
                Map<Integer, String> IDDistribucion = (Map<Integer, String>) Datos.getClientProperty("idDatoDistribucion");
                int selID = (int) IDDistribucion.keySet().toArray()[SelectDato];
                ADatosDis.setInt(3, selID);
            } else {
            }
            ADatosDis.setString(4, getPaq_Ubicacion());
            JOptionPane.showMessageDialog(null, "Datos agregados exitosamente ");
            ADatosDis.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar " + e.toString());
        }

    }

    public void CMostrartabla(CRutas_Paqueteria vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Nombre Empleado", "Datos Distribucion", "Ubicacion"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idPaqueteria, pqt_Nombre, tbEmpleados.emp_nombre, tbDatosDistribucion.DaDis_Nombre, Paq_Ubicacion from tbPaqueteria inner join tbEmpleados on tbPaqueteria.idEmpleado=tbEmpleados.idEmpleado inner join tbDatosDistribucion on tbPaqueteria.idDatoDistribucion=tbDatosDistribucion.idDatoDistribucion";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idPaqueteria"), rs.getString("pqt_Nombre"), rs.getString("emp_nombre"), rs.getString("DaDis_Nombre"), rs.getString("Paq_Ubicacion")});
            }

            vista.tbPaqueteria.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla Paqueteria " + e.getMessage());
        }
    }

    public void CEliminar(CRutas_Paqueteria vista) {
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbPaqueteria.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbPaqueteria.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbPaqueteria where idPaqueteria = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Eliminado con exito ");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "seleccione un elemento a eliminar ");
            }
        } catch (Exception qe) {
            JOptionPane.showMessageDialog(null, "seleccione un elemento a eliminar ");
        }

    }

    public void CActualizar(paqueteria modelo, JComboBox Empleado, JComboBox Datos, CRutas_Paqueteria vista) {
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbPaqueteria.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbPaqueteria.getValueAt(filaSeleccionada, 0).toString();

            String sql = "update tbPaqueteria set idEmpleado = ?, idDatoDistribucion = ?, Paq_Ubicacion = ? where idPaqueteria = ?";
            PreparedStatement ActDatos = CConexion.getConexion().prepareStatement(sql);

            int SelectEmpleado = Empleado.getSelectedIndex();
            if (SelectEmpleado != -1) {
                Map<Integer, String> IDEmpleado = (Map<Integer, String>) Empleado.getClientProperty("idEmpleado");
                int selID = (int) IDEmpleado.keySet().toArray()[SelectEmpleado];
                ActDatos.setInt(1, selID);
            } else {
            }

            int SelectDato = Datos.getSelectedIndex();
            if (SelectDato != -1) {
                Map<Integer, String> IDDistribucion = (Map<Integer, String>) Datos.getClientProperty("idDatoDistribucion");
                int selID = (int) IDDistribucion.keySet().toArray()[SelectDato];
                ActDatos.setInt(2, selID);
            } else {
            }
            ActDatos.setString(3, getPaq_Ubicacion());

            ActDatos.setString(4, miId);

            JOptionPane.showMessageDialog(null, "Datos Actualizados exitosamente ");
            ActDatos.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "seleccione un valor");
        }
    }
}
