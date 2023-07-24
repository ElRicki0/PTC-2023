/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.LoginPTC;
import Vista.Main;
import Vista.PrimerUso;
import Vista.PrimerUsuario;
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
                 login.setVisible(true);
                   PrimerUso primer = new PrimerUso();
                   primer.setVisible(false);
                }                
            }
            else
            {
                PrimerUsuario primero = new PrimerUsuario();
                primero.setVisible(true);

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
                    main.setVisible(true);
                    LoginPTC login= new LoginPTC();
                    login.setVisible(false);
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "error de acceso de usuario");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }
            
    
}
