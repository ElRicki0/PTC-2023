package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import javax.swing.JOptionPane;

public class ctrlActualizarContra implements ActionListener{

    private usuarios modeloContra;
    private NuevoContra vistaContra;
    private ctrlEncriptacion encript;
    
    public ctrlActualizarContra(usuarios modeloContra, NuevoContra vistaContra){
        this.modeloContra = modeloContra;
        this.vistaContra = vistaContra;
        this.encript = new ctrlEncriptacion(); // Inicializar la variable encript
        this.vistaContra.btnEnviar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaContra.btnEnviar) {
    String texto1 = vistaContra.txtUsuario.getText();
    String texto2 = vistaContra.txtContrasenia.getText();
    String texto3 = vistaContra.txtRepetir.getText();
    
    if (!texto1.isEmpty() && !texto2.isEmpty() && !texto3.isEmpty()) {
        if (texto2.length() > 5) {
            if (texto2.equals(texto3)) {
                modeloContra.setUsr_nombre(vistaContra.txtUsuario.getText());
                modeloContra.setUsr_contra(encript.convertirSHA256(vistaContra.txtContrasenia.getText()));
                modeloContra.ActualizarContra(modeloContra);
                vistaContra.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La longitud de la contraseña debe ser mayor a 5 caracteres");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Campo vacío detectado, por favor llenar los campos");
    }
}

    }
}

