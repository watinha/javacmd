package utils;

public class Fila {
    public String [] lista;
    public int fim;

    public Fila (int tamanho) {
        this.lista = new String[tamanho];
        this.fim = 0;
    }

    @SuppressWarnings("unchecked")
    public String desenfileirar () {
        String primeiro = this.lista[0];
        for (int i = 1; i < this.fim; i++)
            this.lista[i - 1] = this.lista[i];
        this.fim--;
        return primeiro;
    }

    public void enfileirar (String aluno) {
        this.lista[this.fim] = aluno;
        this.fim++;
    }

    public String toString () {
        String aux = "[ ";
        for (int i = 0; i < this.fim; i++)
            aux += lista[i].toString() + ",";
        aux = aux.substring(0, aux.length() - 1) + " ]";
        return aux;
    }

}
