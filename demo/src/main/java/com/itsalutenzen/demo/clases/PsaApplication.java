package com.itsalutenzen.demo.clases;
/* imports en desuso
import com.oracle.nosql.spring.data.core.NosqlOperations;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.CommandLineRunner;

*/
import com.fazecast.jSerialComm.SerialPort;
import oracle.nosql.driver.NoSQLHandle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.oracle.nosql.spring.data.repository.config.EnableNosqlRepositories;
import java.io.File;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import com.itsalutenzen.demo.oraclecloud.AppConfigSql;
import java.io.IOException;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

@ComponentScan(basePackages = "com.itsalutenzen.demo")
@EnableNosqlRepositories()

public class PsaApplication {
    
    
       
       public static void main( String[] args ) throws IOException, InterruptedException, Exception
       {
           ConfigurableApplicationContext
               ctx = SpringApplication.run(PsaApplication.class, args);
           
           AppConfigSql appconfig = new AppConfigSql();

           NoSQLHandle handle = appconfig.connectToDatabase();
        // Ejecuta las consultas en la base de datos

           
           System.out.println(new File("").getAbsolutePath());
           MicroControlador arduino = new MicroControlador();
           
           arduino.abrirArduino();
           
		
       }
       



    

   }


