package utils;

class Abobrinha {
    public static void main (String[] args) {
        IFila n = new FilaProxy(new Fila(5));

        n.enfileirar("Gabriel");
        n.enfileirar("Gisele");
        System.out.println("Ola mundo para o Richard");

        System.out.println(n);
    }
}
