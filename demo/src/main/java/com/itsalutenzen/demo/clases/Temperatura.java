package com.itsalutenzen.demo.clases;

import com.itsalutenzen.demo.subsistemas.ConexionPuertoSerial;

import java.util.concurrent.CompletableFuture;

public class Temperatura {
    private ConexionPuertoSerial conexionPuerto;

    public Temperatura() {
        conexionPuerto = new ConexionPuertoSerial();
        conexionPuerto.abrirPuerto();
        // No es necesario iniciar la lectura aquí, se hará cuando se solicite explícitamente
    }
    
    // IMPORTANTE: CREAR VALIDACIÓN RANGO TEMPERATURA NORMAL, PASO 7 Y 9 DIAGRAMA RF 12: ESCANEO PACIENTE
    public CompletableFuture<Double> obtenerTemperaturaAsync() {
        CompletableFuture<Double> temperaturaFuture = conexionPuerto.startReading();
        
        return temperaturaFuture.thenApply(temperatura -> {
            System.out.println("Temperatura actual: " + temperatura);
            conexionPuerto.cerrarPuerto();
            return temperatura;
        });
        
    }
}
