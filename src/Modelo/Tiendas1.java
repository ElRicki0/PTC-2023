package Modelo;

import Vista.Bodega;
import Vista.VTiendas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tiendas1 {
    private int idTienda;
    private String Tien_Nombre;
    private String Tien_Direccion;
    private String Tien_ReferenciasLDireccion;
    private String Tien_Correo;

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getTien_Nombre() {
        return Tien_Nombre;
    }

    public void setTien_Nombre(String Tien_Nombre) {
        this.Tien_Nombre = Tien_Nombre;
    }

    public String getTien_Direccion() {
        return Tien_Direccion;
    }

    public void setTien_Direccion(String Tien_Direccion) {
        this.Tien_Direccion = Tien_Direccion;
    }

    public String getTien_ReferenciasLDireccion() {
        return Tien_ReferenciasLDireccion;
    }

    public void setTien_ReferenciasLDireccion(String Tien_ReferenciasLDireccion) {
        this.Tien_ReferenciasLDireccion = Tien_ReferenciasLDireccion;
    }

    public String getTien_Correo() {
        return Tien_Correo;
    }

    public void setTien_Correo(String Tien_Correo) {
        this.Tien_Correo = Tien_Correo;
    }
    
    public void MostrarTabla(VTiendas vista){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "nombre", "Direccion", "Referencia","Correo"});
        try {
             Statement st = CConexion.getConexion().createStatement();
             String SQL = "select*from tbTiendas";
             ResultSet rs= st.executeQuery(SQL);
             while(rs.next()){                 
                modelo.addRow(new Object[]{rs.getInt("idTienda"), rs.getString("Tien_Nombre"), rs.getString("Tien_Direccion"), rs.getString("Tien_ReferenciasLDireccion"), rs.getString("Tien_Correo")});
             }
             
             vista.tbTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla tienda "+e.getMessage());                
        }
    }
    
    public void agregar(Tiendas1 modelo){
        String SQL="insert into tbTiendas(Tien_Nombre, Tien_Direccion, Tien_ReferenciasLDireccion, Tien_Correo) VALUES(?,?,?,?)";
        try {
            PreparedStatement ATienda= CConexion.getConexion().prepareStatement(SQL);
            ATienda.setString(1, modelo.getTien_Nombre());
            ATienda.setString(2, modelo.getTien_Direccion());
            ATienda.setString(3, modelo.getTien_ReferenciasLDireccion());
            ATienda.setString(4, modelo.getTien_Correo());
            ATienda.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tienda aghregada  exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar tienda "+e.toString());
        }
    }
    
    public void eliminar(VTiendas vista){
        try {
            int filaSeleccionada = vista.tbTienda.getSelectedRow();
        
            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbTienda.getValueAt(filaSeleccionada, 0).toString();
            //borramos 
            try {
                PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbTiendas where idTienda = '" + miId + "'");
                deleteUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente la tienda");                           
            } catch (Exception e) {
             System.out.println(e.toString());
              JOptionPane.showMessageDialog(null, "La tienda esta en uso, modifique o elimine el ''datos generales''");                           
            }
        } catch (Exception ae) {
              JOptionPane.showMessageDialog(null, "Seleccione una tienda para eliminar");                           
        }
        
    }
    
    public void actualizar(VTiendas vista)
    {
        try {
            int filaSeleccionada = vista.tbTienda.getSelectedRow();      

            //Obtenemos el id de la fila seleccionada
            String miId = vista.tbTienda.getValueAt(filaSeleccionada, 0).toString();
            String nuevoValorIngresadoNombre = vista.txtNombre_CL.getText();
            String nuevoValorIngresadDireccion = vista.txtDireccion.getText();
            String nuevoValorIngresadoReferencia = vista.txtReferencia.getText();
            String nuevoValorIngresadoCorreo = vista.txtCorreo_CL.getText();
            try {

                PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbTiendas set Tien_Nombre = ?, Tien_Direccion=?, Tien_ReferenciasLDireccion = ?, Tien_Correo=? where idTienda = ?");
                updateUser.setString(1, nuevoValorIngresadoNombre);
                updateUser.setString(2, nuevoValorIngresadDireccion);
                updateUser.setString(3, nuevoValorIngresadoReferencia);
                updateUser.setString(4, nuevoValorIngresadoCorreo);
                updateUser.setString(5, miId);
                JOptionPane.showMessageDialog(null, "La tienda se modifico correctamente");                           
                updateUser.executeUpdate();
                } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Error en modificar tienda");
                }
        } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "Seleccione un dato a modificar");                           
        }
   

    }
}
