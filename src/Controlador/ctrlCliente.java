
package Controlador;

import Modelo.clientes;
import Vista.VCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author rnmel
 */
public class ctrlCliente implements ActionListener{

    private clientes modeloClientes;
    private VCliente vistaCliente;
    
    public ctrlCliente(clientes modeloClientes, VCliente vistaCliente){
        this.modeloClientes=modeloClientes;
        this.vistaCliente=vistaCliente;
        this.vistaCliente.btnAgregar_CL.addActionListener(this);
        this.vistaCliente.btnEliminar_CL.addActionListener(this);
        this.vistaCliente.btnModificar_CL.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaCliente.btnAgregar_CL){
            System.out.println("se da clic en ctrl cliente");
            modeloClientes.setClie_Nombre(vistaCliente.txtNombre_CL.getText());
            modeloClientes.setClie_Edad(Integer.parseInt(vistaCliente.txtEdad_CL.getText()));
            modeloClientes.setClie_telefono(vistaCliente.txtTelefono_CL.getText());
            modeloClientes.setClie_correo(vistaCliente.txtCorreo_CL.getText());
            modeloClientes.setIdGenero( vistaCliente.jcbGenero_CL.getSelectedItem().toString());
            modeloClientes.AgregarCliente(modeloClientes, vistaCliente.jcbGenero_CL);
            modeloClientes.MostrarTabla(vistaCliente);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
