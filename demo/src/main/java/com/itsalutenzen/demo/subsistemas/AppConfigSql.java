/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.subsistemas;

import com.itsalutenzen.demo.clases.Usuario;
import oracle.nosql.driver.NoSQLHandleConfig;
import oracle.nosql.driver.Region;
import oracle.nosql.driver.iam.SignatureProvider;
import com.oracle.nosql.spring.data.config.AbstractNosqlConfiguration;
import com.oracle.nosql.spring.data.config.NosqlDbConfig;
import java.io.File;
import java.io.IOException;
import oracle.nosql.driver.NoSQLHandle;
import oracle.nosql.driver.NoSQLHandleFactory;
import oracle.nosql.driver.ops.PutRequest;
import oracle.nosql.driver.ops.PutResult;
import oracle.nosql.driver.ops.QueryIterableResult;
import oracle.nosql.driver.ops.QueryRequest;
import oracle.nosql.driver.ops.WriteRequest;
import oracle.nosql.driver.values.MapValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static sun.misc.Signal.handle;



@Configuration

public class AppConfigSql extends AbstractNosqlConfiguration {

    private String endpoint = "sa-santiago-1";
    private String service = "cloud";
    private String compartment = "ocid1.tenancy.oc1..aaaaaaaaczpgg2opew4dwibalinhthzqqy5jp4ynfy4pree57xrunp3tjceq";
    private Usuario res;

    @Bean

    //FUNCION QUE OBTIENE LAS CREDENCIALES DE ACCESO 
    public NosqlDbConfig nosqlDbConfig() {
        /* Config for cloud service */
        return new NosqlDbConfig("http://localhost:8080",
                new SignatureProvider(
                        "ocid1.tenancy.oc1..aaaaaaaaczpgg2opew4dwibalinhthzqqy5jp4ynfy4pree57xrunp3tjceq", //tenantId
                        "ocid1.user.oc1..aaaaaaaawzqtjaq5r247s27kiqk3frzjfzosjnun5zk7q576ebyzsxyrllga", //userId
                        "33:5e:41:bc:2b:8d:ba:3d:21:91:63:9b:ff:87:0c:f9", // fingerprint of the key
                        new File("ellukas121@gmail.com_2023-11-27T02_23_58.258Z.pem"), // path to your private key file
                        null // passphrase for the (encrypted) private key
                )
        );

    }
    //FUNCION QUE REALIZA LA CONEXION

    public NoSQLHandle connectToDatabase() {
        NoSQLHandleConfig config = new NoSQLHandleConfig(endpoint);
        if (compartment != null) {
            config.setDefaultCompartment(compartment);
        }
        config.setRequestTimeout(5000);
        configureAuth(config);
        NoSQLHandle handle = NoSQLHandleFactory.createNoSQLHandle(config);
        System.out.println("Acquired handle for service " + service + " at endpoint " + endpoint);
        return handle;
    }

    //EN CASO DE NO PODER INTENTA ATRAVEZ DEL PROVEDOR
    private void configureAuth(NoSQLHandleConfig config) {
        try {
            SignatureProvider authProvider = new SignatureProvider();
            config.setAuthorizationProvider(authProvider);
        } catch (IOException ioe) {
            System.err.println("Unable to configure authentication: " + ioe);
            System.exit(1);
        }
    }

    //FUNCION PARA OBTENER RESULTADOS DE UNA QUERY QUE UNO ESCRIBIRA DIRECTAMENTE EN LA FUNCION DE LA 
    //CLASE QUE UNO ESTIME, ESTA HECHO EN BASE A USUARIO, REVISAR CLASE USUARIO (Aun en pruebas
    public Usuario ejecutarConsulta(NoSQLHandle handle, String sentenciaSQL) {
        try (QueryRequest queryRequest = new QueryRequest().setStatement(sentenciaSQL); QueryIterableResult results = handle.queryIterable(queryRequest)) {
            System.out.println("Resultados de la consulta:");
            for (MapValue res : results) {
                String rut = res.getString("rut");
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                int numDoc = res.getInt("num_doc");
                String contacto = res.getString("contacto");;
                Usuario usuario = new Usuario(rut, nombre, numDoc, edad, contacto);
                return usuario;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Maneja cualquier excepción que pueda ocurrir durante la consulta
        }
        return null; // Si no se encuentra ningún nombre o hay un error, retorna null
    }

public int getLastId(NoSQLHandle handle, String sentenciaSQL) {
    try (QueryRequest queryRequest = new QueryRequest().setStatement(sentenciaSQL);
         QueryIterableResult results = handle.queryIterable(queryRequest)) {
        
        int ultimoIdFicha = 0;
        for (MapValue res : results) {
            int fichaId = res.getInt("ficha_id");
            if (fichaId > ultimoIdFicha) {
                ultimoIdFicha = fichaId;
            }
        }
        // Incrementa el último ID encontrado en 1 para obtener el siguiente ID
        return ultimoIdFicha + 1;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}



    public void insertRow(NoSQLHandle handle, MapValue value, String tableName) {
        PutRequest putRequest = new PutRequest()
                .setValue(value)
                .setTableName(tableName);
        
        PutResult putRes = handle.put(putRequest);

        System.out.println("Put row, result " + putRes);
    }

}
