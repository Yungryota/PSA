/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

/**
 *
 * @author Javiera
 */

// Dar vuelta la flecha de diamante en el diagrama de clases !!!!!!!!!!!!!!!!!!!!!!!!! --> IMPORTANTE RECORDAR
public class Consulta { //Actulizar en diagrama de clases
    private String estadoConsulta; 
    //public String pregunta; quitar del diagrma de clases
    public String categoriaPaciente;
    private Usuario paciente; // Representado en el diagrama de clases como agregacion 
    public String ResultadoConsulta; // Representar en diagrama de clases
    public String diagnosticoPaciente;

    public Consulta() {
    }

    public Consulta(String estadoConsulta, String categoriaPaciente, String ResultadoConsulta, String diagnosticoPaciente) {
        this.estadoConsulta = estadoConsulta;
        this.categoriaPaciente = categoriaPaciente;
        this.ResultadoConsulta = ResultadoConsulta;
        this.diagnosticoPaciente = diagnosticoPaciente;
    }

    public String getEstadoConsulta() {
        return estadoConsulta;
    }

    public String getCategoriaPaciente() {
        return categoriaPaciente;
    }

    public String getResultadoConsulta() {
        return ResultadoConsulta;
    }

    public String getDiagnosticoPaciente() {
        return diagnosticoPaciente;
    }

    public void setEstadoConsulta(String estadoConsulta) {
        this.estadoConsulta = estadoConsulta;
    }

    public void setCategoriaPaciente(String categoriaPaciente) {
        this.categoriaPaciente = categoriaPaciente;
    }

    public void setResultadoConsulta(String ResultadoConsulta) {
        this.ResultadoConsulta = ResultadoConsulta;
    }

    public void setDiagnosticoPaciente(String diagnosticoPaciente) {
        this.diagnosticoPaciente = diagnosticoPaciente;
    }

    public String obtenerNombrePaciente() { //Actulizar funciones en el dagrama de clases --> IMPORTANTE RECORDAR
        return paciente.getNombre();
    }

    public String obtenerRutPaciente() { 
        return paciente.getRut();
    }
}
