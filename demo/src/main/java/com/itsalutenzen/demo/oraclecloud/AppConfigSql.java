/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsalutenzen.demo.oraclecloud;


import oracle.nosql.driver.NoSQLHandleConfig;
import oracle.nosql.driver.Region;
import oracle.nosql.driver.iam.SignatureProvider;
import com.oracle.nosql.spring.data.config.AbstractNosqlConfiguration;
import com.oracle.nosql.spring.data.config.NosqlDbConfig;
import java.io.File;
import java.io.IOException;
import oracle.nosql.driver.NoSQLHandle;
import oracle.nosql.driver.NoSQLHandleFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
    

    
    @Configuration

    public class AppConfigSql extends AbstractNosqlConfiguration {  
    
    private String endpoint = "sa-santiago-1";
    private String service = "cloud";
    private String compartment = "ocid1.tenancy.oc1..aaaaaaaadgqh2q7vymblwz4hyt24r5jhpp2wf7cenwfefglxly7pqk32yx6a";
    @Bean
        public NosqlDbConfig nosqlDbConfig(){
             /* Config for cloud service */ 
            return new NosqlDbConfig("http://localhost:8080",
            new SignatureProvider(
                "ocid1.tenancy.oc1..aaaaaaaadgqh2q7vymblwz4hyt24r5jhpp2wf7cenwfefglxly7pqk32yx6a",  //tenantId
                "ocid1.tenancy.oc1..aaaaaaaadgqh2q7vymblwz4hyt24r5jhpp2wf7cenwfefglxly7pqk32yx6a",  //userId
                "33:5e:41:bc:2b:8d:ba:3d:21:91:63:9b:ff:87:0c:f9",  // fingerprint of the key
                new File("Ellukas_2023-09-29T20_06_15.554Z.pem"), // path to your private key file
                null // passphrase for the (encrypted) private key
                     )
                );

        }   
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
        
            private void configureAuth(NoSQLHandleConfig config) {
        try {
            SignatureProvider authProvider = new SignatureProvider();
            config.setAuthorizationProvider(authProvider);
        } catch (IOException ioe) {
            System.err.println("Unable to configure authentication: " + ioe);
            System.exit(1);
        }
    }


}
    

