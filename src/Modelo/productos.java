    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import Vista.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;


public class productos {
    
    Producto vistaProducto;
    
    private int idProducto;
    private String prod_nombre;
    private String idMarca;
    private int prod_unidades;
    private String prod_preciounitario;
    private String idBodega;
      

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public int getProd_unidades() {
        return prod_unidades;
    }

    public void setProd_unidades(int prod_unidades) {
        this.prod_unidades = prod_unidades;
    }

    public String getProd_preciounitario() {
        return prod_preciounitario;
    }

    public void setProd_preciounitario(String prod_preciounitario) {
        this.prod_preciounitario = prod_preciounitario;
    }

    public String getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(String idBodega) {
        this.idBodega = idBodega;
    }
    
    public void llenarBuscador(JComboBox combo){
        String sql="select MP_Nombre from tbMarcaProductos";
        Statement st;
    CConexion con = new CConexion();
    Connection conexion=con.getConexion();
        try {
            st= conexion.createStatement();
            ResultSet rs= st.executeQuery(sql) ;
            while(rs.next()){
                combo.addItem(rs.getString("MP_Nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en marca buscador  "+ e.toString());
        }
    }
    
//    
    public void RellenarMarcaCBX(JComboBox combo) {
    Connection conectar = null;
    PreparedStatement pst = null;
    ResultSet result = null;

    String SSQL = "SELECT id_MP, MP_Nombre FROM tbMarcaProductos";
    combo.removeAllItems();
    
    // Usamos un Map para almacenar pares de ID y nombre
    Map<Integer, String> idNombreMar = new HashMap<>();

    try {
        conectar = CConexion.getConexion();
        pst = conectar.prepareStatement(SSQL);
        result = pst.executeQuery();

        while (result.next()) {
            int id = result.getInt("id_MP");
            String nombre = result.getString("MP_Nombre");
            idNombreMar.put(id, nombre); // Almacenamos el ID y el nombre en el Map
            combo.addItem(nombre);
        }

        // Almacenamos el Map en las propiedades del combo box
        combo.putClientProperty("idNombreMar", idNombreMar);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        if (conectar != null) {
            try {
                conectar.close();
                result.close();
                conectar = null;
                result = null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
    public void MostrarProductos(Producto vistaProducto){        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre","Marca","Unidades","Precio C/U", "Bodega"});
        try {
            Statement st= CConexion.getConexion().createStatement();
                String SQL ="select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre"+
                    " from tbProductos inner join tbMarcaProductos  on tbProductos.id_MP = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega";
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idProducto"), rs.getString("Prod_Nombre"), rs.getString("MP_Nombre"), rs.getInt("Prod_Unidades"), rs.getFloat("Prod_PrecioUnitario"), rs.getString("bdg_nombre")});
            }
            vistaProducto.tbProductos.setModel(modelo);            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error 3"+e.getMessage());                
        }
    
    }
    
    
    public void RellenarBodegaCBX( JComboBox combo2){
    String SQL="select idBodega, bdg_nombre from tbBodegas ";
    Statement st;
    CConexion con = new CConexion();
    Connection conexion=con.getConexion();
        try {
            st= conexion.createStatement();
            ResultSet rs= st.executeQuery(SQL) ;
            while(rs.next()){
                combo2.addItem(rs.getString("idBodega"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Bodega     "+ e.toString());
        }
}
    
//    public boolean AgregarProducto(productos productomodelo){                
//        String SQL = "insert into tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) values(?,?,?,?,?)";
//        try {
//            PreparedStatement AProducto = CConexion.getConexion().prepareStatement(SQL);
//            AProducto.setString (1, productomodelo.getProd_nombre());
//            AProducto.setInt(2, Integer.parseInt(productomodelo.getIdMarca()));
//            AProducto.setInt    (3, productomodelo.getProd_unidades());
//            AProducto.setString (4, productomodelo.getProd_preciounitario());
//            AProducto.setInt(5, Integer.parseInt(productomodelo.getIdBodega()));
//            AProducto.execute();
//            JOptionPane.showMessageDialog(null, "El producto  se agrego correctamente");
//            
//            return true;                    
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO"+ e.toString());  
//            return false;
//        }
//        
//    }
    
    public boolean AgregarProducto(productos productomodelo, JComboBox comboMarca) {
    String SQL = "INSERT INTO tbProductos (Prod_Nombre, id_MP, Prod_Unidades, Prod_PrecioUnitario, idBodega) VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement AProducto = CConexion.getConexion().prepareStatement(SQL);
        AProducto.setString(1, productomodelo.getProd_nombre());

        // Obtener el ID del ComboBox seleccionado
        int selectedIndex = comboMarca.getSelectedIndex();
        if (selectedIndex != -1) {
            Map<Integer, String> idNombreMar = (Map<Integer, String>) comboMarca.getClientProperty("idNombreMar");
            int selectedID = (int) idNombreMar.keySet().toArray()[selectedIndex];
            AProducto.setInt(2, selectedID); // Usar el ID seleccionado
        } else {
            // Si no hay elemento seleccionado, muestra un mensaje o toma una acción adecuada
            JOptionPane.showMessageDialog(null, "Seleccione una marca válida del ComboBox.");
            return false;
        }

        AProducto.setInt(3, productomodelo.getProd_unidades());
        AProducto.setString(4, productomodelo.getProd_preciounitario());
        AProducto.setInt(5, Integer.parseInt(productomodelo.getIdBodega()));
        AProducto.execute();
        JOptionPane.showMessageDialog(null, "El producto se agregó correctamente");

        return true;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR EN EL METODO DEL MODELO: " + e.toString());
        return false;
    }
}
              
    public void EliminarProducto (Producto vistaProducto){
        int filaSeleccionada = vistaProducto.tbProductos.getSelectedRow();
        
        //Obtenemos el id de la fila seleccionada
        String miId = vistaProducto.tbProductos.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbProductos where idProducto = '" + miId + "'");
            deleteUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la marca");                           
        } catch (Exception e) {
         System.out.println(e.toString());
          JOptionPane.showMessageDialog(null, "Error al intentar eliminar el producto");                           
        }
    }
    
    public boolean Actualizarproducto(Producto vistaProducto){
        
            int filaSeleccionada = vistaProducto.tbProductos.getSelectedRow();      

                            //Obtenemos el id de la fila seleccionada
                              String miId = vistaProducto.tbProductos.getValueAt(filaSeleccionada, 0).toString();
                                String nuevoValorIngresadoNombre = vistaProducto.txtNombre_pdt.getText();
                                String nuevoValorIngresadoMarca = vistaProducto.jcbMarca_pdt.getSelectedItem().toString();
                                String nuevoValorIngresadounidades = vistaProducto.txtUnidades_pdt.getText();
                                String nuevoValorIngresadoprecio = vistaProducto.txtPrecioUnitario_pdt.getText();   
                                String nuevoValorIngresadoBodega = vistaProducto.jcbBuscador.getSelectedItem().toString();   

                                try {

                                 PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbProductos set Prod_Nombre = ?, id_MP=?, Prod_Unidades = ?, Prod_PrecioUnitario = ?, idBodega = ? where idProducto = ?");
                                    updateUser.setString(1, nuevoValorIngresadoNombre);
                                    updateUser.setInt(2, Integer.parseInt( nuevoValorIngresadoMarca));
                                    updateUser.setInt(3, Integer.parseInt( nuevoValorIngresadounidades));
                                    updateUser.setString(4, nuevoValorIngresadoprecio);
                                    updateUser.setInt(5, Integer.parseInt( nuevoValorIngresadoBodega));
                                    updateUser.setString(6, miId);
                                    JOptionPane.showMessageDialog(null, "El producto se actualizo correctamente");                           
                                    updateUser.executeUpdate();
                                    return true;
                                    } catch (Exception e) {
                                    System.out.println(e.toString());
                                    JOptionPane.showMessageDialog(null, "Error en actualizar producto");  
                                    return false;
                                         }
        
    }

}
