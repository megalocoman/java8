package com.company;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamGenerateInfinitoGenerate {

    public static void main(String[] args) {

        Stream.generate(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hola mundo!";
            })
                .limit(8)
                .forEach(System.out::println);
    }
}
