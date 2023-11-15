/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
import jssc.SerialPortEventListener;
import jssc.SerialPortEvent;


// Relacion de dependencia con clase Consulta --> logica similar a una variable dependiente e independiente
public class MicroControlador {
    private String ultimoDatoPIR; // IMPORTANTE: DATOS Y LOGICA DEBEN ACTUZALIZARSE CUANDO SE OBTENGA EL SENSOR DE TEMPERATURA
    private Consulta consulta; //Relacion de dependencia entre la clase consulta y microcontrolador
    
    public void verPuertos() {
        String puertos[] = SerialPortList.getPortNames();
        String puertoSeleccionado = null;
        
        // Mostrar puertos disponibles
        System.out.println("Puertos disponibles:");
        for (String n : puertos) {
            System.out.println(n);
            if (puertoSeleccionado == null || Integer.parseInt(n.substring(3)) > Integer.parseInt(puertoSeleccionado.substring(3))) {
                puertoSeleccionado = n;
            }
        }

        if (puertoSeleccionado != null) {
            // Conectar al puerto mayor a uno
            SerialPort sp = new SerialPort(puertoSeleccionado);
            try {
                sp.openPort();
                sp.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                System.out.println("Conectado al puerto :)");
                Thread.sleep(2000);
                sp.writeString("1");
                System.out.println("Enviando un 1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void encenderLED() {
        SerialPort sp = new SerialPort("COM5");
        try {
            sp.openPort();
            sp.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            Thread.sleep(2000);
            sp.writeString("1");
            System.out.println("Enviando un 1 para encender el LED");

            // Cerrar el puerto después de usarlo
            sp.closePort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagarLED() {
        SerialPort sp = new SerialPort("COM5");
        try {
            sp.openPort();
            sp.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            Thread.sleep(2000);
            sp.writeString("0");
            System.out.println("Enviando un 0 para apagar el LED");

            // Cerrar el puerto después de usarlo
            sp.closePort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String verPIR() {
        String[] puertos = SerialPortList.getPortNames();
        String puertoSeleccionado = null;

        // Buscar el puerto mayor a uno
        for (String n : puertos) {
            if (puertoSeleccionado == null || Integer.parseInt(n.substring(3)) > Integer.parseInt(puertoSeleccionado.substring(3))) {
                puertoSeleccionado = n;
            }
        }

        if (puertoSeleccionado != null) {
            SerialPort sp = new SerialPort(puertoSeleccionado);
            try {
                sp.openPort();
                sp.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                sp.addEventListener(new SerialPortEventListener() {
                    @Override
                    public void serialEvent(SerialPortEvent serialPortEvent) {
                        if (serialPortEvent.isRXCHAR() && serialPortEvent.getEventValue() > 0) {
                            try {
                                ultimoDatoPIR = sp.readString();
                                // Procesa los datos recibidos
                                procesarDatosPIR(ultimoDatoPIR);
                            } catch (SerialPortException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

                // Mantén el programa en ejecución para recibir eventos
                Thread.sleep(Long.MAX_VALUE);

                // Cerrar el puerto después de usarlo
                sp.closePort();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ultimoDatoPIR; // Retorna el último dato PIR
    }

    private static void procesarDatosPIR(String data) {
        // Procesa los datos recibidos dentro de la función, o puedes llamar a otra función para el procesamiento
        System.out.println("Procesando datos PIR: " + data);
    }
    public void cerrarPuerto(SerialPort sp) {
        try {
            if (sp != null && sp.isOpened()) {
                sp.closePort();
                System.out.println("Puerto cerrado correctamente.");
            }
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    
}
