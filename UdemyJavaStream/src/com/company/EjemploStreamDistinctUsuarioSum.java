package com.company;

import com.company.Modelo.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {

    public static void main(String[] args) {
        IntStream largoNombre = Stream
                .of("Nino Felino", "Chibo Lito", "Gordo Lechon", "Gatoberto Muerto", "Esteban Dido", "Gatoberto vivo",
                        "Nino Felino", "Nino Felino")
//                .distinct()
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(u -> System.out.println(u));
//                .filter(u -> u.getNombre().equals("Gatoberto"));

//        largoNombre.forEach(System.out::println);

//        System.out.println("total: " +largoNombre.sum());
        // no usar dos terminales, se cierra en sum
//        System.out.println(largoNombre.average());

        IntSummaryStatistics summary = largoNombre.summaryStatistics();
        System.out.println("max: "+ summary.getMax());
        System.out.println("Sum: " + summary.getSum());
        System.out.println("Min: " + summary.getMin());


    }
}
