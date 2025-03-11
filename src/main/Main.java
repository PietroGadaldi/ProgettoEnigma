package com.gadaldipietro.progettoenigma

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rotore r1 = new Rotore(1);
        Rotore r2 = new Rotore(2);
        Rotore r3 = new Rotore(3);
        Reflector rf1 = new Reflector(2);
        ArrayList<Integer> r = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci il testo da cifrare: ");
        String frase = in.next().toUpperCase();
        in.close();

        char[] fraseDivisa = frase.toCharArray();
        StringBuilder codice = new StringBuilder();

        for (char c : fraseDivisa) {
            r1.giraRotore();
            if (r1.cambioRotore()) {
                r2.giraRotore();
                if (r2.cambioRotore()) {
                    r3.giraRotore();
                }
            }

            System.out.println("\nLettera originale: " + c);
            char c1 = r1.lettera(c);
            System.out.println("Dopo Rotore 1: " + c1);
            c1 = r2.lettera(c1);
            System.out.println("Dopo Rotore 2: " + c1);
            c1 = r3.lettera(c1);
            System.out.println("Dopo Rotore 3: " + c1);

            c1 = rf1.lettera(c1);
            System.out.println("Dopo Riflettore: " + c1);

            c1 = r3.letteraInversa(c1);
            System.out.println("Dopo Rotore 3: " + c1);
            c1 = r2.letteraInversa(c1);
            System.out.println("Dopo Rotore 2: " + c1);
            c1 = r1.letteraInversa(c1);
            System.out.println("Dopo Rotore 1: " + c1);
            codice.append(c1);
        }
        System.out.println("c: " + codice);
    }
}
