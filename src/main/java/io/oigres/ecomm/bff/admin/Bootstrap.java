package io.oigres.ecomm.bff.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackageClasses = { Bootstrap.class } )
@ConfigurationPropertiesScan
public class Bootstrap {
    
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}

}
