/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

/**
 *
 * @author Javiera
 */
public class Sucursal {
    public String tipoDeRecinto;
    private String horarioSucursal;
    private String tiempoDeEspera;

    public Sucursal(String tipoDeRecinto, String horarioSucursal, String tiempoDeEspera) {
        this.tipoDeRecinto = tipoDeRecinto;
        this.horarioSucursal = horarioSucursal;
        this.tiempoDeEspera = tiempoDeEspera;
    }

    public String getTipoDeRecinto() {
        return tipoDeRecinto;
    }

    public String getHorarioSucursal() {
        return horarioSucursal;
    }

    public String getTiempoDeEspera() {
        return tiempoDeEspera;
    }

    public void setTipoDeRecinto(String tipoDeRecinto) {
        this.tipoDeRecinto = tipoDeRecinto;
    }

    public void setHorarioSucursal(String horarioSucursal) {
        this.horarioSucursal = horarioSucursal;
    }

    public void setTiempoDeEspera(String tiempoDeEspera) {
        this.tiempoDeEspera = tiempoDeEspera;
    }
 
}
