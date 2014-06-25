package utils;

public class FilaProxy implements IFila {
    private IFila destino;
    private int cont = 0;

    public FilaProxy (IFila destino) {
        this.destino = destino;
    }

    public void enfileirar (String aluno) {
        this.cont++;
        this.destino.enfileirar("[" + this.cont + "]" + aluno);
    }

    public String desenfileirar () {
        return this.destino.desenfileirar();
    }

    public String toString () {
        return this.destino.toString();
    }
}
