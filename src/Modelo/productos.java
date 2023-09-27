/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import Vista.*;
import Vista.Controlador.CProducto;
import Vista.Repartidor.RProducto;
import Vista.Usuario.UProducto;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

public class productos {

    VProducto vistaProducto;

    private String idProducto;
    private String prod_nombre;
    private String idMarca;
    private int prod_unidades;
    private String prod_preciounitario;
    private String idBodega;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public int getProd_unidades() {
        return prod_unidades;
    }

    public void setProd_unidades(int prod_unidades) {
        this.prod_unidades = prod_unidades;
    }

    public String getProd_preciounitario() {
        return prod_preciounitario;
    }

    public void setProd_preciounitario(String prod_preciounitario) {
        this.prod_preciounitario = prod_preciounitario;
    }

    public String getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(String idBodega) {
        this.idBodega = idBodega;
    }

    public void RellenarBuscadorCBX(JComboBox combo) {
        combo.removeAllItems();
        String sql = "select MP_Nombre from tbMarcaProductos";
        Statement st;
        CConexion con = new CConexion();
        Connection conexion = con.getConexion();
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString("MP_Nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en marca buscador  " + e.toString());
        }
    }

    public void RellenarReporte_Marca(JComboBox combo) {
        combo.removeAllItems();
        String sql = "select MP_Nombre from tbMarcaProductos";
        Statement st;
        CConexion con = new CConexion();
        Connection conexion = con.getConexion();
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString("MP_Nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en marca buscador  " + e.toString());
        }
    }

    public void RellenarBodegaCBX(JComboBox comboBDG) {
        String SQL = "select idBodega, bdg_nombre from tbBodegas ";
        Statement st;
        CConexion con = new CConexion();
        Connection conexion = con.getConexion();
        Map<Integer, String> bodegasMap = new HashMap<>();

        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                int idBodega = rs.getInt("idBodega");
                String nombreBodega = rs.getString("bdg_nombre");
                bodegasMap.put(idBodega, nombreBodega);
                comboBDG.addItem(nombreBodega);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Bodega     " + e.toString());
        }
        comboBDG.putClientProperty("bodegasMap", bodegasMap);
    }

    public void RellenarMarcaCBX(JComboBox combo) {
        Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

        String SSQL = "SELECT id_MP, MP_Nombre FROM tbMarcaProductos";
        combo.removeAllItems();

        // Usamos un Map para almacenar pares de ID y nombre
        Map<Integer, String> idNombreMar = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            pst = conectar.prepareStatement(SSQL);
            result = pst.executeQuery();

            while (result.next()) {
                int id = result.getInt("id_MP");
                String nombre = result.getString("MP_Nombre");
                idNombreMar.put(id, nombre); // Almacenamos el ID y el nombre en el Map
                combo.addItem(nombre);
            }

            // Almacenamos el Map en las propiedades del combo box
            combo.putClientProperty("idNombreMar", idNombreMar);

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

    /////////////Admin//////////////////////////////////////////////////////////
    public void MostrarProductos(VProducto vistaProducto) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Marca", "Unidades", "Precio C/U", "Bodega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre"
                    + " from tbProductos inner join tbMarcaProductos  on tbProductos.id_MP = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idProducto"), rs.getString("Prod_Nombre"), rs.getString("MP_Nombre"), rs.getInt("Prod_Unidades"), rs.getFloat("Prod_PrecioUnitario"), rs.getString("bdg_nombre")});
            }
            vistaProducto.tbProductos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla producto " + e.getMessage());
        }

    }

    public boolean AgregarProducto(productos productomodelo, JComboBox comboMarca, JComboBox comboBDG) {
        String SQL = "INSERT INTO tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement AProducto = CConexion.getConexion().prepareStatement(SQL);
            AProducto.setString(1, productomodelo.getProd_nombre());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboMarca.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idNombreMar = (Map<Integer, String>) comboMarca.getClientProperty("idNombreMar");
                int selectedMarcaID = (int) idNombreMar.keySet().toArray()[selectedMarcaIndex];
                AProducto.setInt(2, selectedMarcaID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de marcas.");
                return false;
            }

            AProducto.setInt(3, productomodelo.getProd_unidades());
            AProducto.setString(4, productomodelo.getProd_preciounitario());

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboBDG.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idNombreBodega = (Map<Integer, String>) comboBDG.getClientProperty("bodegasMap");
                int selectedBodegaID = (int) idNombreBodega.keySet().toArray()[selectedBodegaIndex];
                AProducto.setInt(5, selectedBodegaID); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una bodega válida del ComboBox de bodegas.");
                return false;
            }

            AProducto.execute();
            JOptionPane.showMessageDialog(null, "El producto se agregó correctamente");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO: " + e.toString());
            return false;
        }
    }

    public void EliminarProducto(VProducto vistaProducto) {
        int filaSeleccionada = vistaProducto.tbProductos.getSelectedRow();

        //Obtenemos el id de la fila seleccionada
        String miId = vistaProducto.tbProductos.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbProductos where idProducto = '" + miId + "'");
            deleteUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la marca");
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Existe registro en rutas con este producto, modifique o elimine el dato en rutas");
        }
    }

    public boolean Actualizarproducto(VProducto vistaProducto, productos productomodelo, JComboBox comboMarca, JComboBox comboBDG) {
        String SQL = "update tbProductos set Prod_Nombre = ?, id_MP=?, Prod_Unidades = ?, Prod_PrecioUnitario = ?, idBodega = ? where idProducto = ?";
        try {
            PreparedStatement updateUser = CConexion.getConexion().prepareStatement(SQL);
            updateUser.setString(1, productomodelo.getProd_nombre());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboMarca.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idNombreMar = (Map<Integer, String>) comboMarca.getClientProperty("idNombreMar");
                int selectedMarcaID = (int) idNombreMar.keySet().toArray()[selectedMarcaIndex];
                updateUser.setInt(2, selectedMarcaID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de marcas.");
                return false;
            }

            updateUser.setInt(3, productomodelo.getProd_unidades());
            updateUser.setString(4, productomodelo.getProd_preciounitario());

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboBDG.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idNombreBodega = (Map<Integer, String>) comboBDG.getClientProperty("bodegasMap");
                int selectedBodegaID = (int) idNombreBodega.keySet().toArray()[selectedBodegaIndex];
                updateUser.setInt(5, selectedBodegaID); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una bodega válida del ComboBox de bodegas.");
                return false;
            }
            int filaSeleccionada = vistaProducto.tbProductos.getSelectedRow();
            String miId = vistaProducto.tbProductos.getValueAt(filaSeleccionada, 0).toString();
            updateUser.setString(6, miId);

            updateUser.execute();
            JOptionPane.showMessageDialog(null, "El producto se modifico correctamente");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto a editar");
            return false;
        }
    }
    
    /////////////////////////////Controlador////////////////////////////////////////////////
    
    public void CMostrarProductos(CProducto vistaProducto) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Marca", "Unidades", "Precio C/U", "Bodega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre"
                    + " from tbProductos inner join tbMarcaProductos  on tbProductos.id_MP = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idProducto"), rs.getString("Prod_Nombre"), rs.getString("MP_Nombre"), rs.getInt("Prod_Unidades"), rs.getFloat("Prod_PrecioUnitario"), rs.getString("bdg_nombre")});
            }
            vistaProducto.tbProductos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla producto " + e.getMessage());
        }

    }

    public boolean CAgregarProducto(productos productomodelo, JComboBox comboMarca, JComboBox comboBDG) {
        String SQL = "INSERT INTO tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement AProducto = CConexion.getConexion().prepareStatement(SQL);
            AProducto.setString(1, productomodelo.getProd_nombre());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboMarca.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idNombreMar = (Map<Integer, String>) comboMarca.getClientProperty("idNombreMar");
                int selectedMarcaID = (int) idNombreMar.keySet().toArray()[selectedMarcaIndex];
                AProducto.setInt(2, selectedMarcaID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de marcas.");
                return false;
            }

            AProducto.setInt(3, productomodelo.getProd_unidades());
            AProducto.setString(4, productomodelo.getProd_preciounitario());

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboBDG.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idNombreBodega = (Map<Integer, String>) comboBDG.getClientProperty("bodegasMap");
                int selectedBodegaID = (int) idNombreBodega.keySet().toArray()[selectedBodegaIndex];
                AProducto.setInt(5, selectedBodegaID); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una bodega válida del ComboBox de bodegas.");
                return false;
            }

            AProducto.execute();
            JOptionPane.showMessageDialog(null, "El producto se agregó correctamente");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO: " + e.toString());
            return false;
        }
    }

    public void CEliminarProducto(CProducto vistaProducto) {
        int filaSeleccionada = vistaProducto.tbProductos.getSelectedRow();

        //Obtenemos el id de la fila seleccionada
        String miId = vistaProducto.tbProductos.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbProductos where idProducto = '" + miId + "'");
            deleteUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la marca");
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Existe registro en rutas con este producto, modifique o elimine el dato en rutas");
        }
    }

    public boolean CActualizarproducto(CProducto vistaProducto, productos productomodelo, JComboBox comboMarca, JComboBox comboBDG) {
        String SQL = "update tbProductos set Prod_Nombre = ?, id_MP=?, Prod_Unidades = ?, Prod_PrecioUnitario = ?, idBodega = ? where idProducto = ?";
        try {
            PreparedStatement updateUser = CConexion.getConexion().prepareStatement(SQL);
            updateUser.setString(1, productomodelo.getProd_nombre());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboMarca.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idNombreMar = (Map<Integer, String>) comboMarca.getClientProperty("idNombreMar");
                int selectedMarcaID = (int) idNombreMar.keySet().toArray()[selectedMarcaIndex];
                updateUser.setInt(2, selectedMarcaID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de marcas.");
                return false;
            }

            updateUser.setInt(3, productomodelo.getProd_unidades());
            updateUser.setString(4, productomodelo.getProd_preciounitario());

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboBDG.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idNombreBodega = (Map<Integer, String>) comboBDG.getClientProperty("bodegasMap");
                int selectedBodegaID = (int) idNombreBodega.keySet().toArray()[selectedBodegaIndex];
                updateUser.setInt(5, selectedBodegaID); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una bodega válida del ComboBox de bodegas.");
                return false;
            }
            int filaSeleccionada = vistaProducto.tbProductos.getSelectedRow();
            String miId = vistaProducto.tbProductos.getValueAt(filaSeleccionada, 0).toString();
            updateUser.setString(6, miId);

            updateUser.execute();
            JOptionPane.showMessageDialog(null, "El producto se modifico correctamente");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto a editar");
            return false;
        }
    }
        
    ////////////Repartidor///////////////////////////////////////////////////////////
    public void RMostrarProductos(RProducto vistaProducto) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Marca", "Unidades", "Precio C/U", "Bodega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre"
                    + " from tbProductos inner join tbMarcaProductos  on tbProductos.id_MP = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idProducto"), rs.getString("Prod_Nombre"), rs.getString("MP_Nombre"), rs.getInt("Prod_Unidades"), rs.getFloat("Prod_PrecioUnitario"), rs.getString("bdg_nombre")});
            }
            vistaProducto.tbProductos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla producto " + e.getMessage());
        }

    }
    
    /////////////////////////////Usuarios///////////////////////////////////////////////
    public void UMostrarProductos(UProducto vistaProducto) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Marca", "Unidades", "Precio C/U", "Bodega"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre"
                    + " from tbProductos inner join tbMarcaProductos  on tbProductos.id_MP = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idProducto"), rs.getString("Prod_Nombre"), rs.getString("MP_Nombre"), rs.getInt("Prod_Unidades"), rs.getFloat("Prod_PrecioUnitario"), rs.getString("bdg_nombre")});
            }
            vistaProducto.tbProductos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla producto " + e.getMessage());
        }

    }
}
