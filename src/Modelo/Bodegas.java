
package Modelo;

import Vista.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class Bodegas {
    private int idBodega;
    private String bdg_nombre;
    private String bdg_ubicacion;
    private String bdg_correo;

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getBdg_nombre() {
        return bdg_nombre;
    }

    public void setBdg_nombre(String bdg_nombre) {
        this.bdg_nombre = bdg_nombre;
    }

    public String getBdg_ubicacion() {
        return bdg_ubicacion;
    }

    public void setBdg_ubicacion(String bdg_ubicacion) {
        this.bdg_ubicacion = bdg_ubicacion;
    }

    public String getBdg_correo() {
        return bdg_correo;
    }

    public void setBdg_correo(String bdg_correo) {
        this.bdg_correo = bdg_correo;
    }
    
    public void MostrarBodega(Bodega vista){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "nombre", "Direccion", "Correo"});
        try {
             Statement st = CConexion.getConexion().createStatement();
             String SQL = "select*from tbBodegas";
             ResultSet rs= st.executeQuery(SQL);
             while(rs.next()){                 
                modelo.addRow(new Object[]{rs.getInt("idBodega"), rs.getString("bdg_nombre"), rs.getString("bdg_ubicacion"), rs.getString("bdg_correo")});
             }
             
             vista.tbBodegas.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla bodegas "+e.getMessage());                
        }
    }
    
    public void AgregarBodega(Bodegas modeloBodegas){
        String SQL="insert into tbBodegas(bdg_nombre, bdg_ubicacion, bdg_correo) VALUES(?,?,?)";
        try {
            PreparedStatement ABodega= CConexion.getConexion().prepareStatement(SQL);
            ABodega.setString(1, modeloBodegas.getBdg_nombre());
            ABodega.setString(2, modeloBodegas.getBdg_ubicacion());
            ABodega.setString(3, modeloBodegas.getBdg_correo());
            ABodega.execute();
            JOptionPane.showMessageDialog(null, "Bodega agregadaexi itosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar bodega "+e.toString());
        }
    }
        
    public void EliminarBodega (Bodega vistaBodega){
        int filaSeleccionada = vistaBodega.tbBodegas.getSelectedRow();
        
        //Obtenemos el id de la fila seleccionada
        String miId = vistaBodega.tbBodegas.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbBodegas where idBodega = '" + miId + "'");
            deleteUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la Bodega");                           
        } catch (Exception e) {
         System.out.println(e.toString());
          JOptionPane.showMessageDialog(null, "La bodega esta en uso por un producto, edite el producto para continuar");                           
        }
    }
    
    public boolean ActualizarBodega(Bodega vistaBodega){
        
        int filaSeleccionada = vistaBodega.tbBodegas.getSelectedRow();      

        //Obtenemos el id de la fila seleccionada
        String miId = vistaBodega.tbBodegas.getValueAt(filaSeleccionada, 0).toString();
        String nuevoValorIngresadoNombre = vistaBodega.txtNombre_bdg.getText();
        String nuevoValorIngresadoDirecccion = vistaBodega.txtDireccion_bdg.getText();
        String nuevoValorIngresadoCorreo = vistaBodega.txtCorreo_bdg.getText();
        try {

            PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbBodegas set bdg_nombre = ?, bdg_ubicacion=?, bdg_correo = ? where idBodega = ?");
            updateUser.setString(1, nuevoValorIngresadoNombre);
            updateUser.setString(2, nuevoValorIngresadoDirecccion);
            updateUser.setString(3, nuevoValorIngresadoCorreo);
            updateUser.setString(4, miId);
            JOptionPane.showMessageDialog(null, "La bodega se actualizo correctamente");                           
            updateUser.executeUpdate();
            return true;
            } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error en actualizar producto");  
            return false;
                 }

    }
    
    
}
