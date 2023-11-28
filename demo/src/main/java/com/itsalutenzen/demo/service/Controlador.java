/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.service;
/* imports en desuso
import jakarta.servlet.http.HttpServletRequest;
import oracle.nosql.driver.ops.QueryRequest;
import oracle.nosql.driver.ops.QueryResult;
import oracle.nosql.driver.values.MapValue;
import org.springframework.web.bind.annotation.RestController;
*/
import com.itsalutenzen.demo.subsistemas.ConexionPuertoSerial;
import java.util.ArrayList;
import oracle.nosql.driver.NoSQLHandle;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itsalutenzen.demo.clases.Usuario;
import com.itsalutenzen.demo.clases.Temperatura;
import com.itsalutenzen.demo.subsistemas.AppConfigSql;

import jssc.SerialPort;
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


    @GetMapping("/{rut}") //RUTA http://localhost:8080/psa/{rut} /LLAMA USUARIO Y EJECUTA LA FUNCION DE VALIDAR INICIO DE 
    //SESIÓN ATRAVEZ DEL RUT
    public Usuario getAuth(@PathVariable String rut){
        
        
        Usuario usuario = new Usuario(rut, "nombre inicial", 0, 0, "contacto inicial");
        Usuario resultadoValidacion = usuario.obtenerRutUsuario(rut); // Llama a validarInicioSesion
        
        // Maneja el resultado de la validación según lo que retorne la función
        if (resultadoValidacion.equals("Error")) {
            System.out.println("RUT inválido");
            return usuario.obtenerRutUsuario(rut);
        } else {
            System.out.println("El RUT es válido, nombre encontrado: " + resultadoValidacion);
            return resultadoValidacion;
        }
    }
    
    @GetMapping("arduino/encender")
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/psa/enviarCategoriaPaciente") // hacer el post mapping en 
    public void recibirCategoriaPaciente(@RequestBody String categoriaPaciente) {
        System.out.println("Categoría del paciente recibida: " + categoriaPaciente);
    }
    
    @GetMapping("arduino/temp")
    public double getAuth(){
        Temperatura temperatura = new Temperatura(); 
        return temperatura.obtenerTemperatura();
    }

}