package com.itsalutenzen.demo;

import oracle.nosql.driver.NoSQLHandle;
import oracle.nosql.driver.ops.GetRequest;
import oracle.nosql.driver.ops.GetResult;
import oracle.nosql.driver.values.MapValue;
import oracle.nosql.driver.ops.GetRequest;
import oracle.nosql.driver.ops.GetResult;
import oracle.nosql.driver.ops.QueryRequest;
import oracle.nosql.driver.ops.QueryResult;
import oracle.nosql.driver.ops.QueryIterableResult;
import java.util.ArrayList;
import oracle.nosql.driver.values.MapValue;
import oracle.nosql.driver.values.FieldValue;

public class viewTable {

public ArrayList<Paciente> executeQueries(NoSQLHandle handle, String tableName) {
    ArrayList<Paciente> pacientesList = new ArrayList<>();

    try (QueryRequest queryRequest = new QueryRequest().setStatement("select * from " + tableName)) {
        ArrayList<MapValue> results = new ArrayList<>();
        do {
            QueryResult queryResult = handle.query(queryRequest);
            results.addAll(queryResult.getResults());
        } while (!queryRequest.isDone());

        for (MapValue res : results) {
            // Suponiendo que los datos de los pacientes están en ciertas columnas específicas en los resultados del query
            String nombre = res.getString("nombre");
            String rut = res.getString("rut");
            int edad = res.getInt("edad");
            int numdoc = res.getInt("num_doc");
            // Obtén otros atributos del paciente de manera similar

            // Crea un objeto de la clase Paciente con los datos obtenidos
            Paciente paciente = new Paciente(rut, nombre, numdoc, edad);

            // Agrega el objeto Paciente a la lista
            pacientesList.add(paciente);
        }
    } catch (Exception e) {
        // Maneja las excepciones según tus necesidades
        e.printStackTrace();
    }

    // Retorna la lista de pacientes
    return pacientesList;
}
    public String executeQueriesWhereRut (NoSQLHandle handle,
                                     String tableName,
                                     String rut){
        MapValue params = new MapValue();
        params.put("rut", rut);
        System.out.println("desde params ="+params);
        try (QueryRequest queryRequest = new QueryRequest()
            .setStatement("select * from " + tableName + " where rut = '"+rut+"'");
            QueryIterableResult results = handle.queryIterable(queryRequest)) {
                System.out.println("Query results:");
                for (MapValue res : results) {
                    System.out.println("\t" + res);
                    String nombre = res.getString("nombre");
                    System.out.println("desde el metodo "+nombre);
                    return nombre;
                }
            }       
        return null;
    }
}
