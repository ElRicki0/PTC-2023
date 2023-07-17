/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import Vista.Producto;
import javax.swing.table.DefaultTableModel;

public class productos {
    private int idProducto;
    private String prod_nombre;
    private int idMarca;
    private String prod_unidades;
    private float prod_preciounitario;
    private int idBodega;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getProd_unidades() {
        return prod_unidades;
    }

    public void setProd_unidades(String prod_unidades) {
        this.prod_unidades = prod_unidades;
    }

    public float getProd_preciounitario() {
        return prod_preciounitario;
    }

    public void setProd_preciounitario(float prod_preciounitario) {
        this.prod_preciounitario = prod_preciounitario;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }
    
    

}
