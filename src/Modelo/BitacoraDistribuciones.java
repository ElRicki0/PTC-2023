/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
}
