package com.itsalutenzen.demo.clases;

import com.itsalutenzen.demo.subsistemas.ConexionPuertoSerial;

public class Temperatura {
    
    
    public int obtenerTemperatura() {
        ConexionPuertoSerial conexionPuerto = new ConexionPuertoSerial(); // Crear una nueva instancia de ConexionPuertoSerial
        conexionPuerto.abrirPuerto(); // Abre el puerto serial
        String datosTemperatura = conexionPuerto.leerDatos(); // Lee datos de temperatura
        conexionPuerto.cerrarPuerto(); // Cierra el puerto serial
        
        // Procesa los datos recibidos (puede variar según el formato de los datos)
        System.out.println("Temperatura recibida: " + datosTemperatura);
        
        // Verificar si datosTemperatura no está vacío antes de intentar convertirlo a entero
        if (datosTemperatura != null && !datosTemperatura.isEmpty()) {
            try {
                // Intentar convertir datosTemperatura a entero
                return Integer.parseInt(datosTemperatura);
            } catch (NumberFormatException e) {
                // Si los datos no son un número válido, manejar la excepción aquí
                System.out.println("Los datos de temperatura no son un número válido.");
                // Podrías retornar un valor por defecto o manejar el error de otra manera
            }
        }
        
        // Retornar un valor por defecto si datosTemperatura está vacío o no es un número válido
        return 0; // Por ejemplo, retorna 0 en caso de error o cuando los datos están vacíos
    }
}
