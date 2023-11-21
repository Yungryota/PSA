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
    // variables asociadas al envio de correos 

    public Medico(String correoElectronico, String rut, String nombre, int num_doc, int edad, String contacto) {
        super(rut, nombre, num_doc, edad, contacto);
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }    
    
}
