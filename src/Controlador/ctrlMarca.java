package Controlador;

import Modelo.MarcaProductos;
import Vista.Controlador.CProducto_Marca;
import Vista.VProducto;
import Vista.VProducto_Marca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlMarca implements ActionListener{
    
    private MarcaProductos         modeloMarca;
    private VProducto_Marca        vistaMarca;
    private CProducto_Marca        CvistaMarca;
    
    public ctrlMarca(MarcaProductos modeloMarca, VProducto_Marca vistaMarca, CProducto_Marca      CvistaMarca){
        this.modeloMarca= modeloMarca;
        this.vistaMarca=vistaMarca;
        this.CvistaMarca=CvistaMarca;
        
        ////////////////////////////Administrador///////////////////////////////////////////
        this.vistaMarca.btnAgregarMC.addActionListener(this);
        this.vistaMarca.btnEliminarMC.addActionListener(this);
        this.vistaMarca.btnModificarMC.addActionListener(this);
        
        ///////////////////////////Controlador////////////////////////////////////////////
        this.CvistaMarca.btnAgregarMC.addActionListener(this);
        this.CvistaMarca.btnEliminarMC.addActionListener(this);
        this.CvistaMarca.btnModificarMC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ///////////////////////////Administrador////////////////////////////////////////////
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
        //////////////////////////Controlador/////////////////////////////////////////////
        if (e.getSource()==CvistaMarca.btnAgregarMC) 
        {   try {
                modeloMarca.setMP_correo(CvistaMarca.txtCorreosMC.getText());
                modeloMarca.setMP_NumeroContacto(CvistaMarca.txtNumeroMC.getText());
                modeloMarca.setMP_nombre(CvistaMarca.txtNombreMC.getText());
                modeloMarca.CAgregarMarca(modeloMarca, CvistaMarca);
                modeloMarca.CMostrarMarcas(CvistaMarca);
            } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "ingrese datos a agregar");                        
            }
            
        }
        else if(e.getSource()==CvistaMarca.btnEliminarMC)
        {
            try {
                modeloMarca.CEliminar(CvistaMarca);
                modeloMarca.CMostrarMarcas(CvistaMarca);
                System.out.println("click en ctrl marca");
            } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "seleccione una marca a eliminar");                        
            }
            
        }
        else if(e.getSource()==CvistaMarca.btnModificarMC){
            try {
                modeloMarca.CActualizar(CvistaMarca);
            modeloMarca.CMostrarMarcas(CvistaMarca);
            } catch (Exception ie) {
            JOptionPane.showMessageDialog(null, "seleccione una marca a editar");                        
            }
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
