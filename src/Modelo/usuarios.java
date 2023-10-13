/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ctrlEncriptacion;
import Vista.*;
import Controlador.ctrlLogin;
import Vista.Controlador.CEmpleados_Usuarios;
import Vista.Controlador.CMain;
import Vista.Controlador.CMain;
import Vista.Repartidor.RMain;
import Vista.Usuario.UMain;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class usuarios {

    private int idUsuario;
    private static String usr_nombre;
    private String usr_contra;
    private String usr_preguntasSeguridad;
    private String idEmpleado;
    private String idnivelUser;
    private int idBodega;
    private ctrlLogin login;
    private ctrlEncriptacion encript;

    public String getUsr_preguntasSeguridad() {
        return usr_preguntasSeguridad;
    }

    public void setUsr_preguntasSeguridad(String usr_preguntasSeguridad) {
        this.usr_preguntasSeguridad = usr_preguntasSeguridad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static String getUsr_nombre() {
        return usr_nombre;
    }

    public static void setUsr_nombre(String usr_nombre) {
        usuarios.usr_nombre = usr_nombre;
    }

    public String getUsr_contra() {
        return usr_contra;
    }

    public void setUsr_contra(String usr_contra) {
        this.usr_contra = usr_contra;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdnivelUser() {
        return idnivelUser;
    }

    public void setIdnivelUser(String idnivelUser) {
        this.idnivelUser = idnivelUser;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public void ActNuevaContra(usuarios modeloUsuario) {

        try {

            String sql = "update tbUsuarios set usr_contrasenia=? where usr_nombre=?";
            try {
                PreparedStatement AUsuario = CConexion.getConexion().prepareStatement(sql);
                AUsuario.setString(1, modeloUsuario.getUsr_contra());
                AUsuario.setString(2, modeloUsuario.getUsr_nombre());
                JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
                AUsuario.execute();

                System.out.println("nombre es " + getUsr_nombre().toString());
                System.out.println("contra es " + getUsr_contra().toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error actualizar contrasenia" + e.toString());
                System.out.println(e.toString());
            }
        } catch (Exception ae) {
            System.out.println("" + ae.toString());
        }
    }

    public void PMUsuario(usuarios modeloUsuario) {

        String sql = "insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser)values(?, ?, 1, 1);";
        try {
            PreparedStatement AUsuario = CConexion.getConexion().prepareStatement(sql);
            AUsuario.setString(1, modeloUsuario.getUsr_nombre());
            AUsuario.setString(2, modeloUsuario.getUsr_contra());
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
            AUsuario.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void PrimerUso(usuarios modeloUsuario) {
        int resultado = 0;
        String sql = "select idUsuario from tbUsuarios";
        try {
            Statement sta = CConexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    LoginPTC login = new LoginPTC();
                    login.INIT();
                    PrimerUso primer = new PrimerUso();
                    primer.setVisible(false);
                }
            } else {
                PrimerEmpleado PU = new PrimerEmpleado();
                PU.INIT();

            }

        } catch (Exception oe) {
            JOptionPane.showMessageDialog(null, "error 1" + oe.toString());
        }
    }

    public String obtenerContraseñaDesdeBD() {
        String contraseñaAlmacenada = "";

        String sql = "SELECT usr_contrasenia FROM tbUsuarios WHERE usr_nombre = ?;";
        try {
            Connection con = CConexion.getConexion();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, this.usr_nombre);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                contraseñaAlmacenada = rs.getString("usr_contrasenia");
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener contraseña: " + e.toString());
        }

        return contraseñaAlmacenada;
    }

    public void ValidarUsuario(usuarios modeloUsuario) {

        String sql = "SELECT * FROM tbUsuarios WHERE usr_nombre = ?;";
        try {
            Connection con = CConexion.getConexion();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, modeloUsuario.getUsr_nombre());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String u = rs.getString("usr_nombre");
                String contraseñaAlmacenada = rs.getString("usr_contrasenia");
                String nivelU = rs.getString("idNivelUser");

                if (modeloUsuario.getUsr_contra().equals(contraseñaAlmacenada)) {
                    if (nivelU.equals("1")) {
                        LoginPTC vista = new LoginPTC();
                        vista.dispose();
                        VMain main = new VMain();
                        main.INIT();
                        if (contraseñaAlmacenada.matches("9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c")) {
                            ActContra vistaContra = new ActContra();
                            vistaContra.INIT();
                        }
                    }
                    if (nivelU.equals("2")) {
                        LoginPTC vista = new LoginPTC();
                        vista.setVisible(false);
                        CMain main = new CMain();
                        main.INIT();
                        if (contraseñaAlmacenada.matches("9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c")) {
                            ActContra vistaContra = new ActContra();
                            vistaContra.INIT();
                        }
                    }
                    if (nivelU.equals("3")) {
                        RMain main = new RMain();
                        main.INIT();
                        LoginPTC vista = new LoginPTC();
                        vista.dispose();
                        if (contraseñaAlmacenada.matches("9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c")) {
                            ActContra vistaContra = new ActContra();
                            vistaContra.INIT();
                        }
                    }
                    if (nivelU.equals("4")) {
                        UMain main = new UMain();
                        main.INIT();
                        LoginPTC vista = new LoginPTC();
                        vista.dispose();
                        if (contraseñaAlmacenada.matches("9b8769a4a742959a2d0298c36fb70623f2dfacda8436237df08d8dfd5b37374c")) {
                            ActContra vistaContra = new ActContra();
                            vistaContra.INIT();
                        }
                    } else {
//                        JOptionPane.showMessageDialog(null, "entidad tipo "+nivelU.toString());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas");
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la validación: " + e.toString());
        }

    }

    public void jcbEmpleado(JComboBox combox) {
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

    public void jcbNivelesU(JComboBox combox) {

        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select idNivelUser, usr_Nivel from tbNivelesUsuarios";
        combox.removeAllItems();
        Map<Integer, String> idNivelUser = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idNivelUser");
                String NUser = rs.getString("usr_Nivel");
                idNivelUser.put(id, NUser);
                combox.addItem(NUser);
            }
            combox.putClientProperty("idNivelUser", idNivelUser);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx Nivel User " + e.toString());
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

    public void ActualizarContra(usuarios modeloUsuario) {
        try {
            String sql = "update tbUsuarios set usr_contrasenia=? where usr_nombre=?";
            try {
                PreparedStatement AUsuario = CConexion.getConexion().prepareStatement(sql);
                AUsuario.setString(1, modeloUsuario.getUsr_contra());
                AUsuario.setString(2, modeloUsuario.getUsr_nombre());
                JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
                AUsuario.execute();
                LoginPTC vistaLogin = new LoginPTC();
                vistaLogin.INIT();
                NuevoContra vistaN = new NuevoContra();
                vistaN.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error actualizar contrasenia" + e.toString());
                System.out.println(e.toString());
            }
        } catch (Exception e) {
            System.out.println("" + e.toString());
        }
    }

    public void mostrarUsuarios(VEmpleados_Usuarios vistaUsuarios) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Usuario", "Nombre Empleado", "Nivel Usuario"});
        try {
            Statement st = CConexion.getConexion().createStatement();
//        String sql = "select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser";
            String sql = "select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idUsuario"), rs.getString("usr_nombre"), rs.getString("emp_nombre"), rs.getString("usr_Nivel")});
            }
            vistaUsuarios.tbEmpleados.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    }

    public void AUsuarios(usuarios modeloUsuario, JComboBox jcbEmpleado, JComboBox jcbUsuario) {
        try {

            PreparedStatement AUsuario = CConexion.getConexion().prepareStatement("insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser) values(?,?,?,?)");

            AUsuario.setString(1, modeloUsuario.getUsr_nombre());
            AUsuario.setString(2, modeloUsuario.getUsr_contra());

            int SelectEmpelado = jcbEmpleado.getSelectedIndex();
            if (SelectEmpelado != -1) {
                Map<Integer, String> idEmpleado = (Map<Integer, String>) jcbEmpleado.getClientProperty("idEmpleado");
                int selID = (int) idEmpleado.keySet().toArray()[SelectEmpelado];
                AUsuario.setInt(3, selID);
            } else {
            }

            int SelectTUsuario = jcbUsuario.getSelectedIndex();
            if (SelectTUsuario != -1) {
                Map<Integer, String> idNivelUser = (Map<Integer, String>) jcbUsuario.getClientProperty("idNivelUser");
                int selID = (int) idNivelUser.keySet().toArray()[SelectTUsuario];
                AUsuario.setInt(4, selID);
            } else {
            }
            AUsuario.execute();
            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El empleado ya esta en uso, eliga otro empleado o cree uno nuevo");
        }
    }

    public void EliminarUsuario(VEmpleados_Usuarios vistaUsuario) {
        try {
            int filaSeleccionada = vistaUsuario.tbEmpleados.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vistaUsuario.tbEmpleados.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbUsuarios where idUsuario = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente el usuario");
            } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Error al intentar eliminar el usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "seleccione un usuario");
        }

    }

    public void ActualizarUsuario(usuarios modeloUsuario, JComboBox jcbEmpleado, JComboBox jcbUsuario, VEmpleados_Usuarios vistaUsuarios) {
        try {

            PreparedStatement ACUsuario = CConexion.getConexion().prepareStatement("update tbUsuarios set usr_nombre=?, idEmpleado=?, idNivelUser=? where idUsuario=? ");

            ACUsuario.setString(1, modeloUsuario.getUsr_nombre());

            int SelectEmpelado = jcbEmpleado.getSelectedIndex();
            if (SelectEmpelado != -1) {
                Map<Integer, String> idEmpleado = (Map<Integer, String>) jcbEmpleado.getClientProperty("idEmpleado");
                int selID = (int) idEmpleado.keySet().toArray()[SelectEmpelado];
                ACUsuario.setInt(2, selID);
            } else {
            }

            int SelectTUsuario = jcbUsuario.getSelectedIndex();
            if (SelectTUsuario != -1) {
                Map<Integer, String> idNivelUser = (Map<Integer, String>) jcbUsuario.getClientProperty("idNivelUser");
                int selID = (int) idNivelUser.keySet().toArray()[SelectTUsuario];
                ACUsuario.setInt(3, selID);
            } else {
            }
            int filaSeleccionada = vistaUsuarios.tbEmpleados.getSelectedRow();
            String miId = vistaUsuarios.tbEmpleados.getValueAt(filaSeleccionada, 0).toString();
            ACUsuario.setString(4, miId);

            JOptionPane.showMessageDialog(null, "Usuario Modificado con exito");
            ACUsuario.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un valor a modificar ");
        }
    }
    
    public void MostrarNombre(){
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql = "SELECT E.emp_nombre AS NombreEmpleadoFROM tbUsuarios AS UINNER JOIN tbEmpleados AS E ON U.idEmpleado = E.idEmpleadoWHERE U.usr_nombre = '"+usuarios.getUsr_nombre()+"';";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {                 
                String Usuario = rs.getString("emp_nombre");
                System.out.println("");
            }
        } catch (Exception e) {
        }
        
    }

    /////////////////////////Controlador/////////////////////////////////////////////////////
    public void CjcbNivelesU(JComboBox combox) {

        Connection conectar = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select idNivelUser, usr_Nivel from tbNivelesUsuarios where idNivelUser in (2, 3, 4)";
        combox.removeAllItems();
        Map<Integer, String> idNivelUser = new HashMap<>();

        try {
            conectar = CConexion.getConexion();
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idNivelUser");
                String NUser = rs.getString("usr_Nivel");
                idNivelUser.put(id, NUser);
                combox.addItem(NUser);
            }
            combox.putClientProperty("idNivelUser", idNivelUser);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error cbx Nivel User " + e.toString());
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

    public void CmostrarUsuarios(CEmpleados_Usuarios vistaUsuarios) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Usuario", "Nombre Empleado", "Nivel Usuario"});
        try {
            Statement st = CConexion.getConexion().createStatement();
//        String sql = "select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser";
            String sql = "select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idUsuario"), rs.getString("usr_nombre"), rs.getString("emp_nombre"), rs.getString("usr_Nivel")});
            }
            vistaUsuarios.tbEmpleados.setModel(modelo); // Corregir el nombre de la tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
        }
    }

    public void CAUsuarios(usuarios modeloUsuario, JComboBox jcbEmpleado, JComboBox jcbUsuario) {
        try {

            PreparedStatement AUsuario = CConexion.getConexion().prepareStatement("insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser) values(?,?,?,?)");

            AUsuario.setString(1, modeloUsuario.getUsr_nombre());
            AUsuario.setString(2, modeloUsuario.getUsr_contra());

            int SelectEmpelado = jcbEmpleado.getSelectedIndex();
            if (SelectEmpelado != -1) {
                Map<Integer, String> idEmpleado = (Map<Integer, String>) jcbEmpleado.getClientProperty("idEmpleado");
                int selID = (int) idEmpleado.keySet().toArray()[SelectEmpelado];
                AUsuario.setInt(3, selID);
            } else {
            }

            int SelectTUsuario = jcbUsuario.getSelectedIndex();
            if (SelectTUsuario != -1) {
                Map<Integer, String> idNivelUser = (Map<Integer, String>) jcbUsuario.getClientProperty("idNivelUser");
                int selID = (int) idNivelUser.keySet().toArray()[SelectTUsuario];
                AUsuario.setInt(4, selID);
            } else {
            }
            AUsuario.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El empleado ya esta en uso, eliga otro empleado o cree uno nuevo");
        }
    }

    public void CEliminarUsuario(CEmpleados_Usuarios vistaUsuario) {
        try {
            int filaSeleccionada = vistaUsuario.tbEmpleados.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vistaUsuario.tbEmpleados.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbUsuarios where idUsuario = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente el usuario");
            } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Error al intentar eliminar el usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "seleccione un usuario");
        }

    }

    public void CActualizarUsuario(usuarios modeloUsuario, JComboBox jcbEmpleado, JComboBox jcbUsuario, CEmpleados_Usuarios vistaUsuarios) {
        try {

            PreparedStatement ACUsuario = CConexion.getConexion().prepareStatement("update tbUsuarios set usr_nombre=?, idEmpleado=?, idNivelUser=? where idUsuario=? ");

            ACUsuario.setString(1, modeloUsuario.getUsr_nombre());

            int SelectEmpelado = jcbEmpleado.getSelectedIndex();
            if (SelectEmpelado != -1) {
                Map<Integer, String> idEmpleado = (Map<Integer, String>) jcbEmpleado.getClientProperty("idEmpleado");
                int selID = (int) idEmpleado.keySet().toArray()[SelectEmpelado];
                ACUsuario.setInt(2, selID);
            } else {
            }

            int SelectTUsuario = jcbUsuario.getSelectedIndex();
            if (SelectTUsuario != -1) {
                Map<Integer, String> idNivelUser = (Map<Integer, String>) jcbUsuario.getClientProperty("idNivelUser");
                int selID = (int) idNivelUser.keySet().toArray()[SelectTUsuario];
                ACUsuario.setInt(3, selID);
            } else {
            }
            int filaSeleccionada = vistaUsuarios.tbEmpleados.getSelectedRow();
            String miId = vistaUsuarios.tbEmpleados.getValueAt(filaSeleccionada, 0).toString();
            ACUsuario.setString(4, miId);

            JOptionPane.showMessageDialog(null, "Usuario Modificado con exito");
            ACUsuario.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un valor a modificar ");
        }
    }

}
