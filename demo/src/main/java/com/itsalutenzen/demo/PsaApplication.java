package com.itsalutenzen.demo;
import com.oracle.nosql.spring.data.core.NosqlOperations;
import oracle.nosql.driver.NoSQLHandle;



   import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.context.ConfigurableApplicationContext;
   import java.io.IOException;
import com.fazecast.jSerialComm.SerialPort;
import com.oracle.nosql.spring.data.repository.config.EnableNosqlRepositories;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.OutputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

@ComponentScan(basePackages = "com.itsalutenzen.demo")
@EnableNosqlRepositories()

public class PsaApplication {
    
    
       
       public static void main( String[] args )
       {
           ConfigurableApplicationContext
               ctx = SpringApplication.run(PsaApplication.class, args);
           
           AppConfig appconfig = new AppConfig();

           NoSQLHandle handle = appconfig.connectToDatabase();
        // Ejecuta las consultas en la base de datos

           
           System.out.println(new File("").getAbsolutePath());
           

            SerialPort sp = SerialPort.getCommPort("COM1"); // device name TODO: must be changed
            sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
            sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written
                if (sp.openPort()) {
                System.out.println("Port is open :)");
                            try {
                OutputStream os = sp.getOutputStream();
                // Envía un comando para encender el LED (por ejemplo, '1')
                os.write('1');
                os.flush();
                System.out.println("LED encendido.");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sp.closePort(); // Cierra el puerto después de enviar el comando
            }
              } else {
                System.out.println("Failed to open port :(");
                return;
              }
       }



    

   }


