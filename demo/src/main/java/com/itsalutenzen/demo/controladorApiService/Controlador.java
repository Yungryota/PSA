/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.controladorApiService;
/* imports en desuso
import jakarta.servlet.http.HttpServletRequest;
import oracle.nosql.driver.ops.QueryRequest;
import oracle.nosql.driver.ops.QueryResult;
import oracle.nosql.driver.values.MapValue;
import org.springframework.web.bind.annotation.RestController;
*/
import com.itsalutenzen.demo.clases.MicroControlador;
import java.util.ArrayList;
import oracle.nosql.driver.NoSQLHandle;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itsalutenzen.demo.clases.Paciente;
import com.itsalutenzen.demo.oraclecloud.AppConfigSql;
import com.itsalutenzen.demo.oraclecloud.viewTable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author LUKAS GAMER
 */

import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200/", maxAge = 9600)

@RequestMapping({"/psa"})
@RestController
public class Controlador {

    @GetMapping("/hello") /* http://localhost:8080/psa/hello test por eliminar funciones futuras */
    public ArrayList<Paciente> getPatients() {
        String tableName = "paciente";
        AppConfigSql appConfig = new AppConfigSql();
        NoSQLHandle handle = appConfig.connectToDatabase();
        viewTable viewTable = new viewTable();
        
        return viewTable.executeQueries(handle, tableName);
    }
    @GetMapping("/{rut}")
    public Paciente getAuth(@PathVariable String rut){
        
        viewTable auth = new viewTable();
        AppConfigSql appConfig = new AppConfigSql();
        NoSQLHandle handle = appConfig.connectToDatabase();
        return auth.buscarPorRut(handle, rut);
    }
    
    @GetMapping("/arduino")
    public String encenderArduino(){
        MicroControlador arduino = new MicroControlador();
        
        arduino.abrirArduino();
        arduino.cerrarArduino();
        return "arduino encendido";
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/psa/enviarCategoriaPaciente") // hacer el post mapping en 
    public void recibirCategoriaPaciente(@RequestBody String categoriaPaciente) {
        System.out.println("Categoría del paciente recibida: " + categoriaPaciente);
    }

}