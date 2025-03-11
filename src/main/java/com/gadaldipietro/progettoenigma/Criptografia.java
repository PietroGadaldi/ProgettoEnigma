package com.gadaldipietro.progettoenigma;

public class Criptografia {
    private final Rotore r1, r2, r3;
    private final Reflector rf;
    StringBuilder codice;

    Criptografia(int r1, int index1, int r2,int index2, int r3, int index3, int rf1){
        this.r1 = new Rotore(r1,index1);
        this.r2 = new Rotore(r2,index2);
        this.r3 = new Rotore(r3,index3);
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
        giraRotori();
        return r1.letteraInversa(r2.letteraInversa(r3.letteraInversa(rf.lettera(r3.lettera(r2.lettera(r1.lettera(ch)))))));
    }




}
