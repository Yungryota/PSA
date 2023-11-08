/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.clases;

import com.oracle.nosql.spring.data.core.mapping.NosqlId;
import com.oracle.nosql.spring.data.core.mapping.NosqlTable;



@NosqlTable(autoCreateTable = true, tableName = "Student")
public class Student {
    /*The @NosqlId annotation specifies that this field will act 
      as the ID field. And the generated=true attribute specifies 
      that this ID will be auto-generated by a sequence.*/
    @NosqlId(generated = true)
    long id;
    String firstName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    String lastName;
    /* public or package protected constructor required when retrieving from database */
    public Student() {  
    } 
    /*This method overrides the toString() method, and then 
      concatenates id, firstname, and lastname, and then returns a String*/
    @Override
    public String toString() {
        return "Student{" +
            "id=" + id + ", " +
            "firstName=" + firstName + ", " +
            "lastName=" + lastName +
            '}';
    }
}
