package com.gadaldipietro.progettoenigma

public class Criptografia {
    private final Rotore r1, r2, r3;
    private final Reflector rf;
    char[] fraseDivisa;
    StringBuilder codice;

    Criptografia(int r11,int r22, int r33, int rf1){
        this.r1 = new Rotore(r11);
        this.r2 = new Rotore(r22);
        this.r3 = new Rotore(r33);
        this.rf = new Reflector(rf1);
        codice = new StringBuilder();
    }

    public void giraRotori(){
        r1.giraRotore();
        if (r1.cambioRotore()) {
            r2.giraRotore();
            if (r2.cambioRotore()) {
                r3.giraRotore();
            }
        }
    }

    public char codificaLettera(char ch){
        return r1.letteraInversa(r2.letteraInversa(r3.letteraInversa(rf.lettera(r3.lettera(r2.lettera(r1.lettera(ch)))))));
    }

    public StringBuilder codificaFrase(String frase){
        fraseDivisa = (frase.toUpperCase()).toCharArray();
        for (char ch : fraseDivisa){
            giraRotori();
            codice.append(codificaLettera(ch));
        }
        return codice;
    }
}
