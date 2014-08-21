package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frutas")
public class Frutas {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String Nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
