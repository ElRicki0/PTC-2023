
package Modelo;

import Vista.VEmpleados;
import Vista.VNEmpleados;
import java.beans.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TiposEmpleados {
    VNEmpleados vista = new VNEmpleados();
    
    private int idTipoEmpleado;
    private String Tipo_Emp;    
    private String Descripcion_Emp;

    public String getDescripcion_Emp() {
        return Descripcion_Emp;
    }

    public void setDescripcion_Emp(String Descripcion_Emp) {
        this.Descripcion_Emp = Descripcion_Emp;
    }


    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public String getTipo_Emp() {
        return Tipo_Emp;
    }

    public void setTipo_Emp(String Tipo_Emp) {
        this.Tipo_Emp = Tipo_Emp;
    }
    
    public void agregar(TiposEmpleados modeloTiposEmpleados){
        try {
            PreparedStatement ATEmpleado = CConexion.getConexion().prepareStatement("insert into tbTiposEmpleados(Tipo_Emp, Descripcion_Emp) values(?,?)");

            ATEmpleado.setString(1, modeloTiposEmpleados.getTipo_Emp());
            ATEmpleado.setString(2, modeloTiposEmpleados.getDescripcion_Emp());
            ATEmpleado.executeUpdate();             
            JOptionPane.showMessageDialog(null, "El tipo de empleado se agrego correctamente");
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error modelo empleados "+e.getMessage());            
            System.out.println(getTipo_Emp());            
            System.out.println(getDescripcion_Emp());

        }

    }
    
    public void MostrarTEmpleados(VNEmpleados vistaTEmpleados){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID","Nombre", "Descripcion"});
        try {
            java.sql.Statement st = CConexion.getConexion().createStatement();
            String sql ="select idTipoEmpleado, Tipo_Emp, Descripcion_Emp from tbTiposEmpleados" ;   
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idTipoEmpleado"), rs.getString("Tipo_Emp"), rs.getString("Descripcion_Emp")});
            }
            vistaTEmpleados.tbNiveles.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error tabla empleados "+e.getMessage());   
        }
    }
    
    public void eliminar(VNEmpleados vistaTEmpleado){
    
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = vistaTEmpleado.tbNiveles.getSelectedRow();
        
        //Obtenemos el id de la fila seleccionada
        String miId = vistaTEmpleado.tbNiveles.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteUser = CConexion.getConexion().prepareStatement("delete from tbTiposEmpleados where idTipoEmpleado = '" + miId + "'");
            deleteUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "El tipo de empleado se elimino correctamente");
        } catch (Exception e) {            
//            JOptionPane.showMessageDialog(null, "El tipo de empleado esta en uso, modifique el empleado o eliminelo para poder continuar");
 JOptionPane.showMessageDialog(null, "error modelo Templeado"+e.toString());
        }
    }
    
    public void actualizar(VNEmpleados vistaTEmpleados){
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = vistaTEmpleados.tbNiveles.getSelectedRow();

        //Obtenemos el id de la fila seleccionada
        String miId = vistaTEmpleados.tbNiveles.getValueAt(filaSeleccionada, 0).toString();
       String nuevoValorIngresadoNombre = vistaTEmpleados.txtNombre_TE.getText();
       String nuevoValorIngresadoDescripcion = vistaTEmpleados.txtDescripcion_TE.getText(); 

        try {
            PreparedStatement updateUser = CConexion.getConexion().prepareStatement("update tbTiposEmpleados set Tipo_Emp = ?, Descripcion_Emp = ? where idTipoEmpleado = ?");
            updateUser.setString(1, nuevoValorIngresadoNombre);
            updateUser.setString(2, nuevoValorIngresadoDescripcion);
            updateUser.setString(3, miId);
            updateUser.executeUpdate();
            JOptionPane.showMessageDialog(null, "El tipo de empleado se edito correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en modelo TEmpleado "+e.toString());
        }

    }
}
    

