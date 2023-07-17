/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Javier
 */
public class Mantenimiento {
    private int idMantenimineto;
    private String taller;
    private String Mecanico;
    private String TFTaller;
    private int idTaller;

    public int getIdMantenimineto() {
        return idMantenimineto;
    }

    public void setIdMantenimineto(int idMantenimineto) {
        this.idMantenimineto = idMantenimineto;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getMecanico() {
        return Mecanico;
    }

    public void setMecanico(String Mecanico) {
        this.Mecanico = Mecanico;
    }

    public String getTFTaller() {
        return TFTaller;
    }

    public void setTFTaller(String TFTaller) {
        this.TFTaller = TFTaller;
    }

    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }
}
