/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import oracle.nosql.driver.NoSQLHandle;
import oracle.nosql.driver.ops.QueryRequest;
import oracle.nosql.driver.ops.QueryResult;
import oracle.nosql.driver.values.MapValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author LUKAS GAMER
 */

import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RequestMapping({"/psa"})
@RestController
public class Controlador {

    @GetMapping("/hello") /* http://localhost:8080/psa/hello test por eliminar funciones futuras */
    public ArrayList<Paciente> getPatients() {
        String tableName = "paciente";
        AppConfig appConfig = new AppConfig();
        NoSQLHandle handle = appConfig.connectToDatabase();
        viewTable viewTable = new viewTable();
        
        return viewTable.executeQueries(handle, tableName);
    }
    

}