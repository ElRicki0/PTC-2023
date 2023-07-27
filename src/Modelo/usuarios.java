/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.*;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class usuarios {
    
    
    
    
    private int idUsuario;
    private String usr_nombre;
    private String usr_contra;
    private String usr_preguntasSeguridad;
    private String idEmpleado;
    private String idnivelUser;
    private int idBodega;

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

    public String getUsr_nombre() {
        return usr_nombre;
    }

    public void setUsr_nombre(String usr_nombre) {
        this.usr_nombre = usr_nombre;
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
               
    public void PMUsuario(usuarios modeloUsuario){
        
           String sql="insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser)values(?, ?, 1, 1);";
           try {
            PreparedStatement AUsuario= CConexion.getConexion().prepareStatement(sql);
            AUsuario.setString(1, modeloUsuario.getUsr_nombre());
            AUsuario.setString(2, modeloUsuario.getUsr_contra());
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");        
            AUsuario.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar Usuario " +e.toString());        
        }
        
    }
    
    public void PrimerUso(usuarios modeloUsuario){
        int resultado =0;
        String sql="select idUsuario from tbUsuarios";
        try {
            Statement sta =CConexion.getConexion().createStatement();
            ResultSet rs= sta.executeQuery(sql);
            if (rs.next()) {
                resultado=1;
                if(resultado==1){
                 LoginPTC login = new LoginPTC();
                 login.INIT();
                   PrimerUso primer = new PrimerUso();
                   primer.setVisible(false);
                }                
            }
            else
            {
                PrimerEmpleado PU = new PrimerEmpleado();
                PU.INIT();

            }
            
        } catch (Exception oe) {
                JOptionPane.showMessageDialog(null, "error 1"+oe.toString());
        }
    }
    
    public void ValidarUsuario(usuarios modeloUsuario){
        int resultado=0;
        String SQL="select*from tbUsuarios where usr_nombre='"+usr_nombre+"' and usr_contrasenia='"+usr_contra+"';";

        try {            
            Statement sta = CConexion.getConexion().createStatement();
            ResultSet rs= sta.executeQuery(SQL);
            if (rs.next()) 
            {
                
                resultado=1;
                if (resultado==1) 
                {
                    Main main = new Main();
                    main.INIT();                         
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "error de acceso de usuario");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en modelo usuario"+e.getMessage());
        }
    }
    
    public void mostrarUsuarios(VUsuarios vistaUsuarios){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID","Nombre", "Contraseña", "Nombre Empleado", "Nivel Usuario"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String sql ="select idUsuario, usr_nombre, usr_contrasenia, idEmpleado, idNivelUser from tbUsuarios";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idUsuario"), rs.getString("usr_nombre"), rs.getString("usr_contrasenia"), rs.getInt("idEmpleado"), rs.getInt("idNivelUser")});
            }
            vistaUsuarios.tbEmpleados.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla empleados "+e.getMessage());                
        }
    }
            
    String NombreE = getIdEmpleado();
    
    public void AUsuarios(usuarios modeloUsuario){
         try {
//             String texto1 = vistaUsuarios.jcbEmpleado.getSelectedItem().toString();
//            if (texto1==) {
//                
//            } else {
//            }
            PreparedStatement AUsuario = CConexion.getConexion().prepareStatement("insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser) values(?,?,?,?)");

            AUsuario.setString(1, modeloUsuario.getUsr_nombre());
            AUsuario.setString(2, modeloUsuario.getUsr_contra());
            AUsuario.setInt(3, Integer.parseInt(modeloUsuario.getIdEmpleado()));
            AUsuario.setInt(4, Integer.parseInt(modeloUsuario.getIdnivelUser()));
            AUsuario.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "el empleado ya esta en uso ");        
        }
    }
    
    public void jcbEmpleado(JComboBox combox){
        String sql="select idEmpleado from tbEmpleados";
        Statement st;
    CConexion con = new CConexion();
    Connection conexion=con.getConexion();
        try {
            st= conexion.createStatement();
            ResultSet rs= st.executeQuery(sql) ;
            while(rs.next()){
                combox.addItem(rs.getString("idEmpleado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en modelo empleado cbx "+ e.toString());
        }
    }
            
    public void jcbNivelesU(JComboBox combox){
        String sql="select idNivelUser from tbNivelesUsuarios";
        Statement st;
    CConexion con = new CConexion();
    Connection conexion=con.getConexion();
        try {
            st= conexion.createStatement();
            ResultSet rs= st.executeQuery(sql) ;
            while(rs.next()){
                combox.addItem(rs.getString("idNivelUser"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en niveles usuariocbx "+ e.toString());
        }
    }
}
