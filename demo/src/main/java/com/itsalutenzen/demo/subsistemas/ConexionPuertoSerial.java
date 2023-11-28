package com.itsalutenzen.demo.subsistemas;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortEventListener;
public class ConexionPuertoSerial {
    private SerialPort puertoSerie;
    private String puertoSerial = "COM4"; // Definición del puerto por defecto
    private double temperatura;
    
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
            System.out.println("PUERTO ABIERTO ");
        } catch (SerialPortException ex) {
            System.out.println("Error al abrir el puerto: " + ex.getMessage());
        }
    }

    public void startReading() {
        try {
            puertoSerie.addEventListener(new SerialPortEventListener() {
                @Override
                public void serialEvent(SerialPortEvent event) {
                    if (event.isRXCHAR() && event.getEventValue() > 0) {
                        try {
                            String receivedData = puertoSerie.readString(event.getEventValue());
                            if (receivedData != null && !receivedData.isEmpty()) {
                                temperatura = Double.parseDouble(receivedData.trim());
                                System.out.println("Temperatura leída: " + temperatura);
                            }
                        } catch (SerialPortException | NumberFormatException ex) {
                            System.out.println("Error al leer datos: " + ex);
                        }
                    }
                }
            });
        } catch (SerialPortException ex) {
            System.out.println("Error al abrir el puerto serie: " + ex);
        }
    }

    public double getTemperatura() {
        return temperatura;
    }


    public void cerrarPuerto() {
        try {
            puertoSerie.closePort();
        } catch (SerialPortException ex) {
            System.out.println("Error al cerrar el puerto: " + ex.getMessage());
        }
    }


}
