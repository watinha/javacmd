package test.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import utils.Fila;

@RunWith(JUnit4.class)
public class FilaTest {

    @Test
    public void harnessTest () {
        org.junit.Assert.assertEquals(
            "Harness test... 4 should be equals to 3 + 1",
            (3 + 1), 4);
    }

    @Test
    public void testFilaReturnsEmptyArray () {
        Fila f = new Fila(5);
        String result = f.toString();
        org.junit.Assert.assertEquals(
            "should return empty array", "[ ]", result);
    }

    @Test
    public void testFilaRecebeUmElemento () {
        Fila f = new Fila <String>(5);
        f.enfileirar("Joan");
        String result = f.toString();
        org.junit.Assert.assertEquals(
            "should return array with an element", "[ Joan ]", result);
    }

    @Test
    public void testFilaRecebeVariosElementos () {
        Fila f = new Fila <String> (5);
        f.enfileirar("Joan");
        f.enfileirar("Lucas");
        f.enfileirar("Matheus");
        f.enfileirar("Willian");
        f.enfileirar("Jenny");
        String result = f.toString();
        org.junit.Assert.assertEquals(
            "should return array with an element",
            "[ Joan,Lucas,Matheus,Willian,Jenny ]", result);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testFilaRemoveOsPrimeiros () {
        Fila <String> f = new Fila <String> (5);
        String removido;
        f.enfileirar("Joan");
        f.enfileirar("Lucas");
        f.enfileirar("Matheus");
        f.enfileirar("Willian");
        f.enfileirar("Jenny");

        removido = (String) f.desenfileirar();
        org.junit.Assert.assertEquals(
            "should remove the first inserted",
            "Joan", removido);
    }

    @Test
    public void testFilaContinuaCom5ElementosAposRemoverTudo () {
        Fila f = new Fila <String>(5);
        f.enfileirar("Joan");
        f.enfileirar("Lucas");
        f.enfileirar("Matheus");
        f.enfileirar("Willian");
        f.enfileirar("Jenny");

        f.desenfileirar();
        f.enfileirar("Newton");
        f.desenfileirar();
        f.desenfileirar();
        f.desenfileirar();

        String result = f.toString();
        org.junit.Assert.assertEquals(
            "should present two elements",
            "[ Jenny,Newton ]", result);
    }

}
