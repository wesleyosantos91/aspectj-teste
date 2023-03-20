package io.github.wesleyosantos91.pocspringbootaspectj;

import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String cpf;
    private String email;
}
