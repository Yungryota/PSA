/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

/**
 *
 * @author LUKAS GAMER
 */
public class Usuario {
    public String rut;
    public String nombre;
    public int num_doc;
    public int edad;

    public Usuario(String rut, String nombre, int num_doc, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.num_doc = num_doc;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Paciente{" + "rut=" + rut + ", nombre=" + nombre + ", num_doc=" + num_doc + ", edad=" + edad + '}';
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
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
    
}
