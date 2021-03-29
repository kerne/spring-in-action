package cl.caraya.action;

import cl.caraya.action.beans.BeanServices;
import cl.caraya.action.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cl.caraya.action", "com.falabella.boss"})
public class Main implements CommandLineRunner {

    @Autowired
    BeanServices services;


    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }


    @Override
    public void run(String... args) throws JsonProcessingException {

        System.out.println(services.print(Person.builder().name("Cesar").build()));

    }
}
