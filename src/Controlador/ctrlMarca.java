package Controlador;

import Modelo.MarcaProductos;
import Vista.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlMarca implements ActionListener{
    
    private MarcaProductos modeloMarca;
    private Producto        vistaMarca;
    
    public ctrlMarca(MarcaProductos modeloMarca, Producto vistaMarca){
        this.modeloMarca= modeloMarca;
        this.vistaMarca=vistaMarca;
        this.vistaMarca.btnAgregarMC.addActionListener(this);
        this.vistaMarca.btnEliminarMC.addActionListener(this);
        this.vistaMarca.btnModificarMC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaMarca.btnAgregarMC) 
        {
            modeloMarca.setMP_correo(vistaMarca.txtCorreosMC.getText());
            modeloMarca.setMP_NumeroContacto(vistaMarca.txtNumeroMC.getText());
            modeloMarca.setMP_nombre(vistaMarca.txtNombreMC.getText());
            modeloMarca.AgregarMarca(modeloMarca, vistaMarca);
            modeloMarca.MostrarMarcas(vistaMarca);
        }
        else if(e.getSource()==vistaMarca.btnEliminarMC)
        {
            modeloMarca.eliminar(vistaMarca);
            modeloMarca.MostrarMarcas(vistaMarca);
            System.out.println("click en ctrl marca");
        }
        else if(e.getSource()==vistaMarca.btnModificarMC){
            modeloMarca.actualizar(vistaMarca);
            modeloMarca.MostrarMarcas(vistaMarca);
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
