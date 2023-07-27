
package Modelo;

import Vista.VEmpleados;
import Vista.VNEmpleados;
import Vista.VNUsuarios;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NivelesUsuarios {
    private String usr_Nivel;
    private String usr_Descripcion;

    public String getUsr_Nivel() {
        return usr_Nivel;
    }

    public void setUsr_Nivel(String usr_Nivel) {
        this.usr_Nivel = usr_Nivel;
    }

    public String getUsr_Descripcion() {
        return usr_Descripcion;
    }

    public void setUsr_Descripcion(String usr_Descripcion) {
        this.usr_Descripcion = usr_Descripcion;
    }
    
    public void MostrarNusuarios(VNUsuarios vistaNUsuarios){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID","Nombre", "Descripcion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
        String sql ="select idNivelUser, usr_Nivel, usr_Descripcion from tbNivelesUsuarios";
        ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idNivelUser"), rs.getString("usr_Nivel"), rs.getString("usr_Descripcion")});
            }
            vistaNUsuarios.tbNUsuarios.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla NUsuarios "+e.getMessage());                
        }
    }
    
     public void agregar(NivelesUsuarios modeloNUsuarios){
        String SQL = "insert into tbNivelesUsuarios(usr_Nivel, usr_Descripcion)  values(?,?)";
        try {
            PreparedStatement AProducto = CConexion.getConexion().prepareStatement(SQL);
            AProducto.setString (1, modeloNUsuarios.getUsr_Nivel());
            AProducto.setString (2, modeloNUsuarios.getUsr_Descripcion());
            AProducto.execute();
            JOptionPane.showMessageDialog(null, "El Nivel Usuario se agrego correctamente");
                               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO"+ e.toString());  
        }

    }
     
     public void eliminar(VNUsuarios vistaNUsuarios){
    
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = vistaNUsuarios.tbNUsuarios.getSelectedRow();
        
        //Obtenemos el id de la fila seleccionada
        String miId = vistaNUsuarios.tbNUsuarios.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbNivelesUsuarios where idNivelUser = '" + miId + "'");
            deleteUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "El nivel se elimino correctamente");  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El tipo de nivel esta en uso por uno o mas usuarios, edite los usuario o eliminelos para continuar");  
        }
    }
     
     public void actualizar(VNUsuarios vistaNUsuario){
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = vistaNUsuario.tbNUsuarios.getSelectedRow();       

        //Obtenemos el id de la fila seleccionada
        String miId = vistaNUsuario.tbNUsuarios.getValueAt(filaSeleccionada, 0).toString();
       String nuevoValorIngresadoNombre = vistaNUsuario.txtNombre_NU.getText();
       String nuevoValorIngresadoDescripcion = vistaNUsuario.txtDescripcion_NU.getText();

        try {

            PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbNivelesUsuarios set usr_Nivel = ?, usr_Descripcion = ? where idNivelUser = ?");

            updateUser.setString(1, nuevoValorIngresadoNombre);
            updateUser.setString(2, nuevoValorIngresadoDescripcion);
            updateUser.setString(3, miId);
            updateUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "El nivel se actualizo correctamente");  

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en editar "+e.toString());  
        }
    }
}
