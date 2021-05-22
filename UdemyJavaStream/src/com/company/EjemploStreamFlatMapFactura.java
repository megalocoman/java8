package com.company;

import com.company.Modelo.Factura;
import com.company.Modelo.Usuario;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EjemploStreamFlatMapFactura {

    public static void main(String[] args) {

        Usuario u1 = new Usuario("Nino",  "Felino");
        Usuario u2 = new Usuario("Chibo", "Lito");

        u1.addFactura(new Factura("papitas fritas"));
        u1.addFactura(new Factura("tijeras"));

        u2.addFactura(new Factura("quesillo"));
        u2.addFactura(new Factura("corchetera"));

        List<Usuario> usuario = Arrays.asList(u1, u2);

        usuario.stream()
                .map(Usuario::getFacturas)
                .flatMap(Collection::stream)
                .forEach(f -> System.out.println(f.getDescripsion().concat(": cliente ")
                .concat(f.getUsuario().toString())));

//        for(Usuario u : usuario){
//            for(Factura f : u.getFacturas()){
//                System.out.println(f.getDescripsion());
//            }
//        }
    }
}
