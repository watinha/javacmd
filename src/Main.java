import utils.Fila;

public class Main {
    public static void main (String args[]) {
        Fila f = new Fila (5);
        f.enfileirar("Abobrinha");
        f.enfileirar("Abobrinha 1");
        f.enfileirar("Abobrinha 2");
        f.enfileirar("Abobrinha 3");
        f.enfileirar("Abobrinha X");
        System.out.println(f);
    }

}
