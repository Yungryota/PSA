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
    
    
    //VALIDO EL VALOR ENTRANTE DESDE ANGULAR (LO QUE DIJO EL PROFE NACHO DE LA INYECCION DE SQL)
    public Usuario validarInicioSesion(String rut){
        if(rut.length() != 10){
            return validarInicioSesion(rut) ;
            //SI EL RUT NO ES DEL LARGO 12345678-9 (10 caract) NOTIFICA MAL USO 

        }else{
            //SI ESTA BN APLICA EL QUERY QUE ESTA DIRECTAMENTE DESDE ACA CON EL RUT YA VERIFICADO
            AppConfigSql connect = new AppConfigSql();
            NoSQLHandle handle = connect.connectToDatabase();
            String sql= "SELECT * FROM paciente where rut ='"+rut+"'";
            return connect.ejecutarConsulta(handle, sql);

        }
        
    }
}
