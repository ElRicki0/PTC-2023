/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import Vista.Producto;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Javier
 */
public class MarcaProductos {
    private int id_MP;
    private String MP_nombre;
    private String MP_NumeroContacto;
    private String MP_correo;

    public int getId_MP() {
        return id_MP;
    }

    public void setId_MP(int id_MP) {
        this.id_MP = id_MP;
    }

    public String getMP_nombre() {
        return MP_nombre;
    }

    public void setMP_nombre(String MP_nombre) {
        this.MP_nombre = MP_nombre;
    }

    public String getMP_NumeroContacto() {
        return MP_NumeroContacto;
    }

    public void setMP_NumeroContacto(String MP_NumeroContacto) {
        this.MP_NumeroContacto = MP_NumeroContacto;
    }

    public String getMP_correo() {
        return MP_correo;
    }

    public void setMP_correo(String MP_correo) {
        this.MP_correo = MP_correo;
    }
    
    public void MostrarMarcas(Producto vistaProducto){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID Marca", "Nombre", "Numero de Telefono", "Correo Electronico"});
        try {
            Statement st = CConexion.getConexion().createStatement();
            String SQL ="select*from tbMarcaProductos;";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {                
                modelo.addRow(new Object[]{rs.getInt("id_MP"),rs.getString("MP_Nombre"), rs.getString("MP_NumeroContacto"), rs.getString("MP_Correo")});
            }
            vistaProducto.tbMarca.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error 4"+e.getMessage());                
        }
    }
    
        
    
    public boolean AgregarMarca(MarcaProductos marcamodelo, Producto vistaProducto){
        String textoTelefono = vistaProducto.txtNumeroMC.getText();
        String textoNombre = vistaProducto.txtNombreMC.getText();
        String textoCorreo = vistaProducto.txtCorreosMC.getText();
        if (textoTelefono.matches("[0-9]+")) /*validar quye solamente existan nuemros en el campo txt*/
        {             
                if(textoTelefono.length()==8){
                    if (textoNombre.isEmpty()) {                         
                        JOptionPane.showMessageDialog(null, "Ingrese un valor en el nombre de la marca");                           
                    }
                    else 
                    {
                        if (textoCorreo.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese un valor en el correo");
                        } 
                        else{
                            String SQL="insert into tbMarcaProductos (MP_Nombre, MP_NumeroContacto, MP_Correo) values(?,?,?)";
                            try {
                        PreparedStatement AMarca = CConexion.getConexion().prepareStatement(SQL);
                        AMarca.setString(1, marcamodelo.getMP_nombre());
                        AMarca.setString(2, marcamodelo.getMP_NumeroContacto());
                        AMarca.setString(3, marcamodelo.getMP_correo());
                        AMarca.executeUpdate();
                        JOptionPane.showMessageDialog(null, "La Marca se agrego correctamente");
                        Producto ProductoVista = new Producto();
                        return true;
                        } catch (Exception e) {
                         JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO marca"+ e.toString());                        
                         return false;
                         }                            
                            
                        }
                        
                    }                  
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El telefono debe ser valido");
                    System.out.println("se da clic");                     
                }
        }
        else{
            JOptionPane.showMessageDialog(null, "El telefono debe contener solo numeros");
                System.out.println("se valida el nuemro");
        }      
        return false;
    }
    
    
    
    public void eliminar(Producto vistaProducto){
    
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = vistaProducto.tbMarca.getSelectedRow();
        
        //Obtenemos el id de la fila seleccionada
        String miId = vistaProducto.tbMarca.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbMarcaProductos where id_MP = '" + miId + "'");
            deleteUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la marca");                           
        } catch (Exception e) {
         System.out.println(e.toString());
          JOptionPane.showMessageDialog(null, "La marca esta en uso por un producto o mas, para editar eliminar la marca, modifique el producto en uso. ");                           
        }
    }
    
    public boolean actualizar(Producto vistamarca){
        
        String textoTelefono = vistamarca.txtNumeroMC.getText();
        String textoNombre = vistamarca.txtNombreMC.getText();
        String textoCorreo = vistamarca.txtCorreosMC.getText();
        if (textoTelefono.matches("[0-9]+")) /*validar quye solamente existan nuemros en el campo txt*/
        {             
                if(textoTelefono.length()==8){
                    if (textoNombre.isEmpty()) {                         
                        JOptionPane.showMessageDialog(null, "Ingrese un valor en el nombre de la marca");                           
                                    return false;
                    }
                    else 
                    {
                        if (textoCorreo.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese un valor en el correo");
                            return false;
                        } 
                        else{
                            int filaSeleccionada = vistamarca.tbMarca.getSelectedRow();      

                            //Obtenemos el id de la fila seleccionada
                              String miId = vistamarca.tbMarca.getValueAt(filaSeleccionada, 0).toString();
                                String nuevoValorIngresadoNombre = vistamarca.txtNombreMC.getText();
                                String nuevoValorIngresadoNumero = vistamarca.txtNumeroMC.getText();
                                String nuevoValorIngresadoCorreo = vistamarca.txtCorreosMC.getText();   

                                try {

                                 PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbMarcaProductos set MP_Nombre = ?, MP_NumeroContacto = ?, MP_Correo = ? where id_MP = ?");
                                    updateUser.setString(1, nuevoValorIngresadoNombre);
                                    updateUser.setInt(2, Integer.parseInt( nuevoValorIngresadoNumero));
                                    updateUser.setString(3, nuevoValorIngresadoCorreo);
                                    updateUser.setString(4, miId);
                                    JOptionPane.showMessageDialog(null, "La marca se actualizo correctamente");                           
                                    updateUser.executeUpdate();
                                    return true;
                                    } catch (Exception e) {
                                    System.out.println(e.toString());
                                    JOptionPane.showMessageDialog(null, "Error en actualizar marca");  
                                    return false;
                                         }
                                 }
                            
                        }
                        
                    }                  
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El telefono debe ser valido");
                    System.out.println("se da clic");
                    return false;
                }
        return false;
        }
           
        
        
          //obtenemos que fila seleccionó el usuario
        
}
