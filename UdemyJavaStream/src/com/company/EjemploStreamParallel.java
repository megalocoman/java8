package com.company;

import com.company.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {

    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Nino",  "Felino"));
        lista.add(new Usuario("Chibo", "Lito"));
        lista.add(new Usuario("Gordo", "Lechon"));
        lista.add(new Usuario("Gatoberto", "Muerto"));
        lista.add(new Usuario("Esteban", "Dido"));
        lista.add(new Usuario("Gatoberto", "vivo"));


        long t1 = System.currentTimeMillis();
       String nombres = lista.stream()
            .parallel()
               .map(u -> u.toString().toUpperCase())
               .peek(n -> {
                   System.out.println("nombre thread: " + Thread.currentThread().getName()
                   + " - "+ n);
               })
            .flatMap(nombre -> {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(nombre.contains("Gatoberto".toUpperCase())){
                    return Stream.of(nombre);
                }
                return Stream.empty();
            })
            .map(u -> u.toLowerCase())
            .peek(u -> System.out.println(u))
            .findAny().orElse("");

        long t2 = System.currentTimeMillis();
        System.out.println("tiempo de ejecucion: " + (t2 - t1));
        System.out.println(nombres);
    }

}
