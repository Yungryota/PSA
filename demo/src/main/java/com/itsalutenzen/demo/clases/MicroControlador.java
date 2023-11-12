/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;
import jssc.SerialPort;
import jssc.SerialPortList;

public class MicroControlador {
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
}
