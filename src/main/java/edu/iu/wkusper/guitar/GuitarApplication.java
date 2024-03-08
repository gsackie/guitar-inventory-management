package edu.iu.wkusper.guitar;

import edu.iu.wkusper.guitar.model.Guitar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GuitarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuitarApplication.class, args);
	}

}
