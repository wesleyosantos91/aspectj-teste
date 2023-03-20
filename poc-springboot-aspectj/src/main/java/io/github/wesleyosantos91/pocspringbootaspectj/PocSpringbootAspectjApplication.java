package io.github.wesleyosantos91.pocspringbootaspectj;

import io.github.wesleyosantos91.MeuAspecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDate;

//@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = MeuAspecto.class)
@SpringBootApplication
public class PocSpringbootAspectjApplication implements CommandLineRunner {

    @Autowired
    private PersonService service;

    public static void main(String[] args) {
        SpringApplication.run(PocSpringbootAspectjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setId(1L);
        person.setName("Wesley");
        person.setDateOfBirth(LocalDate.of(1991, 6, 12));
        person.setCpf("03669152100");
        person.setEmail("wesleyosantos91@gmail.com");

        service.print(person);

    }
}
