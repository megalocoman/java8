package com.company;

import com.company.Modelo.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterFlatMap {

    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("Nino Felino", "Chibo Lito", "Gordo Lechon", "Gatoberto Muerto", "Esteban Dido", "Gatoberto vivo")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .flatMap(u -> {
                    if (u.getNombre().equalsIgnoreCase("Gatoberto")) {
                        return Stream.of(u);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);

//        List<Usuario> lista = nombres.collect(Collectors.toList());
//        nombres.forEach(u -> System.out.println(u));
        System.out.println(nombres.count());

    }
}
