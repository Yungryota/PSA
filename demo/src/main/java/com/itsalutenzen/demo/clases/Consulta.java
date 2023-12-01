/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

/**
 *
 * @author Javiera
 */
// delega las tareas a la clase temperatura 
// Dar vuelta la flecha de diamante en el diagrama de clases !!!!!!!!!!!!!!!!!!!!!!!!! --> IMPORTANTE RECORDAR
public class Consulta{ //Actulizar en diagrama de clases
    public String estadoConsulta; 
    public String ResultadoConsulta; // Representar en diagrama de clases
    public String diagnosticoPaciente;
    private Resenia resenia;
    //colaboracion con clase temperatura 

    public Consulta(String estadoConsulta, String ResultadoConsulta, String diagnosticoPaciente, Resenia resenia) {
        this.estadoConsulta = estadoConsulta;
        this.ResultadoConsulta = ResultadoConsulta;
        this.diagnosticoPaciente = diagnosticoPaciente;
        this.resenia = resenia;
    }

    public String getEstadoConsulta() {
        return estadoConsulta;
    }

    public String getResultadoConsulta() {
        return ResultadoConsulta;
    }

    public String getDiagnosticoPaciente() {
        return diagnosticoPaciente;
    }

    public Resenia getResenia() {
        return resenia;
    }

    public void setEstadoConsulta(String estadoConsulta) {
        this.estadoConsulta = estadoConsulta;
    }

    public void setResultadoConsulta(String ResultadoConsulta) {
        this.ResultadoConsulta = ResultadoConsulta;
    }

    public void setDiagnosticoPaciente(String diagnosticoPaciente) {
        this.diagnosticoPaciente = diagnosticoPaciente;
    }

    public void setResenia(Resenia resenia) {
        this.resenia = resenia;
    }
    
    public void generaResenia(String reseniaTexto, int calificacion) {
        if (this.resenia == null) {
            this.resenia = new Resenia(reseniaTexto, calificacion);
        } else {
            System.out.println("Ya existe una resenia para esta consulta.");
        }
    }
    
    //obtener temperatura
}
