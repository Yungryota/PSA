/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

/**
 *
 * @author Javiera
 */
public class Administrativo extends Usuario{
    private String cargo;
    private String permisos;

    public Administrativo(String cargo, String permisos, String rut, String nombre, int num_doc, int edad) {
        super(rut, nombre, num_doc, edad);
        this.cargo = cargo;
        this.permisos = permisos;
    }

    public String getCargo() {
        return cargo;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
    
    
}
