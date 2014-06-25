package test.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import utils.IFila;
import utils.Fila;
import utils.FilaProxy;
import test.utils.FilaMock;

@RunWith(JUnit4.class)
public class FilaProxyTest {

    @Test
    public void testExemploIntegracaoEnfileirarComProxy () {
        IFila f = new FilaProxy(new Fila(5));

        f.enfileirar("Gabriel");
        f.enfileirar("Gisele");

        org.junit.Assert.assertEquals(
            "testando para ver se construtor existe",
            "[1]Gabriel, [2]Gisele", f.toString());
    }

    @Test
    public void testExemploUnitarioEnfileirarComProxy () {
        FilaMock mock = new FilaMock();
        IFila f = new FilaProxy(mock);

        f.enfileirar("Gabriel");

        org.junit.Assert.assertEquals(
            "teste de unidade com pseudo-controlados",
            "[1]Gabriel", mock.a[0]);
    }

}
