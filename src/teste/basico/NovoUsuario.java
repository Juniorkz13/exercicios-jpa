package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");// Responsável por criar um
                                                                                            // ENTITYMANAGER.
        EntityManager em = emf.createEntityManager(); // Responsável por gerenciar as ENTIDADES, realiza o CRUD com o
                                                      // banco de dados.

        Usuario novoUsuario = new Usuario("Shogum", "shogum@hotmail.com");

        em.getTransaction().begin();
        em.persist(novoUsuario);
        em.getTransaction().commit();

        System.out.println("ID gerado: " + novoUsuario.getId()); // É possivel recuperar informações do que foi gerado

        em.close();
        emf.close();
    }
}
