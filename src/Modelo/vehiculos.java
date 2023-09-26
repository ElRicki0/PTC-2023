/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Controlador.CVehiculo;
import Vista.Usuario.UVehiculos;
import Vista.VVehiculo;
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
public class vehiculos {

    private int idVehiculo;
    private String vehi_Matricula;
    private String idModelo;
    private String idMantenimineto;

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getVehi_Matricula() {
        return vehi_Matricula;
    }

    public void setVehi_Matricula(String vehi_Matricula) {
        this.vehi_Matricula = vehi_Matricula;
    }

    public String getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }

    public String getIdMantenimineto() {
        return idMantenimineto;
    }

    public void setIdMantenimineto(String idMantenimineto) {
        this.idMantenimineto = idMantenimineto;
    }

    public void RellenarBuscador(JComboBox combo) {
        combo.removeAllItems();
        String sql = "select Modelo from tbModelos";
        Statement st;
        CConexion con = new CConexion();
        Connection conexion = con.getConexion();
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString("Modelo"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en modelo vehiculo buscador  " + e.toString());
        }
    }

    public void RellenarModeloCBX(JComboBox combo) {
        Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

        String SSQL = "SELECT idModelo, Modelo FROM tbModelos";
        combo.removeAllItems();

        // Usamos un Map para almacenar pares de ID y nombre
        Map<Integer, String> idModelo = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            pst = conectar.prepareStatement(SSQL);
            result = pst.executeQuery();

            while (result.next()) {
                int id = result.getInt("idModelo");
                String nombre = result.getString("Modelo");
                idModelo.put(id, nombre); // Almacenamos el ID y el nombre en el Map
                combo.addItem(nombre);
            }

            // Almacenamos el Map en las propiedades del combo box
            combo.putClientProperty("idModelo", idModelo);

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
    
    public void RellenarMantenimientoCBX(JComboBox combo) {
        Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

        String SSQL = "SELECT idMantenimiento, Mecanico FROM tbMantenimiento";
        combo.removeAllItems();

        // Usamos un Map para almacenar pares de ID y nombre
        Map<Integer, String> idMecanico = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            pst = conectar.prepareStatement(SSQL);
            result = pst.executeQuery();

            while (result.next()) {
                int id = result.getInt("idMantenimiento");
                String nombre = result.getString("Mecanico");
                idMecanico.put(id, nombre); // Almacenamos el ID y el nombre en el Map
                combo.addItem(nombre);
            }

            // Almacenamos el Map en las propiedades del combo box
            combo.putClientProperty("idMantenimiento", idMecanico);

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

    ///////////Administrador////////////////////////////////////////////////////////////
    public void Buscador(VVehiculo vistaVehiculos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Marca", "Modelo", "Mecanico", "Taller"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select idVehiculo, vehi_Matricula, tbModelos.Modelo, tbMantenimiento.Mecanico, tbTalleres.Tall_Nombre from tbVehiculos \n"
                    + "inner join tbModelos on tbVehiculos.idModelo=tbModelos.idModelo inner join tbMantenimiento on tbVehiculos.idMantenimeinto=tbMantenimiento.idMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller where tbModelos.Modelo='" + vistaVehiculos.jcbBuscador.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idVehiculo"), rs.getString("vehi_Matricula"), rs.getString("Modelo"), rs.getString("Mecanico"), rs.getString("Tall_Nombre")});
            }
            vistaVehiculos.tbVehiculos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla vehiculos A " + e.getMessage());
        }
    }

    public void MostrarTabla(VVehiculo vistaVehiculos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Marca", "Modelo", "Mecanico", "Taller"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select idVehiculo, vehi_Matricula, tbModelos.Modelo, tbMantenimiento.Mecanico, tbTalleres.Tall_Nombre from tbVehiculos \n"
                    + "inner join tbModelos on tbVehiculos.idModelo=tbModelos.idModelo inner join tbMantenimiento on tbVehiculos.idMantenimeinto=tbMantenimiento.idMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idVehiculo"), rs.getString("vehi_Matricula"), rs.getString("Modelo"), rs.getString("Mecanico"), rs.getString("Tall_Nombre")});
            }
            vistaVehiculos.tbVehiculos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla vehiculos A " + e.getMessage());
        }
    }

    public void Agregar(vehiculos modelo, JComboBox comboModelo, JComboBox comboMantenimiento, VVehiculo vista) {
        String SQL = "insert into tbVehiculos (vehi_Matricula, idModelo, idMantenimeinto)values(?,?,?)";
        try {
            PreparedStatement AVehiculo = CConexion.getConexion().prepareStatement(SQL);
            AVehiculo.setString(1, modelo.getVehi_Matricula());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboModelo.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idModelo = (Map<Integer, String>) comboModelo.getClientProperty("idModelo");
                int selectedModeloID = (int) idModelo.keySet().toArray()[selectedMarcaIndex];
                AVehiculo.setInt(2, selectedModeloID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de modelo.");
            }

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboMantenimiento.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idMecanico = (Map<Integer, String>) comboMantenimiento.getClientProperty("idMantenimiento");
                int selectedMecanico = (int) idMecanico.keySet().toArray()[selectedBodegaIndex];
                AVehiculo.setInt(3, selectedMecanico); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un mecanico válida del ComboBox de bodegas.");
            }
            AVehiculo.execute();
            RellenarBuscador(vista.jcbBuscador);
            JOptionPane.showMessageDialog(null, "El vehiculo se agregó correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL vehiculo: " + e.toString());
        }
    }

    public void Eliminar(VVehiculo vista) {
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbVehiculos.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbVehiculos.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbVehiculos where idVehiculo = '" + miId + "'");
                deleteUser.executeUpdate();
            RellenarBuscador(vista.jcbBuscador);
                JOptionPane.showMessageDialog(null, "El vehiculo se elimino correctamente");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error eliminar vehiculo " + e.toString());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato para eliminar");
        }

    }

    public void Actualizar(vehiculos modelo, JComboBox comboModelo, JComboBox comboMantenimiento, VVehiculo vista) {
        String SQL = "update tbVehiculos set vehi_Matricula = ?, idModelo = ?, idMantenimeinto = ? where idVehiculo = ?";
        try {
            PreparedStatement MVehiculo = CConexion.getConexion().prepareStatement(SQL);
            MVehiculo.setString(1, modelo.getVehi_Matricula());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboModelo.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idModelo = (Map<Integer, String>) comboModelo.getClientProperty("idModelo");
                int selectedModeloID = (int) idModelo.keySet().toArray()[selectedMarcaIndex];
                MVehiculo.setInt(2, selectedModeloID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de modelo.");
            }

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboMantenimiento.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idMecanico = (Map<Integer, String>) comboMantenimiento.getClientProperty("idMantenimiento");
                int selectedMecanico = (int) idMecanico.keySet().toArray()[selectedBodegaIndex];
                MVehiculo.setInt(3, selectedMecanico); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un mecanico válida del ComboBox de bodegas.");
            }

            int filaSeleccionada = vista.tbVehiculos.getSelectedRow();
            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbVehiculos.getValueAt(filaSeleccionada, 0).toString();
            MVehiculo.setString(4, miId);

            MVehiculo.execute();
            RellenarBuscador(vista.jcbBuscador);
            JOptionPane.showMessageDialog(null, "El vehiculo se modifico correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a modificar");
        }
    }
    
    ///////////////////////////////////////////////////////////////////////
    public void CBuscador(CVehiculo vistaVehiculos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Marca", "Modelo", "Mecanico", "Taller"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select idVehiculo, vehi_Matricula, tbModelos.Modelo, tbMantenimiento.Mecanico, tbTalleres.Tall_Nombre from tbVehiculos \n"
                    + "inner join tbModelos on tbVehiculos.idModelo=tbModelos.idModelo inner join tbMantenimiento on tbVehiculos.idMantenimeinto=tbMantenimiento.idMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller where tbModelos.Modelo='" + vistaVehiculos.jcbBuscador.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idVehiculo"), rs.getString("vehi_Matricula"), rs.getString("Modelo"), rs.getString("Mecanico"), rs.getString("Tall_Nombre")});
            }
            vistaVehiculos.tbVehiculos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla vehiculos A " + e.getMessage());
        }
    }

    public void CMostrarTabla(CVehiculo vistaVehiculos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Marca", "Modelo", "Mecanico", "Taller"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select idVehiculo, vehi_Matricula, tbModelos.Modelo, tbMantenimiento.Mecanico, tbTalleres.Tall_Nombre from tbVehiculos \n"
                    + "inner join tbModelos on tbVehiculos.idModelo=tbModelos.idModelo inner join tbMantenimiento on tbVehiculos.idMantenimeinto=tbMantenimiento.idMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idVehiculo"), rs.getString("vehi_Matricula"), rs.getString("Modelo"), rs.getString("Mecanico"), rs.getString("Tall_Nombre")});
            }
            vistaVehiculos.tbVehiculos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla vehiculos A " + e.getMessage());
        }
    }

    public void CAgregar(vehiculos modelo, JComboBox comboModelo, JComboBox comboMantenimiento, CVehiculo vista) {
        String SQL = "insert into tbVehiculos (vehi_Matricula, idModelo, idMantenimeinto)values(?,?,?)";
        try {
            PreparedStatement AVehiculo = CConexion.getConexion().prepareStatement(SQL);
            AVehiculo.setString(1, modelo.getVehi_Matricula());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboModelo.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idModelo = (Map<Integer, String>) comboModelo.getClientProperty("idModelo");
                int selectedModeloID = (int) idModelo.keySet().toArray()[selectedMarcaIndex];
                AVehiculo.setInt(2, selectedModeloID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de modelo.");
            }

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboMantenimiento.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idMecanico = (Map<Integer, String>) comboMantenimiento.getClientProperty("idMantenimiento");
                int selectedMecanico = (int) idMecanico.keySet().toArray()[selectedBodegaIndex];
                AVehiculo.setInt(3, selectedMecanico); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un mecanico válida del ComboBox de bodegas.");
            }
            AVehiculo.execute();
            RellenarBuscador(vista.jcbBuscador);
            JOptionPane.showMessageDialog(null, "El vehiculo se agregó correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL vehiculo: " + e.toString());
        }
    }

    public void CEliminar(CVehiculo vista) {
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbVehiculos.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbVehiculos.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbVehiculos where idVehiculo = '" + miId + "'");
                deleteUser.executeUpdate();
            RellenarBuscador(vista.jcbBuscador);
                JOptionPane.showMessageDialog(null, "El vehiculo se elimino correctamente");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error eliminar vehiculo " + e.toString());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato para eliminar");
        }

    }

    public void CActualizar(vehiculos modelo, JComboBox comboModelo, JComboBox comboMantenimiento, CVehiculo vista) {
        String SQL = "update tbVehiculos set vehi_Matricula = ?, idModelo = ?, idMantenimeinto = ? where idVehiculo = ?";
        try {
            PreparedStatement MVehiculo = CConexion.getConexion().prepareStatement(SQL);
            MVehiculo.setString(1, modelo.getVehi_Matricula());

            // Obtener el ID de la marca seleccionada desde el JComboBox de marcas
            int selectedMarcaIndex = comboModelo.getSelectedIndex();
            if (selectedMarcaIndex != -1) {
                Map<Integer, String> idModelo = (Map<Integer, String>) comboModelo.getClientProperty("idModelo");
                int selectedModeloID = (int) idModelo.keySet().toArray()[selectedMarcaIndex];
                MVehiculo.setInt(2, selectedModeloID); // Usar el ID de la marca seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox de modelo.");
            }

            // Obtener el ID de la bodega seleccionada desde el JComboBox de bodegas
            int selectedBodegaIndex = comboMantenimiento.getSelectedIndex();
            if (selectedBodegaIndex != -1) {
                Map<Integer, String> idMecanico = (Map<Integer, String>) comboMantenimiento.getClientProperty("idMantenimiento");
                int selectedMecanico = (int) idMecanico.keySet().toArray()[selectedBodegaIndex];
                MVehiculo.setInt(3, selectedMecanico); // Usar el ID de la bodega seleccionada
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un mecanico válida del ComboBox de bodegas.");
            }

            int filaSeleccionada = vista.tbVehiculos.getSelectedRow();
            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbVehiculos.getValueAt(filaSeleccionada, 0).toString();
            MVehiculo.setString(4, miId);

            MVehiculo.execute();
            RellenarBuscador(vista.jcbBuscador);
            JOptionPane.showMessageDialog(null, "El vehiculo se modifico correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un dato a modificar");
        }
    }

    //////////////////////////////////////////////////////////Apartado de Usuarios///////////////////////////////////////////////////////////////////////////////////////
    public void UMostrarTabla(UVehiculos vistaVehiculos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Marca", "Modelo", "Mecanico", "Taller"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select idVehiculo, vehi_Matricula, tbModelos.Modelo, tbMantenimiento.Mecanico, tbTalleres.Tall_Nombre from tbVehiculos \n"
                    + "inner join tbModelos on tbVehiculos.idModelo=tbModelos.idModelo inner join tbMantenimiento on tbVehiculos.idMantenimeinto=tbMantenimiento.idMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idVehiculo"), rs.getString("vehi_Matricula"), rs.getString("Modelo"), rs.getString("Mecanico"), rs.getString("Tall_Nombre")});
            }
            vistaVehiculos.tbVehiculos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla vehiculos A " + e.getMessage());
        }
    }
    
    public void UBuscador(UVehiculos vistaVehiculos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Marca", "Modelo", "Mecanico", "Taller"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL = "select idVehiculo, vehi_Matricula, tbModelos.Modelo, tbMantenimiento.Mecanico, tbTalleres.Tall_Nombre from tbVehiculos \n"
                    + "inner join tbModelos on tbVehiculos.idModelo=tbModelos.idModelo inner join tbMantenimiento on tbVehiculos.idMantenimeinto=tbMantenimiento.idMantenimiento inner join tbTalleres on tbMantenimiento.idTaller=tbTalleres.idTaller where tbModelos.Modelo='" + vistaVehiculos.jcbBuscador.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idVehiculo"), rs.getString("vehi_Matricula"), rs.getString("Modelo"), rs.getString("Mecanico"), rs.getString("Tall_Nombre")});
            }
            vistaVehiculos.tbVehiculos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla vehiculos A " + e.getMessage());
        }
    }
}
