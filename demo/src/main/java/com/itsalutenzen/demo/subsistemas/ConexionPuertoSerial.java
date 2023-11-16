package com.itsalutenzen.demo.subsistemas;

import jssc.SerialPort;
import jssc.SerialPortException;

public class ConexionPuertoSerial {
    private SerialPort puertoSerie;
    private String puertoSerial = "COM1"; // Definición del puerto por defecto

    public ConexionPuertoSerial() {
        this.puertoSerie = new SerialPort(this.puertoSerial);
    }

    public void abrirPuerto() {
        try {
            puertoSerie.openPort();
            puertoSerie.setParams(
                SerialPort.BAUDRATE_9600,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE
            );
        } catch (SerialPortException ex) {
            System.out.println("Error al abrir el puerto: " + ex.getMessage());
        }
    }

    public String leerDatos() {
        String datosRecibidos = "";
        try {
            datosRecibidos = puertoSerie.readString();
        } catch (SerialPortException ex) {
            System.out.println("Error al leer del puerto: " + ex.getMessage());
        }
        return datosRecibidos;
    }

    public void cerrarPuerto() {
        try {
            puertoSerie.closePort();
        } catch (SerialPortException ex) {
            System.out.println("Error al cerrar el puerto: " + ex.getMessage());
        }
    }


}
