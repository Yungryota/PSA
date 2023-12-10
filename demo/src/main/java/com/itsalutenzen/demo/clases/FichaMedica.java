/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

import com.itsalutenzen.demo.subsistemas.AppConfigSql;
import java.util.ArrayList;
import oracle.nosql.driver.NoSQLHandle;
import oracle.nosql.driver.values.MapValue;

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
        AppConfigSql connect = new AppConfigSql();
        NoSQLHandle handle = connect.connectToDatabase();
        AppConfigSql sql = new AppConfigSql();
        
        String rut = paciente.getRut(); // Obtener el rut del paciente
        String categorizacionPaciente = paciente.getCategorizacionPaciente();
        String recetaPaciente = paciente.getRecetaPaciente();
        String estadoConsulta = consulta.getEstadoConsulta();
        String resultadoConsulta = consulta.getResultadoConsulta();
        String diagnosticoPaciente = consulta.getDiagnosticoPaciente();
        int fichaId = sql.getLastId(handle, "SELECT ficha_id from ficha");
        MapValue value = new MapValue()
                .put("ficha_id", fichaId)
                .put("rut_paciente", rut)
                .put("categoria", categorizacionPaciente)
                .put("receta", recetaPaciente)
                .put("estado_consulta", estadoConsulta)
                .put("resultado_consulta", resultadoConsulta)
                .put("diagnostico_paciente", diagnosticoPaciente);
        

        sql.insertRow(handle, value, "ficha");
        
        System.out.println("FICHA MÉDICA");
        System.out.println("ID: " + fichaId);
        System.out.println("RUT del paciente: " + rut);
        System.out.println("Categorización del paciente: " + categorizacionPaciente);
        System.out.println("Receta del paciente: " + recetaPaciente);
        System.out.println("Estado de consulta: " + estadoConsulta);
        System.out.println("Resultado de consulta: " + resultadoConsulta);
        System.out.println("Diagnóstico del paciente: " + diagnosticoPaciente);
    }

}
