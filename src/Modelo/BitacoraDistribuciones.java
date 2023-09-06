/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VEnvios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class BitacoraDistribuciones {
    private int idBitacoraDistribucion;
    private String Fecha_Entrega;
    private String idEmpleado;
    private String idUsuario;
    private String idvehiculo;
    private String idPaqueteria;
    private String idEstado;

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdBitacoraDistribucion() {
        return idBitacoraDistribucion;
    }

    public void setIdBitacoraDistribucion(int idBitacoraDistribucion) {
        this.idBitacoraDistribucion = idBitacoraDistribucion;
    }

    public String getFecha_Entrega() {
        return Fecha_Entrega;
    }

    public void setFecha_Entrega(String Fecha_Entrega) {
        this.Fecha_Entrega = Fecha_Entrega;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getIdPaqueteria() {
        return idPaqueteria;
    }

    public void setIdPaqueteria(String idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
    }
    
    public void LlenarcbxEmpleado(JComboBox combox) {
        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select idEmpleado, emp_nombre from tbEmpleados";
        combox.removeAllItems();
        Map<Integer, String> idEmpleado = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idEmpleado");
                String TEmpleado = rs.getString("emp_nombre");
                idEmpleado.put(id, TEmpleado);
                combox.addItem(TEmpleado);
            }
            combox.putClientProperty("idEmpleado", idEmpleado);

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
                }
            }

        }
    }
    
    public void LlenarcbxUsuario(JComboBox combox) {
        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select idUsuario, usr_nombre from tbUsuarios";
        combox.removeAllItems();
        Map<Integer, String> idUsuario = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String Usuario = rs.getString("usr_nombre");
                idUsuario.put(id, Usuario);
                combox.addItem(Usuario);
            }
            combox.putClientProperty("idUsuario", idUsuario);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx usuario " + e.toString());
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar = null;
                    rs = null;

                } catch (Exception e) {
                }
            }

        }
    }
    
    public void LlenarcbxVehiculo(JComboBox combox) {
        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select idVehiculo, vehi_Matricula from tbVehiculos";
        combox.removeAllItems();
        Map<Integer, String> idVehiculo = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idVehiculo");
                String Vehiculo = rs.getString("vehi_Matricula");
                idVehiculo.put(id, Vehiculo);
                combox.addItem(Vehiculo);
            }
            combox.putClientProperty("idVehiculo", idVehiculo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx vehiculos " + e.toString());
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar = null;
                    rs = null;

                } catch (Exception e) {
                }
            }

        }
    }
    
    public void LlenarcbxPaqueteria(JComboBox combox) {
        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select idPaqueteria, pqt_Nombre from tbPaqueteria";
        combox.removeAllItems();
        Map<Integer, String> idPaqueteria = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idPaqueteria");
                String Paqueteria = rs.getString("pqt_Nombre");
                idPaqueteria.put(id, Paqueteria);
                combox.addItem(Paqueteria);
            }
            combox.putClientProperty("idPaqueteria", idPaqueteria);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx paqueteria " + e.toString());
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar = null;
                    rs = null;

                } catch (Exception e) {
                }
            }

        }
    }
    
    public void LlenarcbxEstado(JComboBox combox) {
        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select idEstado, Estado from tbEstadoEntrega";
        combox.removeAllItems();
        Map<Integer, String> idEstado = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idEstado");
                String Estado = rs.getString("Estado");
                idEstado.put(id, Estado);
                combox.addItem(Estado);
            }
            combox.putClientProperty("idEstado", idEstado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx Estado " + e.toString());
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar = null;
                    rs = null;

                } catch (Exception e) {
                }
            }

        }
    }
    
    public void MostrarTabla(VEnvios vista){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Fecha entrega", "Empleado ENC", "usuario ENC", "matricula vehiculo", "Paqueteria","Estado entrega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idBitacoraDistribucion, FechaEntrega, tbEmpleados.emp_nombre, tbUsuarios.usr_nombre, tbVehiculos.vehi_Matricula, tbPaqueteria.pqt_Nombre, tbEstadoEntrega.Estado from tbBitacoraDistribuciones \n" +
                         "inner join tbEmpleados		on tbBitacoraDistribuciones.idEmpleado=tbEmpleados.idEmpleado\n" +
                         "inner join tbUsuarios		on tbBitacoraDistribuciones.idUsuario=tbUsuarios.idUsuario\n" +
                         "inner join tbVehiculos		on tbBitacoraDistribuciones.idVehiculo= tbVehiculos.idVehiculo\n" +
                         "inner join tbPaqueteria		on tbBitacoraDistribuciones.idPaqueteria=tbPaqueteria.idPaqueteria\n" +
                         "inner join tbEstadoEntrega            on tbBitacoraDistribuciones.idEstado=tbEstadoEntrega.idEstado";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idBitacoraDistribucion"), rs.getDate("FechaEntrega"), rs.getString("emp_nombre"), rs.getString("usr_nombre"), rs.getString("vehi_Matricula"), rs.getString("pqt_Nombre"), rs.getString("Estado")});
            }
            vista.tbEnvios.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    } 
    
    public void agregar(BitacoraDistribuciones modelo, JComboBox jcbEmpleado, JComboBox jcbUsuario, JComboBox jcbVehiculo, JComboBox jcbPaquete, JComboBox jcbEstado){
        try {
            String sql = "insert into tbBitacoraDistribuciones(FechaEntrega, idEmpleado, idUsuario, idVehiculo, idPaqueteria, idEstado)values(?,?,?,?,?,?)";
            PreparedStatement AEnvios = CConexion.getConexion().prepareStatement(sql);

            AEnvios.setString(1, modelo.getFecha_Entrega());

            int SelectEmpelado = jcbEmpleado.getSelectedIndex();
            if (SelectEmpelado != -1) {
                Map<Integer, String> idEmpleado = (Map<Integer, String>) jcbEmpleado.getClientProperty("idEmpleado");
                int selID = (int) idEmpleado.keySet().toArray()[SelectEmpelado];
                AEnvios.setInt(2, selID);
            } else {
            }

            int SelectTUsuario = jcbUsuario.getSelectedIndex();
            if (SelectTUsuario != -1) {
                Map<Integer, String> idUsuario = (Map<Integer, String>) jcbUsuario.getClientProperty("idUsuario");
                int selID = (int) idUsuario.keySet().toArray()[SelectTUsuario];
                AEnvios.setInt(3, selID);
            } else {
            }
            
            int Selectvehiculo = jcbVehiculo.getSelectedIndex();
            if (Selectvehiculo != -1) {
                Map<Integer, String> idVehiculo = (Map<Integer, String>) jcbVehiculo.getClientProperty("idVehiculo");
                int selID = (int) idVehiculo.keySet().toArray()[Selectvehiculo];
                AEnvios.setInt(4, selID);
            } else {
            }
            
            int SelectPaquete = jcbPaquete.getSelectedIndex();
            if (SelectPaquete != -1) {
                Map<Integer, String> idPaqueteria = (Map<Integer, String>) jcbPaquete.getClientProperty("idPaqueteria");
                int selID = (int) idPaqueteria.keySet().toArray()[SelectPaquete];
                AEnvios.setInt(5, selID);
            } else {
            }
            
            int SelectEstado = jcbEstado.getSelectedIndex();
            if (SelectEstado != -1) {
                Map<Integer, String> idEstado = (Map<Integer, String>) jcbEstado.getClientProperty("idEstado");
                int selID = (int) idEstado.keySet().toArray()[SelectEstado];
                AEnvios.setInt(6, selID);
            } else {
            }

            AEnvios.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error agregar "+e.toString());
        }
    }
}
