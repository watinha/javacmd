package test.utils;

import utils.IFila;

public class FilaMock implements IFila {

    public String [] a = new String[15];
    public int tam = 0;

    public void enfileirar (String aluno) {
        this.a[this.tam++] = aluno;
    }

    public String desenfileirar () { return ""; }


    public String toString () { return ""; }
}
