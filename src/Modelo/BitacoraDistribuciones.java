/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Javier
 */
public class BitacoraDistribuciones {
    private int idBitacoraDistribucion;
    private Date FechaEntrega;
    private int idDatosTienda;
    private int idUsuario;
    private int idVehiculo;
    private int idPqueteria;

    public int getIdBitacoraDistribucion() {
        return idBitacoraDistribucion;
    }

    public void setIdBitacoraDistribucion(int idBitacoraDistribucion) {
        this.idBitacoraDistribucion = idBitacoraDistribucion;
    }

    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(Date FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public int getIdDatosTienda() {
        return idDatosTienda;
    }

    public void setIdDatosTienda(int idDatosTienda) {
        this.idDatosTienda = idDatosTienda;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdPqueteria() {
        return idPqueteria;
    }

    public void setIdPqueteria(int idPqueteria) {
        this.idPqueteria = idPqueteria;
    }
}
