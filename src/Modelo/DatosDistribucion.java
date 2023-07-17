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
public class DatosDistribucion {
    private int idDatosDistribucion;
    private int DaDis_cantidadproducto;
    private int idProducto;

    public int getIdDatosDistribucion() {
        return idDatosDistribucion;
    }

    public void setIdDatosDistribucion(int idDatosDistribucion) {
        this.idDatosDistribucion = idDatosDistribucion;
    }

    public int getDaDis_cantidadproducto() {
        return DaDis_cantidadproducto;
    }

    public void setDaDis_cantidadproducto(int DaDis_cantidadproducto) {
        this.DaDis_cantidadproducto = DaDis_cantidadproducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
