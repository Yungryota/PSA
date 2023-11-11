/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;
import jssc.SerialPort;
import jssc.SerialPortList;

public class MicroControlador {
    public void verPuertos(){
        String puertos[]= SerialPortList.getPortNames();
        for(String n : puertos){
                System.out.println(n);
        }
        
        SerialPort sp = new SerialPort("COM5");
        try{
            sp.openPort();
            sp.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println("Conectado al puerto :)");
            Thread.sleep(1500);
                sp.writeString("1");
                System.out.println("enviando un 1");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
