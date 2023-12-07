/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;
import com.itsalutenzen.demo.service.Controlador;

/**
 *
 * @author Javiera
 */
public class Paciente extends Usuario{
    public String categorizacionPaciente;
    public String recetaPaciente;
    Controlador controlador;

    @Override
    public String toString() {
        return "Paciente{" +
                "categorizacionPaciente='" + categorizacionPaciente + '\'' +
                ", recetaPaciente='" + recetaPaciente + '\'' +
                ", rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", num_doc=" + getNum_doc() +
                ", edad=" + getEdad() +
                ", contacto='" + getContacto() + '\'' +
                '}';
    }


    public Paciente(String categorizacionPaciente, String recetaPaciente, String rut, String nombre, int num_doc, int edad, String contacto) {
        super(rut, nombre, num_doc, edad, contacto);
        this.categorizacionPaciente = controlador.getResultadoCategoria();
        this.recetaPaciente = recetaPaciente;
    }
    

    public Paciente(String rut, String nombre, int num_doc, int edad, String contacto) {
        super(rut, nombre, num_doc, edad, contacto);

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
    
   //Paciente paciente = new Paciente(this.categorizacionPaciente,"amoxcicilina","21323¿4","javie",1234,43,"ja.espinam@duocuc.cl");
    
    
}
