package com.itsalutenzen.demo.clases;

import com.itsalutenzen.demo.subsistemas.ConexionPuertoSerial;

public class Temperatura {


    public int temp;


    
    public int obtenerTemperatura() {
        ConexionPuertoSerial conexionPuerto = new ConexionPuertoSerial(); // Crear una nueva instancia de ConexionPuertoSerial
        conexionPuerto.abrirPuerto(); // Abre el puerto serial
        temp = conexionPuerto.startReading();
        return temp;  // Por ejemplo, retorna 0 en caso de error o cuando los datos están vacíos
    }
}
