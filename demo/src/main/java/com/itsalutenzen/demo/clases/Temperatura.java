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

    public CompletableFuture<Double> obtenerTemperaturaAsync() {
        CompletableFuture<Double> temperaturaFuture = conexionPuerto.startReading();

        return temperaturaFuture.thenApply(temperatura -> {
            System.out.println("Temperatura actual: " + temperatura);
            return temperatura;
        });
    }
}
