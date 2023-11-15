/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

import java.util.ArrayList;

/**
 *
 * @author Javiera
 */
public class FichaMedica {
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Consulta> listaConsultas;

    public FichaMedica() {
        this.listaPacientes = new ArrayList<>();
        this.listaConsultas = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    public void agregarConsulta(Consulta consulta) {
        listaConsultas.add(consulta);
    }
    
    public void generarFichaMedica(Paciente paciente, Consulta consulta) {
        String rut = paciente.getRut(); // Obtener el rut del paciente
        String categorizacionPaciente = paciente.getCategorizacionPaciente();
        String recetaPaciente = paciente.getRecetaPaciente();
        String estadoConsulta = consulta.getEstadoConsulta();
        String resultadoConsulta = consulta.getResultadoConsulta();
        String diagnosticoPaciente = consulta.getDiagnosticoPaciente();

        System.out.println("FICHA MÉDICA");
        System.out.println("RUT del paciente: " + rut);
        System.out.println("Categorización del paciente: " + categorizacionPaciente);
        System.out.println("Receta del paciente: " + recetaPaciente);
        System.out.println("Estado de consulta: " + estadoConsulta);
        System.out.println("Resultado de consulta: " + resultadoConsulta);
        System.out.println("Diagnóstico del paciente: " + diagnosticoPaciente);
    }
    
    
}