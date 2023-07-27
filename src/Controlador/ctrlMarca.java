package Controlador;

import Modelo.MarcaProductos;
import Vista.Producto;
import Vista.Producto_Marca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlMarca implements ActionListener{
    
    private MarcaProductos modeloMarca;
    private Producto_Marca        vistaMarca;
    
    public ctrlMarca(MarcaProductos modeloMarca, Producto_Marca vistaMarca){
        this.modeloMarca= modeloMarca;
        this.vistaMarca=vistaMarca;
        this.vistaMarca.btnAgregarMC.addActionListener(this);
        this.vistaMarca.btnEliminarMC.addActionListener(this);
        this.vistaMarca.btnModificarMC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaMarca.btnAgregarMC) 
        {   try {
                modeloMarca.setMP_correo(vistaMarca.txtCorreosMC.getText());
                modeloMarca.setMP_NumeroContacto(vistaMarca.txtNumeroMC.getText());
                modeloMarca.setMP_nombre(vistaMarca.txtNombreMC.getText());
                modeloMarca.AgregarMarca(modeloMarca, vistaMarca);
                modeloMarca.MostrarMarcas(vistaMarca);
            } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "ingrese datos a agregar");                        
            }
            
        }
        else if(e.getSource()==vistaMarca.btnEliminarMC)
        {
            try {
                modeloMarca.eliminar(vistaMarca);
                modeloMarca.MostrarMarcas(vistaMarca);
                System.out.println("click en ctrl marca");
            } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "seleccione una marca a eliminar");                        
            }
            
        }
        else if(e.getSource()==vistaMarca.btnModificarMC){
            try {
                modeloMarca.actualizar(vistaMarca);
            modeloMarca.MostrarMarcas(vistaMarca);
            } catch (Exception ie) {
            JOptionPane.showMessageDialog(null, "seleccione una marca a editar");                        
            }
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
