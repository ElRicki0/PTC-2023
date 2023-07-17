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
public class DatosTiendas {
    private int idDatosTienda;
    private String DT_NumeroTelefono;
    private String DT_PersonaDestinatario;
    private int idCliente;
    private int idTienda;

    public int getIdDatosTienda() {
        return idDatosTienda;
    }

    public void setIdDatosTienda(int idDatosTienda) {
        this.idDatosTienda = idDatosTienda;
    }

    public String getDT_NumeroTelefono() {
        return DT_NumeroTelefono;
    }

    public void setDT_NumeroTelefono(String DT_NumeroTelefono) {
        this.DT_NumeroTelefono = DT_NumeroTelefono;
    }

    public String getDT_PersonaDestinatario() {
        return DT_PersonaDestinatario;
    }

    public void setDT_PersonaDestinatario(String DT_PersonaDestinatario) {
        this.DT_PersonaDestinatario = DT_PersonaDestinatario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
}
