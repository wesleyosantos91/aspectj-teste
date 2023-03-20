package io.github.wesleyosantos91.pocspringbootaspectj;

import io.github.wesleyosantos91.annotations.EventoCapturado;
import io.github.wesleyosantos91.annotations.HelloWorld;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @HelloWorld
    public Person print(@EventoCapturado(0) Person person) {
        System.out.println(person);

        return person;
    }
}
