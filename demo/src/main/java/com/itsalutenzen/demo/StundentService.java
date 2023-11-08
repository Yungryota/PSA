/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itsalutenzen.demo;
import com.itsalutenzen.demo.clases.Student;

import java.util.List;

/**
 *
 * @author LUKAS GAMER
 */
public interface StundentService {
    
    List<Student>listar();
    Student listarId(long id);
}
