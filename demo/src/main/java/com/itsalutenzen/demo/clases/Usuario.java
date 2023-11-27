/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;
import com.itsalutenzen.demo.subsistemas.*;
import oracle.nosql.driver.NoSQLHandle;
/**
 *
 * @author LUKAS GAMER
 */
public class Usuario {
    public String rut;
    public String nombre;
    public int num_doc;
    public int edad;
    public String contacto;
    
    public Usuario(String rut, String nombre, int num_doc, int edad, String contacto) {
        this.rut = rut;
        this.nombre = nombre;
        this.num_doc = num_doc;
        this.edad = edad;
        this.contacto = contacto;
    }
    

    @Override
    public String toString() {
        return "Paciente{" + "rut=" + rut + ", nombre=" + nombre + ", num_doc=" + num_doc + ", edad=" + edad + ", contacto=" + contacto + '}';
    }

    public String getRut() { //DA_RF1 - PASO 6: valida inicio de sesion
        if(rut.length() != 10){
            return rut;
        }
        return "Por favor, ingrese un rut valido";
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(int num_doc) {
        this.num_doc = num_doc;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
    
    
    public Usuario obtenerRutUsuario(String rut) { //DA_RF1 - PASO 7: SELECT WHERE
        AppConfigSql connect = new AppConfigSql();
        NoSQLHandle handle = connect.connectToDatabase();
        String sql = "SELECT * FROM usuario WHERE rut ='" + rut + "'"; // FIGURA EN EL SISTEMA

        try {
            return connect.ejecutarConsulta(handle, sql);
        } catch (Exception ex) {
            System.out.println("Error al buscar el usuario con RUT: " + rut);//DA_RF1 - PASO 7: NO FIGURA EN EL SISTEMA
            ex.printStackTrace();
            return null;
        }
    }


}
