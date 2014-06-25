package test.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import utils.Fila;

@RunWith(JUnit4.class)
public class FilaTest {

    @Test
    public void testConstrutorComParametros () {
        Fila f = new Fila(5);

        org.junit.Assert.assertEquals(
            "testando para ver se construtor existe",
            5, f.getTamanho());
    }

    @Test
    public void testConstrutorComParametrosArmazenaParametro () {
        Fila f = new Fila(4);

        org.junit.Assert.assertEquals(
            "testando para ver se construtor existe",
            4, f.getTamanho());
    }

    @Test
    public void testEnfileirarRecebe1Elemento () {
        Fila ru = new Fila(4);

        ru.enfileirar("Luma");

        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "Luma", ru.toString());
    }

    @Test
    public void testEnfileirarRecebe2Elementos () {
        Fila ru = new Fila(4);

        ru.enfileirar("Marcelo");
        ru.enfileirar("Leticia");

        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "Marcelo, Leticia", ru.toString());
    }

    @Test
    public void testFilaVazia () {
        Fila ru = new Fila(4);

        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "", ru.toString());
    }

    @Test
    public void testFilaCheia () {
        Fila ru = new Fila(2);

        ru.enfileirar("Rafael");
        ru.enfileirar("Bernardo");
        ru.enfileirar("Diogo");

        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "Rafael, Bernardo", ru.toString());
    }

    @Test
    public void testDesenfileirarUmElemento () {
        Fila ru = new Fila(2);

        ru.enfileirar("Rafael");
        ru.enfileirar("Bernardo");

        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "Rafael", ru.desenfileirar());
    }

    @Test
    public void testDesenfileirarTresElementos () {
        Fila ru = new Fila(3);

        ru.enfileirar("Diogo");
        ru.enfileirar("Jonas");
        ru.enfileirar("Filipe");

        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "Diogo", ru.desenfileirar());
        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "Jonas", ru.desenfileirar());
        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "Filipe", ru.desenfileirar());
    }

    @Test
    public void testEncherAFilaERemoverEInserirUmNovoElemento () {
        Fila ru = new Fila(3);

        ru.enfileirar("Diogo");
        ru.enfileirar("Jonas");
        ru.enfileirar("Filipe");

        ru.desenfileirar();

        ru.enfileirar("Daniel");

        org.junit.Assert.assertEquals(
            "Verificando o estado da fila",
            "Jonas, Filipe, Daniel", ru.toString());
    }
}
