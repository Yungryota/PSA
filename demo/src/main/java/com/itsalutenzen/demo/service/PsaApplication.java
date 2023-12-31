package com.itsalutenzen.demo.service;
/* imports en desuso
import com.oracle.nosql.spring.data.core.NosqlOperations;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.CommandLineRunner;

*/

import com.itsalutenzen.demo.clases.Temperatura;
import com.itsalutenzen.demo.clases.Usuario;
import com.itsalutenzen.demo.subsistemas.ConexionPuertoSerial;
import oracle.nosql.driver.NoSQLHandle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.oracle.nosql.spring.data.repository.config.EnableNosqlRepositories;
import java.io.File;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import com.itsalutenzen.demo.subsistemas.AppConfigSql;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

@ComponentScan(basePackages = "com.itsalutenzen.demo")
@EnableNosqlRepositories()

public class PsaApplication {
    
        public int temp;
       
       public static void main( String[] args ) throws IOException, InterruptedException, Exception
       {
           ConfigurableApplicationContext
               ctx = SpringApplication.run(PsaApplication.class, args);
           
           AppConfigSql appconfig = new AppConfigSql();

           NoSQLHandle handle = appconfig.connectToDatabase();
        // Ejecuta las consultas en la base de datos

           
           System.out.println(new File("").getAbsolutePath());
           Temperatura sensorTemperatura = new Temperatura();
           
           sensorTemperatura.obtenerTemperaturaAsync();
           
           ConexionPuertoSerial conexion = new ConexionPuertoSerial();
           conexion.abrirPuerto();
            
            CompletableFuture<Double> temperaturaFuture = sensorTemperatura.obtenerTemperaturaAsync();

            temperaturaFuture.thenAccept(temperatura -> {
                System.out.println("Temperatura obtenida: " + temperatura);
            });
           
           
       }
       



    

   }


