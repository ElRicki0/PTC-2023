package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import javax.swing.JOptionPane;

public class ctrlActualizarContra implements ActionListener {

    private usuarios modeloContra;
    private LoginPTC vistaLogin;
    private NuevoContra vistaContra;
    private ActContra vistaNuevaC;
    private ctrlEncriptacion encript;

    public ctrlActualizarContra(usuarios modeloContra, NuevoContra vistaContra, ActContra vistaNuevaC, LoginPTC vistaLogin) {
        this.modeloContra = modeloContra;
        this.vistaContra = vistaContra;
        this.vistaNuevaC= vistaNuevaC;
        this.vistaLogin=vistaLogin;
        this.vistaNuevaC.btnActualizar.addActionListener(this);
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
                        System.out.println("hola"+modeloContra.getUsr_nombre());
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
    /////////////////////Actualizar cohntraseña nuevo usuario//////////////////////////////////////////////////
        if (e.getSource()==vistaNuevaC.btnActualizar) {
            String texto1= vistaNuevaC.txtContra.getText();
            String texto2= vistaNuevaC.txtContra2.getText();
            if (!texto1.isEmpty() && !texto2.isEmpty()) {
                if (texto2.length() > 5) {
                    if (texto2.equals(texto1)) {
                        String nombre = usuarios.getUsr_nombre();
                        System.out.println(nombre);
                        modeloContra.setUsr_contra(encript.convertirSHA256(vistaNuevaC.txtContra.getText()));
                        modeloContra.ActNuevaContra(modeloContra);
                        vistaNuevaC.dispose();
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
