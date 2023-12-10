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
import com.itsalutenzen.demo.clases.FichaMedica;
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
    public Paciente paciente;
    public Consulta consulta;
    public Usuario usuario;
    
    
    @GetMapping("rut/{rut}") //RUTA http://localhost:8080/psa/{rut} /LLAMA USUARIO Y EJECUTA LA FUNCION DE VALIDAR INICIO DE 
    //SESIÓN ATRAVEZ DEL RUT
    public Usuario getAuth(@PathVariable String rut){
        Usuario usuario = new Usuario(rut, "nombre inicial", 0, 0, "contacto inicial");
        Usuario resultadoValidacion = usuario.obtenerRutUsuario(rut);

        // Verifica si el resultado es diferente de null antes de asignarlo a this.usuario
        if (resultadoValidacion != null) {
            System.out.println("El RUT es válido, nombre encontrado: " + resultadoValidacion);
            this.usuario = resultadoValidacion;
        } else {
            System.out.println("RUT inválido");
        }

        return resultadoValidacion; // Devuelve el resultadoValidacion, no usuario.obtenerRutUsuario(rut)
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
        this.consulta = consulta;
        System.out.println(resenia + "\n" + consulta + "\n" + respuesta);

        return ResponseEntity.ok(consulta);
    }

    @GetMapping("/ficha/{ficha}")
    public ResponseEntity<FichaMedica> generarFicha(@PathVariable String ficha) {
        System.out.println(this.consulta);
        System.out.println(this.paciente);

        FichaMedica fm = new FichaMedica();
        return ResponseEntity.ok(fm);
    }

    @GetMapping("categoria/{categoria}")
    public String obtenerCategoriaUsuario(@PathVariable String categoria) {
        this.resultadoCategoria = categoria;
        Paciente paciente = new Paciente(this.resultadoCategoria, "receta", this.usuario.rut, this.usuario.nombre, this.usuario.num_doc, this.usuario.edad, "98923344");
        System.out.println(paciente);
        this.paciente = paciente;
        return this.resultadoCategoria;
    }
    
    @GetMapping("ficha")
    public void agregarFicha(){
        FichaMedica fm = new FichaMedica();
        fm.generarFichaMedica(paciente, consulta);
    }
    
    

}
