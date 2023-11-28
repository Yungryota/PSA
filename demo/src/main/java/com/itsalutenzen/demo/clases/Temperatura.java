package com.itsalutenzen.demo.clases;

import com.itsalutenzen.demo.subsistemas.ConexionPuertoSerial;

public class Temperatura {

    private ConexionPuertoSerial conexionPuerto;

    public Temperatura() {
        conexionPuerto = new ConexionPuertoSerial();
        conexionPuerto.abrirPuerto();
        conexionPuerto.startReading(); // Comienza la lectura
    }

    public double obtenerTemperatura() {
        System.out.println("temp:" + conexionPuerto.getTemperatura());
        return conexionPuerto.getTemperatura();
    }
}
