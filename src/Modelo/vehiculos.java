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
public class vehiculos {
    private int idVehiculo; 
    private String vehi_Matricula;
    private int idModelo;
    private int idMantenimineto;

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getVehi_Matricula() {
        return vehi_Matricula;
    }

    public void setVehi_Matricula(String vehi_Matricula) {
        this.vehi_Matricula = vehi_Matricula;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdMantenimineto() {
        return idMantenimineto;
    }

    public void setIdMantenimineto(int idMantenimineto) {
        this.idMantenimineto = idMantenimineto;
    }
}
