package ca.codetyto;

import it.ozimov.springboot.mail.configuration.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEmailTools
public class App  {
	public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
  	}
}