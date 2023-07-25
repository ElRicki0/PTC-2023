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


public class usuarios {
    private int idUsuario;
    private String usr_nombre;
    private String usr_contra;
    private int idEmpleado;
    private int idnivelUser;
    private int idBodega;

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

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdnivelUser() {
        return idnivelUser;
    }

    public void setIdnivelUser(int idnivelUser) {
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
//            PreparedStatement VUsuario = CConexion.getConexion().prepareStatement(SQL);
//            VUsuario.setString(1, getUsr_nombre());
//            VUsuario.setString(2, getUsr_nombre());
//            VUsuario.execute();
            if (rs.next()) 
            {
                
                resultado=1;
                if (resultado==1) 
                {
                    Main main = new Main();
                    main.INIT();                            
//                    LoginPTC login= new LoginPTC();
//                    login.setVisible(false);
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
            
    
}
