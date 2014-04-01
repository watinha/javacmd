package utils;

public class Fila <T> {
    public static void main (String args[]) {
        Fila <String>f = new Fila <String>(5);
        f.enfileirar("Abobrinha");
        f.enfileirar("Abobrinha 1");
        f.enfileirar("Abobrinha 2");
        f.enfileirar("Abobrinha 3");
        f.enfileirar("Abobrinha X");
        System.out.println(f);
    }

    public Object [] lista;
    public int fim;

    public Fila (int tamanho) {
        this.lista = new Object[tamanho];
        this.fim = 0;
    }

    @SuppressWarnings("unchecked")
    public T desenfileirar () {
        Object primeiro = this.lista[0];
        for (int i = 1; i < this.fim; i++)
            this.lista[i - 1] = this.lista[i];
        this.fim--;
        return (T) primeiro;
    }

    public void enfileirar (T aluno) {
        this.lista[this.fim] = (Object) aluno;
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
