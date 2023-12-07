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
import com.itsalutenzen.demo.clases.Consulta;
import com.itsalutenzen.demo.clases.Resenia;
import com.itsalutenzen.demo.clases.Temperatura;
import com.itsalutenzen.demo.clases.Paciente;
import com.itsalutenzen.demo.subsistemas.AppConfigSql;

import jssc.SerialPort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author LUKAS GAMER
 */

import org.springframework.web.bind.annotation.RestController;


//Puerto original con maximo de peticiones 9600
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 9600)
//Ruta raiz
@RequestMapping({"/psa"})
@RestController
public class Controlador {
    public String resultadoCategoria;
 
    @GetMapping("rut/{rut}") //RUTA http://localhost:8080/psa/{rut} /LLAMA USUARIO Y EJECUTA LA FUNCION DE VALIDAR INICIO DE 
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
    

    
    @GetMapping("arduino/temp")
    public double getTemp() throws ExecutionException, InterruptedException { //RF12 - Paso 6: Llama a servicio getTemp
        Temperatura temperatura = new Temperatura();
        CompletableFuture<Double> temperaturaFuture = temperatura.obtenerTemperaturaAsync();
        return temperaturaFuture.get(); //RF12 - Paso 9: Devuelve temperatura
    }

    @GetMapping("/respuesta/{respuesta}")
    public ResponseEntity<Consulta> obtenerRespuestasCuestionario(@PathVariable String respuesta) {
        String registroRespuestas = "resp";

        Resenia resenia = new Resenia("muy bueno", 1);
        Consulta consulta = new Consulta("completada", registroRespuestas, "", resenia);
        System.out.println(resenia + "\n" + consulta + "\n" + respuesta);

        return ResponseEntity.ok(consulta);
    }


    
    @GetMapping("categoria/{categoria}")
    public String obtenerCategoriaUsuario(@PathVariable String categoria){
        this.resultadoCategoria = categoria;
        
        Paciente paciente = new Paciente(this.resultadoCategoria, "receta", "2144482-9", "lukas", 123123, 20, "98923344");
        System.out.println(paciente);
        
        System.out.println(getResultadoCategoria());
        return this.resultadoCategoria;
    }
    
    public String getResultadoCategoria(){
        return this.resultadoCategoria;
    }
    
    

} 