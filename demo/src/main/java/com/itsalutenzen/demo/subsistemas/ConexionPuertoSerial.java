package com.itsalutenzen.demo.subsistemas;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortEventListener;
import java.util.concurrent.CompletableFuture;


public class ConexionPuertoSerial {
    private SerialPort puertoSerie;
    private String puertoSerial = "COM5"; // Definición del puerto por defecto
    private double temperatura;//define variable

    
    
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

    public CompletableFuture<Double> startReading() {
        CompletableFuture<Double> future = new CompletableFuture<>();

        try {
            puertoSerie.addEventListener(new SerialPortEventListener() {
                @Override
                public void serialEvent(SerialPortEvent event) {
                    if (event.isRXCHAR() && event.getEventValue() > 0) {
                        try {
                            String receivedData = puertoSerie.readString(event.getEventValue());
                            if (receivedData != null && !receivedData.isEmpty()) {
                                temperatura = Double.parseDouble(receivedData.trim());
                                //System.out.println("Temperatura leída: " + temperatura);
                                future.complete(temperatura); // Completa el futuro con la temperatura leída
                            }
                        } catch (SerialPortException | NumberFormatException ex) {
                            future.completeExceptionally(ex); // Completa el futuro con una excepción si ocurre un error
                        }
                    }
                }
            });
        } catch (SerialPortException ex) {
            future.completeExceptionally(ex); // Completa el futuro con una excepción si ocurre un error al abrir el puerto serie
        }

        return future;
    }


    public double getTemperatura() {
        return temperatura; //nunca muestra temeraatura real, quead como 0.0
    }




    public void cerrarPuerto() {
        try {
            puertoSerie.closePort();
        } catch (SerialPortException ex) {
            System.out.println("Error al cerrar el puerto: " + ex.getMessage());
        }
    }


}
