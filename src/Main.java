import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.util.List;

import models.Frutas;

public class Main {
    public static void main (String args[]) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("supimpa");
        EntityManager manager = factory.createEntityManager();
        List<Frutas> list = manager.createQuery("select t from Frutas as t")
                                   .getResultList();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getNome());
        manager.close();
    }
}
