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
    
    
    public void abrirArduino(){
                        SerialPort sp = SerialPort.getCommPort("COM5"); // device name TODO: must be changed
		sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
		sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written
		
		if (sp.openPort()) {
			System.out.println("Port is open :)");
		} else {
			System.out.println("Failed to open port :(");
			return;
		}

    }
        public void enviarDatos(String datos) throws Exception {
            SerialPort sp = SerialPort.getCommPort("COM5"); // device name TODO: must be changed
        OutputStream outputStream = sp.getOutputStream();
        outputStream.write(datos.getBytes());
    }
    
}
