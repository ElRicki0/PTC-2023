/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
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
        String sql= "select *from tbUsuarios where usr_nombre=? and usr_contrasenia=?";
        try {
            System.out.println("clic en modelo");
            Connection con = CConexion.getConexion();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, modeloUsuario.getUsr_nombre());
            st.setString(2, modeloUsuario.getUsr_contra());
            ResultSet rs= st.executeQuery();
            if (rs.next()) {
                String u = rs.getString("usr_nombre");
                String p = rs.getString("usr_contrasenia");
                String n = rs.getString("idNivelUser");
                if (modeloUsuario.getUsr_nombre().equals(u)) {
                    if (modeloUsuario.getUsr_contra().equals(p)) {
                        if (modeloUsuario.getIdnivelUser().equals(1)) {
                            Main main = new Main();
                            main.setVisible(true);                           
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "eres otra eentidad");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El la contraseña es incorrecta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe");
                }
            } else {
            }
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
        }
        
//        int resultado=0;
//        String SQL="select*from tbUsuarios where usr_nombre='"+usr_nombre+"' and usr_contrasenia='"+usr_contra+"';";
//
//        try {            
//            Statement sta = CConexion.getConexion().createStatement();
//            ResultSet rs= sta.executeQuery(SQL);
//            if (rs.next()) 
//            {
//                
//                resultado=1;
//                if (resultado==1) 
//                {
//                    Main main = new Main();
//                    main.INIT();                         
//                }
//            }
//            else 
//            {
//                JOptionPane.showMessageDialog(null, "error de acceso de usuario");
//            }
//        } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Error en modelo usuario"+e.getMessage());
//        }
    }
    
    public void mostrarUsuarios(VUsuarios vistaUsuarios) {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"ID", "Usuario", "Contraseña", "Nombre Empleado", "Nivel Usuario"});
    try {
        Statement st = CConexion.getConexion().createStatement();
//        String sql = "select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser";
        String sql = "select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser";
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
            modelo.addRow(new Object[]{rs.getInt("idUsuario"), rs.getString("usr_nombre"), rs.getString("usr_contrasenia"), rs.getString("emp_nombre"), rs.getString("usr_Nivel")});
        }
        vistaUsuarios.tbEmpleados.setModel(modelo); // Corregir el nombre de la tabla
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error tabla usuarios " + e.getMessage());
    }
}

    
//    public void mostrarUsuarios(VUsuarios vistaUsuarios){
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.setColumnIdentifiers(new Object[]{"ID","Usuario", "Contraseña", "Nombre Empleado", "Nivel Usuario"});
//        try {
//            Statement st = CConexion.getConexion().createStatement();
//          String sql ="select tbUsuarios.idUsuario, tbUsuarios.usr_nombre, tbUsuarios.usr_contrasenia, tbEmpleados.emp_nombre, tbNivelesUsuarios.usr_Nivel from tbUsuarios inner join tbEmpleados on tbUsuarios.idEmpleado=tbEmpleados.idEmpleado INNER JOIN tbNivelesUsuarios on tbUsuarios.idNivelUser=tbNivelesUsuarios.idNivelUser";
//            
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                modelo.addRow(new Object[]{rs.getInt("idUsuario"), rs.getString("usr_nombre"), rs.getString("usr_contrasenia"), rs.getInt("tbEmpleados.emp_nombre"), rs.getInt("tbNivelesUsuarios.usr_Nivel")});
//            }
//            vistaUsuarios.tbEmpleados.setModel(modelo);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error tabla empleados "+e.getMessage());                
//        }
//    }
            
    String NombreE = getIdEmpleado();
    
    
    public void jcbEmpleado(JComboBox combox){            
    Connection conectar = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select idEmpleado, emp_nombre from tbEmpleados";
    combox.removeAllItems();
    Map<Integer, String> idEmpleado = new HashMap<>();
    
        try {
            conectar=CConexion.getConexion();
            ps=conectar.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("idEmpleado");
                String TEmpleado = rs.getString("emp_nombre");
                idEmpleado.put(id, TEmpleado);
                combox.addItem(TEmpleado);
            }
            combox.putClientProperty("idEmpleado", idEmpleado);
            
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error cbx Empleado "+e.toString());
        }finally{
            if (conectar!=null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar=null;
                    rs=null;
                    
                } catch (Exception e) {
                }
            }
        
//        String sql="select idEmpleado from tbEmpleados";
//        Statement st;
//    CConexion con = new CConexion();
//    Connection conexion=con.getConexion();
//        try {
//            st= conexion.createStatement();
//            ResultSet rs= st.executeQuery(sql) ;
//            while(rs.next()){
//                combox.addItem(rs.getString("idEmpleado"));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error en modelo empleado cbx "+ e.toString());
//        }
    }
    }
            
    public void jcbNivelesU(JComboBox combox){

        Connection conectar = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select idNivelUser, usr_Nivel from tbNivelesUsuarios";
    combox.removeAllItems();
    Map<Integer, String> idNivelUser = new HashMap<>();
    
        try {
            conectar=CConexion.getConexion();
            ps=conectar.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("idNivelUser");
                String NUser = rs.getString("usr_Nivel");
                idNivelUser.put(id, NUser);
                combox.addItem(NUser);
            }
            combox.putClientProperty("idNivelUser", idNivelUser);
            
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error cbx Nivel User "+e.toString());
        }finally{
            if (conectar!=null) {
                try {
                    conectar.close();
                    rs.close();
                    conectar=null;
                    rs=null;
                    
                } catch (Exception e) {
                }
            }

//        String sql="select idNivelUser from tbNivelesUsuarios";
//        Statement st;
//    CConexion con = new CConexion();
//    Connection conexion=con.getConexion();
//        try {
//            st= conexion.createStatement();
//            ResultSet rs= st.executeQuery(sql) ;
//            while(rs.next()){
//                combox.addItem(rs.getString("idNivelUser"));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error en niveles usuariocbx "+ e.toString());
//        }
    }
}
    
    public void AUsuarios(usuarios modeloUsuario, JComboBox jcbEmpleado, JComboBox jcbUsuario){
         try {
//             String texto1 = vistaUsuarios.jcbEmpleado.getSelectedItem().toString();
//            if (texto1==) {
//                
//            } else {
//            }
            PreparedStatement AUsuario = CConexion.getConexion().prepareStatement("insert into tbUsuarios(usr_nombre, usr_contrasenia, idEmpleado, idNivelUser) values(?,'pass123',?,?)");

            AUsuario.setString(1, modeloUsuario.getUsr_nombre());
            
            int SelectEmpelado= jcbEmpleado.getSelectedIndex();
            if (SelectEmpelado!=-1) {
                Map<Integer, String> idEmpleado = (Map<Integer, String>)jcbEmpleado.getClientProperty("idEmpleado");
                int selID=(int) idEmpleado.keySet().toArray()[SelectEmpelado];
                AUsuario.setInt(2, selID);
            } else {
            }
            
            int SelectTUsuario= jcbUsuario.getSelectedIndex();
            if (SelectTUsuario!=-1) {
                Map<Integer, String> idNivelUser = (Map<Integer, String>)jcbUsuario.getClientProperty("idNivelUser");
                int selID=(int) idNivelUser.keySet().toArray()[SelectTUsuario];
                AUsuario.setInt(3, selID);
            } else {
            }
            
            AUsuario.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "el empleado ya esta en uso ");        
        }
    }
    
     public void EliminarUsuario (VUsuarios vistaUsuario){
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
}
