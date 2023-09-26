/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Controlador.CRutas_DatosDis;
import Vista.VRutas_DatosDis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class DatosDistribucion {

    private int idDatosDistribucion;
    private String DaDis_Nombre;
    private String idProducto;
    private int CantidadProducto;
    private String idEmpleado;

    public String getDaDis_Nombre() {
        return DaDis_Nombre;
    }

    public void setDaDis_Nombre(String DaDis_Nombre) {
        this.DaDis_Nombre = DaDis_Nombre;
    }

    public int getIdDatosDistribucion() {
        return idDatosDistribucion;
    }

    public void setIdDatosDistribucion(int idDatosDistribucion) {
        this.idDatosDistribucion = idDatosDistribucion;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return CantidadProducto;
    }

    public void setCantidadProducto(int CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void LlenarCbxProducto(JComboBox combox) {
        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select idProducto, Prod_Nombre from tbProductos";
        combox.removeAllItems();
        Map<Integer, String> IDProducto = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idProducto");
                String Nombre = rs.getString("Prod_Nombre");
                IDProducto.put(id, Nombre);
                combox.addItem(Nombre);
            }
            combox.putClientProperty("idProducto", IDProducto);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx Producto " + e.toString());
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar = null;
                    rs = null;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error cbx Producto tipo2 " + e.toString());
                }
            }
        }
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

    ////////////Administrador///////////////////////////////////////////////////////////
    public void Mostrartabla(VRutas_DatosDis vistaRutas) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Producto", "Cantidad", "Empleado responsable"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatoDistribucion, DaDis_Nombre,tbProductos.Prod_Nombre, DaDis_CantidadProducto, tbEmpleados.emp_nombre  from tbDatosDistribucion \n"
                    + "inner join tbProductos on tbDatosDistribucion.idProducto= tbProductos.idProducto inner join tbEmpleados on tbDatosDistribucion.idEmpleado=tbEmpleados.idEmpleado";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatoDistribucion"), rs.getString("DaDis_Nombre"), rs.getString("Prod_Nombre"), rs.getInt("DaDis_CantidadProducto"), rs.getString("emp_nombre")});
            }

            vistaRutas.tbDistribucion.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla Distribucion " + e.getMessage());
        }
    }

    public void Agregar(DatosDistribucion modelo, JComboBox Producto, JComboBox Empleado) {
        try {
            System.out.println("clic2");
            String sql = "insert into tbDatosDistribucion(DaDis_Nombre, idProducto, DaDis_CantidadProducto, idEmpleado) values(?, ?, ?, ?)";
            PreparedStatement ADatosDis = CConexion.getConexion().prepareStatement(sql);
            ADatosDis.setString(1, getDaDis_Nombre());

            int SelectProductoo = Producto.getSelectedIndex();
            if (SelectProductoo != -1) {
                Map<Integer, String> IDProducto = (Map<Integer, String>) Producto.getClientProperty("idProducto");
                int selID = (int) IDProducto.keySet().toArray()[SelectProductoo];
                ADatosDis.setInt(2, selID);
            } else {
            }

            ADatosDis.setInt(3, modelo.getCantidadProducto());

            int SelectPEmpleado = Empleado.getSelectedIndex();
            if (SelectPEmpleado != -1) {
                Map<Integer, String> IDEmpleado = (Map<Integer, String>) Empleado.getClientProperty("idEmpleado");
                int selID = (int) IDEmpleado.keySet().toArray()[SelectPEmpleado];
                ADatosDis.setInt(4, selID);
            } else {
            }
            JOptionPane.showMessageDialog(null, "Datos agregados exitosamente ");
            ADatosDis.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en agregar datos de distribucion " + e.toString());
        }
    }

    public void Eliminar(VRutas_DatosDis vistaDistribucion) {
        try {
            int filaSeleccionada = vistaDistribucion.tbDistribucion.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vistaDistribucion.tbDistribucion.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbDatosDistribucion where idDatoDistribucion = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente el dato");
            } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Error al intentar eliminar el dato");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "seleccione un dato");
        }
    }

    public void Actualizar(VRutas_DatosDis vista, DatosDistribucion modelo, JComboBox Producto, JComboBox Empleado) {
        try {

            String sql = "update tbDatosDistribucion set DaDis_Nombre = ?, idProducto=?, DaDis_CantidadProducto = ?, idEmpleado = ? where idDatoDistribucion = ?";
            PreparedStatement ADatosDis = CConexion.getConexion().prepareStatement(sql);
            ADatosDis.setString(1, getDaDis_Nombre());

            int SelectProductoo = Producto.getSelectedIndex();
            if (SelectProductoo != -1) {
                Map<Integer, String> IDProducto = (Map<Integer, String>) Producto.getClientProperty("idProducto");
                int selID = (int) IDProducto.keySet().toArray()[SelectProductoo];
                ADatosDis.setInt(2, selID);
            } else {
            }

            ADatosDis.setInt(3, modelo.getCantidadProducto());

            int SelectPEmpleado = Empleado.getSelectedIndex();
            if (SelectPEmpleado != -1) {
                Map<Integer, String> IDEmpleado = (Map<Integer, String>) Empleado.getClientProperty("idEmpleado");
                int selID = (int) IDEmpleado.keySet().toArray()[SelectPEmpleado];
                ADatosDis.setInt(4, selID);
            } else {

            }

            int filaSeleccionada = vista.tbDistribucion.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbDistribucion.getValueAt(filaSeleccionada, 0).toString();

            JOptionPane.showMessageDialog(null, "Datos Modificados exitosamente ");
            ADatosDis.setString(5, miId);

            ADatosDis.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla " + e.toString());
        }
    }

    ////////////Controlador///////////////////////////////////////////////////////////
    public void CMostrartabla(CRutas_DatosDis vistaRutas) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Producto", "Cantidad", "Empleado responsable"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "select idDatoDistribucion, DaDis_Nombre,tbProductos.Prod_Nombre, DaDis_CantidadProducto, tbEmpleados.emp_nombre  from tbDatosDistribucion \n"
                    + "inner join tbProductos on tbDatosDistribucion.idProducto= tbProductos.idProducto inner join tbEmpleados on tbDatosDistribucion.idEmpleado=tbEmpleados.idEmpleado";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idDatoDistribucion"), rs.getString("DaDis_Nombre"), rs.getString("Prod_Nombre"), rs.getInt("DaDis_CantidadProducto"), rs.getString("emp_nombre")});
            }

            vistaRutas.tbDistribucion.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla Distribucion " + e.getMessage());
        }
    }

    public void CAgregar(DatosDistribucion modelo, JComboBox Producto, JComboBox Empleado) {
        try {
            System.out.println("clic2");
            String sql = "insert into tbDatosDistribucion(DaDis_Nombre, idProducto, DaDis_CantidadProducto, idEmpleado) values(?, ?, ?, ?)";
            PreparedStatement ADatosDis = CConexion.getConexion().prepareStatement(sql);
            ADatosDis.setString(1, getDaDis_Nombre());

            int SelectProductoo = Producto.getSelectedIndex();
            if (SelectProductoo != -1) {
                Map<Integer, String> IDProducto = (Map<Integer, String>) Producto.getClientProperty("idProducto");
                int selID = (int) IDProducto.keySet().toArray()[SelectProductoo];
                ADatosDis.setInt(2, selID);
            } else {
            }

            ADatosDis.setInt(3, modelo.getCantidadProducto());

            int SelectPEmpleado = Empleado.getSelectedIndex();
            if (SelectPEmpleado != -1) {
                Map<Integer, String> IDEmpleado = (Map<Integer, String>) Empleado.getClientProperty("idEmpleado");
                int selID = (int) IDEmpleado.keySet().toArray()[SelectPEmpleado];
                ADatosDis.setInt(4, selID);
            } else {
            }
            JOptionPane.showMessageDialog(null, "Datos agregados exitosamente ");
            ADatosDis.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en agregar datos de distribucion " + e.toString());
        }
    }

    public void CEliminar(CRutas_DatosDis vistaDistribucion) {
        try {
            int filaSeleccionada = vistaDistribucion.tbDistribucion.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vistaDistribucion.tbDistribucion.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbDatosDistribucion where idDatoDistribucion = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente el dato");
            } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Error al intentar eliminar el dato");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "seleccione un dato");
        }
    }

    public void CActualizar(CRutas_DatosDis vista, DatosDistribucion modelo, JComboBox Producto, JComboBox Empleado) {
        try {

            String sql = "update tbDatosDistribucion set DaDis_Nombre = ?, idProducto=?, DaDis_CantidadProducto = ?, idEmpleado = ? where idDatoDistribucion = ?";
            PreparedStatement ADatosDis = CConexion.getConexion().prepareStatement(sql);
            ADatosDis.setString(1, getDaDis_Nombre());

            int SelectProductoo = Producto.getSelectedIndex();
            if (SelectProductoo != -1) {
                Map<Integer, String> IDProducto = (Map<Integer, String>) Producto.getClientProperty("idProducto");
                int selID = (int) IDProducto.keySet().toArray()[SelectProductoo];
                ADatosDis.setInt(2, selID);
            } else {
            }

            ADatosDis.setInt(3, modelo.getCantidadProducto());

            int SelectPEmpleado = Empleado.getSelectedIndex();
            if (SelectPEmpleado != -1) {
                Map<Integer, String> IDEmpleado = (Map<Integer, String>) Empleado.getClientProperty("idEmpleado");
                int selID = (int) IDEmpleado.keySet().toArray()[SelectPEmpleado];
                ADatosDis.setInt(4, selID);
            } else {

            }

            int filaSeleccionada = vista.tbDistribucion.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbDistribucion.getValueAt(filaSeleccionada, 0).toString();

            JOptionPane.showMessageDialog(null, "Datos Modificados exitosamente ");
            ADatosDis.setString(5, miId);

            ADatosDis.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla " + e.toString());
        }
    }
}
