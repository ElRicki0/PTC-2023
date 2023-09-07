/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VTaller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class talleres {
    private int idTaller;
    private String Tall_Nombre;
    private String Tall_Telefono;
    private String Tall_Correo; 
    private String Tall_Dueño;

    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }

    public String getTall_Nombre() {
        return Tall_Nombre;
    }

    public void setTall_Nombre(String Tall_Nombre) {
        this.Tall_Nombre = Tall_Nombre;
    }

    public String getTall_Telefono() {
        return Tall_Telefono;
    }

    public void setTall_Telefono(String Tall_Telefono) {
        this.Tall_Telefono = Tall_Telefono;
    }

    public String getTall_Correo() {
        return Tall_Correo;
    }

    public void setTall_Correo(String Tall_Correo) {
        this.Tall_Correo = Tall_Correo;
    }

    public String getTall_Dueño() {
        return Tall_Dueño;
    }

    public void setTall_Dueño(String Tall_Dueño) {
        this.Tall_Dueño = Tall_Dueño;
    }
    
    public void MostratTabla(VTaller vista){
         DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID","Nombre", "Telefono", "Correo", "Dueño"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql ="select *from tbTalleres";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idTaller"), rs.getString("Tall_Nombre"), rs.getString("Tall_Telefono"), rs.getString("Tall_Correo"), rs.getString("Tall_Duenio")});
            }
            vista.tbTaller.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla taller "+e.getMessage());                
        }
    }
    
    public void Agregar(talleres modelo){
        String sql="insert into tbTalleres (Tall_Nombre, Tall_Telefono, Tall_Correo, Tall_Duenio)values (?,?,?,?)";
        try {
            PreparedStatement ATaller = CConexion.getConexion().prepareStatement(sql);
            ATaller.setString (1, modelo.getTall_Nombre());
            ATaller.setString(2, modelo.getTall_Telefono());
            ATaller.setString(3, modelo.getTall_Correo());
            ATaller.setString (4, modelo.getTall_Dueño());
            ATaller.executeUpdate();
            JOptionPane.showMessageDialog(null, "El taller  se agrego correctamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en el modelo del taller"+ e.toString());   
        }
    }
    
    public void Eliminar(VTaller vista){
        try {
            //obtenemos que fila seleccionó el usuario
            int filaSeleccionada = vista.tbTaller.getSelectedRow();

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbTaller.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbTalleres where idTaller = '" + miId + "'");
                JOptionPane.showMessageDialog(null, "El taller se elimino correctamente ");
                deleteUser.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "el cliente esta en uso , elimine el usuario antes del empleado wichi wzchi wa");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Seleccione un taller para elmiminar");
        }     
    }
    
    public void Editar(VTaller vista){
        try {
            int filaSeleccionada = vista.tbTaller.getSelectedRow();      

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbTaller.getValueAt(filaSeleccionada, 0).toString();
            String nuevoValorIngresadoNombre = vista.txtNombre.getText();
            String nuevoValorIngresadoTelefono = vista.txtTelefono.getText();
            String nuevoValorIngresadoCorreo = vista.txtCorreo.getText();
            String nuevoValorIngresadoDuenio = vista.txtDuenio.getText();
            try {

            PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbTalleres set Tall_Nombre= ?, Tall_Telefono=?, Tall_Correo= ?, Tall_Duenio=? where idTaller = ?");
            updateUser.setString(1, nuevoValorIngresadoNombre);
            updateUser.setString(2, nuevoValorIngresadoTelefono);
            updateUser.setString(3, nuevoValorIngresadoCorreo);
            updateUser.setString(4, nuevoValorIngresadoDuenio);
            updateUser.setString(5, miId);
            JOptionPane.showMessageDialog(null, "El taller se modifico correctamente");                           
            updateUser.executeUpdate();
            } catch (Exception e) {
                System.out.println("error modificar usuario"+e.toString());
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "Seleccione un taller a modificar");                           
        }
        
    }
}
