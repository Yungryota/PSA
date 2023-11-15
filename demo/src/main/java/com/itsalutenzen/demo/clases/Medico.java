/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

/**
 *
 * @author Javiera
 */
public class Medico extends Usuario{
    public String correoElectronico;

    public Medico(String correoElectronico, String rut, String nombre, int num_doc, int edad) {
        super(rut, nombre, num_doc, edad);
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }    
    
}
