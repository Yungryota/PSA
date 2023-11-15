/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

/**
 *
 * @author Javiera
 */
public class Paciente extends Usuario{
    public String categorizacionPaciente;
    public String recetaPaciente;

    public Paciente(String rut, String nombre, int num_doc, int edad) {
        super(rut, nombre, num_doc, edad);
    }
    

    public Paciente(String categorizacionPaciente, String recetaPaciente, String rut, String nombre, int num_doc, int edad) {
        super(rut, nombre, num_doc, edad);
        this.categorizacionPaciente = categorizacionPaciente;
        this.recetaPaciente = recetaPaciente;
    }

    public String getCategorizacionPaciente() {
        return categorizacionPaciente;
    }

    public String getRecetaPaciente() {
        return recetaPaciente;
    }

    public void setCategorizacionPaciente(String categorizacionPaciente) {
        this.categorizacionPaciente = categorizacionPaciente;
    }

    public void setRecetaPaciente(String recetaPaciente) {
        this.recetaPaciente = recetaPaciente;
    }
    
   
    
    
}
