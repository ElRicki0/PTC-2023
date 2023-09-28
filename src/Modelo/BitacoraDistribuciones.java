/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Controlador.CRutas_Envios;
import Vista.Repartidor.REnvios;
import Vista.Usuario.UEnvios;
import Vista.VMain_Rutas;
import Vista.VRutas_Envios;
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
    
    public void RellenarBuscadorCBX(JComboBox combo){
        combo.removeAllItems();
        String sql = "select Estado from tbEstadoEntrega";
        Statement st;
        CConexion con = new CConexion();
        Connection conexion = con.getConexion();
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString("Estado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Estado distribucion buscador  " + e.toString());
        }
    }

    ///////////////////////Admin////////////////////////////////////////////////
    public void MostrarTabla(VRutas_Envios vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Fecha entrega", "Empleado ENC", "usuario ENC", "matricula vehiculo", "Paqueteria", "Estado entrega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idBitacoraDistribucion, FechaEntrega, tbEmpleados.emp_nombre, tbUsuarios.usr_nombre, tbVehiculos.vehi_Matricula, tbPaqueteria.pqt_Nombre, tbEstadoEntrega.Estado from tbBitacoraDistribuciones \n"
                    + "inner join tbEmpleados		on tbBitacoraDistribuciones.idEmpleado=tbEmpleados.idEmpleado\n"
                    + "inner join tbUsuarios		on tbBitacoraDistribuciones.idUsuario=tbUsuarios.idUsuario\n"
                    + "inner join tbVehiculos		on tbBitacoraDistribuciones.idVehiculo= tbVehiculos.idVehiculo\n"
                    + "inner join tbPaqueteria		on tbBitacoraDistribuciones.idPaqueteria=tbPaqueteria.idPaqueteria\n"
                    + "inner join tbEstadoEntrega            on tbBitacoraDistribuciones.idEstado=tbEstadoEntrega.idEstado";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idBitacoraDistribucion"), rs.getDate("FechaEntrega"), rs.getString("emp_nombre"), rs.getString("usr_nombre"), rs.getString("vehi_Matricula"), rs.getString("pqt_Nombre"), rs.getString("Estado")});
            }
            vista.tbEnvios.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    }

    public void Agregar(BitacoraDistribuciones modelo, JComboBox jcbEmpleado, JComboBox jcbUsuario, JComboBox jcbVehiculo, JComboBox jcbPaquete, JComboBox jcbEstado) {
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
            JOptionPane.showMessageDialog(null, "Ruta agregada exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error agregar " + e.toString());
        }
    }

    public void Eliminar(VRutas_Envios vista) {
        try {
            int filaSeleccionada = vista.tbEnvios.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbEnvios.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbBitacoraDistribuciones where idBitacoraDistribucion = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente el envio");
            } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Existe registro en rutas con esta ruta, modifique o elimine el dato para seguir");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a eliminar");

        }

    }

    public void Editar(BitacoraDistribuciones modelo, JComboBox jcbEmpleado, JComboBox jcbUsuario, JComboBox jcbVehiculo, JComboBox jcbPaquete, JComboBox jcbEstado, VRutas_Envios vista) {
        try {
            String sql = "update tbBitacoraDistribuciones set FechaEntrega=?, idEmpleado=?, idUsuario=?, idVehiculo=?, idPaqueteria=?, idEstado=? where idBitacoraDistribucion=?";
            PreparedStatement EEnvios = CConexion.getConexion().prepareStatement(sql);

            EEnvios.setString(1, modelo.getFecha_Entrega());

            int SelectEmpelado = jcbEmpleado.getSelectedIndex();
            if (SelectEmpelado != -1) {
                Map<Integer, String> idEmpleado = (Map<Integer, String>) jcbEmpleado.getClientProperty("idEmpleado");
                int selID = (int) idEmpleado.keySet().toArray()[SelectEmpelado];
                EEnvios.setInt(2, selID);
            } else {
            }

            int SelectTUsuario = jcbUsuario.getSelectedIndex();
            if (SelectTUsuario != -1) {
                Map<Integer, String> idUsuario = (Map<Integer, String>) jcbUsuario.getClientProperty("idUsuario");
                int selID = (int) idUsuario.keySet().toArray()[SelectTUsuario];
                EEnvios.setInt(3, selID);
            } else {
            }

            int Selectvehiculo = jcbVehiculo.getSelectedIndex();
            if (Selectvehiculo != -1) {
                Map<Integer, String> idVehiculo = (Map<Integer, String>) jcbVehiculo.getClientProperty("idVehiculo");
                int selID = (int) idVehiculo.keySet().toArray()[Selectvehiculo];
                EEnvios.setInt(4, selID);
            } else {
            }

            int SelectPaquete = jcbPaquete.getSelectedIndex();
            if (SelectPaquete != -1) {
                Map<Integer, String> idPaqueteria = (Map<Integer, String>) jcbPaquete.getClientProperty("idPaqueteria");
                int selID = (int) idPaqueteria.keySet().toArray()[SelectPaquete];
                EEnvios.setInt(5, selID);
            } else {
            }

            int SelectEstado = jcbEstado.getSelectedIndex();
            if (SelectEstado != -1) {
                Map<Integer, String> idEstado = (Map<Integer, String>) jcbEstado.getClientProperty("idEstado");
                int selID = (int) idEstado.keySet().toArray()[SelectEstado];
                EEnvios.setInt(6, selID);
            } else {
            }

            int filaSeleccionada = vista.tbEnvios.getSelectedRow();
            String miId = vista.tbEnvios.getValueAt(filaSeleccionada, 0).toString();
            EEnvios.setString(7, miId);

            EEnvios.execute();
            JOptionPane.showMessageDialog(null, "Ruta editada exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a editar");
        }
    }

    public void MostrarTablaM(VMain_Rutas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Fecha entrega", "Empleado ENC", "usuario ENC", "matricula vehiculo", "Paqueteria", "Estado entrega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idBitacoraDistribucion, FechaEntrega, tbEmpleados.emp_nombre, tbUsuarios.usr_nombre, tbVehiculos.vehi_Matricula, tbPaqueteria.pqt_Nombre, tbEstadoEntrega.Estado from tbBitacoraDistribuciones \n"
                    + "inner join tbEmpleados		on tbBitacoraDistribuciones.idEmpleado=tbEmpleados.idEmpleado\n"
                    + "inner join tbUsuarios		on tbBitacoraDistribuciones.idUsuario=tbUsuarios.idUsuario\n"
                    + "inner join tbVehiculos		on tbBitacoraDistribuciones.idVehiculo= tbVehiculos.idVehiculo\n"
                    + "inner join tbPaqueteria		on tbBitacoraDistribuciones.idPaqueteria=tbPaqueteria.idPaqueteria\n"
                    + "inner join tbEstadoEntrega            on tbBitacoraDistribuciones.idEstado=tbEstadoEntrega.idEstado";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idBitacoraDistribucion"), rs.getDate("FechaEntrega"), rs.getString("emp_nombre"), rs.getString("usr_nombre"), rs.getString("vehi_Matricula"), rs.getString("pqt_Nombre"), rs.getString("Estado")});
            }
            vista.tbEnvios.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    }
    
    public void BuscarTablaM(VMain_Rutas vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Fecha entrega", "Empleado ENC", "usuario ENC", "matricula vehiculo", "Paqueteria", "Estado entrega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idBitacoraDistribucion, FechaEntrega, tbEmpleados.emp_nombre, tbUsuarios.usr_nombre, tbVehiculos.vehi_Matricula, tbPaqueteria.pqt_Nombre, tbEstadoEntrega.Estado from tbBitacoraDistribuciones \n"
                    + "inner join tbEmpleados		on tbBitacoraDistribuciones.idEmpleado=tbEmpleados.idEmpleado\n"
                    + "inner join tbUsuarios		on tbBitacoraDistribuciones.idUsuario=tbUsuarios.idUsuario\n"
                    + "inner join tbVehiculos		on tbBitacoraDistribuciones.idVehiculo= tbVehiculos.idVehiculo\n"
                    + "inner join tbPaqueteria		on tbBitacoraDistribuciones.idPaqueteria=tbPaqueteria.idPaqueteria\n"
                    + "inner join tbEstadoEntrega            on tbBitacoraDistribuciones.idEstado=tbEstadoEntrega.idEstado where tbEstadoEntrega.Estado= '"+vista.jcbEstado.getSelectedItem()+"'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idBitacoraDistribucion"), rs.getDate("FechaEntrega"), rs.getString("emp_nombre"), rs.getString("usr_nombre"), rs.getString("vehi_Matricula"), rs.getString("pqt_Nombre"), rs.getString("Estado")});
            }
            vista.tbEnvios.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    }
    
    ////////////Controlador///////////////////////////////////////////////////////////
    public void CMostrarTabla(CRutas_Envios vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Fecha entrega", "Empleado ENC", "usuario ENC", "matricula vehiculo", "Paqueteria", "Estado entrega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idBitacoraDistribucion, FechaEntrega, tbEmpleados.emp_nombre, tbUsuarios.usr_nombre, tbVehiculos.vehi_Matricula, tbPaqueteria.pqt_Nombre, tbEstadoEntrega.Estado from tbBitacoraDistribuciones \n"
                    + "inner join tbEmpleados		on tbBitacoraDistribuciones.idEmpleado=tbEmpleados.idEmpleado\n"
                    + "inner join tbUsuarios		on tbBitacoraDistribuciones.idUsuario=tbUsuarios.idUsuario\n"
                    + "inner join tbVehiculos		on tbBitacoraDistribuciones.idVehiculo= tbVehiculos.idVehiculo\n"
                    + "inner join tbPaqueteria		on tbBitacoraDistribuciones.idPaqueteria=tbPaqueteria.idPaqueteria\n"
                    + "inner join tbEstadoEntrega            on tbBitacoraDistribuciones.idEstado=tbEstadoEntrega.idEstado";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idBitacoraDistribucion"), rs.getDate("FechaEntrega"), rs.getString("emp_nombre"), rs.getString("usr_nombre"), rs.getString("vehi_Matricula"), rs.getString("pqt_Nombre"), rs.getString("Estado")});
            }
            vista.tbEnvios.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    }

    public void CAgregar(BitacoraDistribuciones modelo, JComboBox jcbEmpleado, JComboBox jcbUsuario, JComboBox jcbVehiculo, JComboBox jcbPaquete, JComboBox jcbEstado) {
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
            JOptionPane.showMessageDialog(null, "Ruta agregada exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error agregar " + e.toString());
        }
    }

    public void CEliminar(CRutas_Envios vista) {
        try {
            int filaSeleccionada = vista.tbEnvios.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbEnvios.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbBitacoraDistribuciones where idBitacoraDistribucion = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente el envio");
            } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Existe registro en rutas con esta ruta, modifique o elimine el dato para seguir");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a eliminar");

        }

    }

    public void CEditar(BitacoraDistribuciones modelo, JComboBox jcbEmpleado, JComboBox jcbUsuario, JComboBox jcbVehiculo, JComboBox jcbPaquete, JComboBox jcbEstado, CRutas_Envios vista) {
        try {
            String sql = "update tbBitacoraDistribuciones set FechaEntrega=?, idEmpleado=?, idUsuario=?, idVehiculo=?, idPaqueteria=?, idEstado=? where idBitacoraDistribucion=?";
            PreparedStatement EEnvios = CConexion.getConexion().prepareStatement(sql);

            EEnvios.setString(1, modelo.getFecha_Entrega());

            int SelectEmpelado = jcbEmpleado.getSelectedIndex();
            if (SelectEmpelado != -1) {
                Map<Integer, String> idEmpleado = (Map<Integer, String>) jcbEmpleado.getClientProperty("idEmpleado");
                int selID = (int) idEmpleado.keySet().toArray()[SelectEmpelado];
                EEnvios.setInt(2, selID);
            } else {
            }

            int SelectTUsuario = jcbUsuario.getSelectedIndex();
            if (SelectTUsuario != -1) {
                Map<Integer, String> idUsuario = (Map<Integer, String>) jcbUsuario.getClientProperty("idUsuario");
                int selID = (int) idUsuario.keySet().toArray()[SelectTUsuario];
                EEnvios.setInt(3, selID);
            } else {
            }

            int Selectvehiculo = jcbVehiculo.getSelectedIndex();
            if (Selectvehiculo != -1) {
                Map<Integer, String> idVehiculo = (Map<Integer, String>) jcbVehiculo.getClientProperty("idVehiculo");
                int selID = (int) idVehiculo.keySet().toArray()[Selectvehiculo];
                EEnvios.setInt(4, selID);
            } else {
            }

            int SelectPaquete = jcbPaquete.getSelectedIndex();
            if (SelectPaquete != -1) {
                Map<Integer, String> idPaqueteria = (Map<Integer, String>) jcbPaquete.getClientProperty("idPaqueteria");
                int selID = (int) idPaqueteria.keySet().toArray()[SelectPaquete];
                EEnvios.setInt(5, selID);
            } else {
            }

            int SelectEstado = jcbEstado.getSelectedIndex();
            if (SelectEstado != -1) {
                Map<Integer, String> idEstado = (Map<Integer, String>) jcbEstado.getClientProperty("idEstado");
                int selID = (int) idEstado.keySet().toArray()[SelectEstado];
                EEnvios.setInt(6, selID);
            } else {
            }

            int filaSeleccionada = vista.tbEnvios.getSelectedRow();
            String miId = vista.tbEnvios.getValueAt(filaSeleccionada, 0).toString();
            EEnvios.setString(7, miId);

            EEnvios.execute();
            JOptionPane.showMessageDialog(null, "Ruta editada exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a editar");
        }
    }

    //////////////////Usuario/////////////////////////////////////////////////////
    public void REditar(BitacoraDistribuciones modelo, JComboBox jcbEstado, REnvios vista){
         try {
            String sql = "update tbBitacoraDistribuciones set idEstado=? where idBitacoraDistribucion=?";
            PreparedStatement EEnvios = CConexion.getConexion().prepareStatement(sql);


            int SelectEstado = jcbEstado.getSelectedIndex();
            if (SelectEstado != -1) {
                Map<Integer, String> idEstado = (Map<Integer, String>) jcbEstado.getClientProperty("idEstado");
                int selID = (int) idEstado.keySet().toArray()[SelectEstado];
                EEnvios.setInt(1, selID);
            } else {
            }

            int filaSeleccionada = vista.tbEnvios.getSelectedRow();
            String miId = vista.tbEnvios.getValueAt(filaSeleccionada, 0).toString();
            EEnvios.setString(2, miId);

            EEnvios.execute();
            JOptionPane.showMessageDialog(null, "Estado editada exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a editar");
        }
    }
    
    public void RMostrarTabla(REnvios vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Fecha entrega", "Empleado ENC", "usuario ENC", "matricula vehiculo", "Paqueteria", "Estado entrega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idBitacoraDistribucion, FechaEntrega, tbEmpleados.emp_nombre, tbUsuarios.usr_nombre, tbVehiculos.vehi_Matricula, tbPaqueteria.pqt_Nombre, tbEstadoEntrega.Estado from tbBitacoraDistribuciones \n"
                    + "inner join tbEmpleados		on tbBitacoraDistribuciones.idEmpleado=tbEmpleados.idEmpleado\n"
                    + "inner join tbUsuarios		on tbBitacoraDistribuciones.idUsuario=tbUsuarios.idUsuario\n"
                    + "inner join tbVehiculos		on tbBitacoraDistribuciones.idVehiculo= tbVehiculos.idVehiculo\n"
                    + "inner join tbPaqueteria		on tbBitacoraDistribuciones.idPaqueteria=tbPaqueteria.idPaqueteria\n"
                    + "inner join tbEstadoEntrega            on tbBitacoraDistribuciones.idEstado=tbEstadoEntrega.idEstado";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idBitacoraDistribucion"), rs.getDate("FechaEntrega"), rs.getString("emp_nombre"), rs.getString("usr_nombre"), rs.getString("vehi_Matricula"), rs.getString("pqt_Nombre"), rs.getString("Estado")});
            }
            vista.tbEnvios.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    }
    
    //////////////////Usuario/////////////////////////////////////////////////////
    public void UMostrarTabla(UEnvios vista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Fecha entrega", "Empleado ENC", "usuario ENC", "matricula vehiculo", "Paqueteria", "Estado entrega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idBitacoraDistribucion, FechaEntrega, tbEmpleados.emp_nombre, tbUsuarios.usr_nombre, tbVehiculos.vehi_Matricula, tbPaqueteria.pqt_Nombre, tbEstadoEntrega.Estado from tbBitacoraDistribuciones \n"
                    + "inner join tbEmpleados		on tbBitacoraDistribuciones.idEmpleado=tbEmpleados.idEmpleado\n"
                    + "inner join tbUsuarios		on tbBitacoraDistribuciones.idUsuario=tbUsuarios.idUsuario\n"
                    + "inner join tbVehiculos		on tbBitacoraDistribuciones.idVehiculo= tbVehiculos.idVehiculo\n"
                    + "inner join tbPaqueteria		on tbBitacoraDistribuciones.idPaqueteria=tbPaqueteria.idPaqueteria\n"
                    + "inner join tbEstadoEntrega            on tbBitacoraDistribuciones.idEstado=tbEstadoEntrega.idEstado";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idBitacoraDistribucion"), rs.getDate("FechaEntrega"), rs.getString("emp_nombre"), rs.getString("usr_nombre"), rs.getString("vehi_Matricula"), rs.getString("pqt_Nombre"), rs.getString("Estado")});
            }
            vista.tbEnvios.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    }
}
