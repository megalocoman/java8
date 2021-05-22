package com.company;

import com.company.Modelo.Usuario;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class EjemploStreamListToStream {

    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Nino",  "Felino"));
        lista.add(new Usuario("Chibo", "Lito"));
        lista.add(new Usuario("Gordo", "Lechon"));
        lista.add(new Usuario("Gatoberto", "Muerto"));
        lista.add(new Usuario("Esteban", "Dido"));
        lista.add(new Usuario("Gatoberto", "vivo"));


       Stream<String> nombres = lista.stream().map(u -> u.getNombre().toUpperCase()
            .concat(" ").concat(u.getApellido().toUpperCase()))
            .flatMap(nombre -> {
                if(nombre.contains("Gatoberto".toUpperCase())){
                    return Stream.of(nombre);
                }
                return Stream.empty();
            })
            .map(u -> u.toLowerCase())
            .peek(u -> System.out.println(u));

        System.out.println(nombres.count());
    }

}
