/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;
import com.fazecast.jSerialComm.SerialPort;
import java.io.OutputStream;

/**
 *
 * @author LUKAS GAMER
 */
public class MicroControlador {
    private SerialPort sp;

    public MicroControlador() {
        // Configura el puerto serie
        sp = SerialPort.getCommPort("COM4"); // Nombre del dispositivo COM
        sp.setComPortParameters(9600, 8, 1, 0); // Configuración predeterminada para Arduino
    }

    public void abrirArduino() {
        if (sp.openPort()) {
            System.out.println("Puerto abierto :)");
        } else {
            System.out.println("Fallo al abrir el puerto :(");
            return;
        }
    }

    public void encenderLED() {
        // Envía un mensaje para encender el LED
        try {
            OutputStream outputStream = sp.getOutputStream();
            String mensaje = "1"; // Envía "1" para encender el LED (debes tener un código en Arduino para interpretar esto)
            outputStream.write(mensaje.getBytes());
        } catch (Exception e) {
            System.err.println("Error al enviar datos al puerto serie: " + e.getMessage());
        }
    }

    public void cerrarArduino() {
        sp.closePort(); // Cierra el puerto serie cuando hayas terminado de usarlo
        System.out.println("Puerto cerrado");
    }
}
