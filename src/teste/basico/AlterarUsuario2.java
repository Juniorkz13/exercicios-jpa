package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 5L);
        usuario.setNome("Shoguncio Alterado");

        // em.merge(usuario);   // A alteração do atributo nome foi realizada num CONTEXTO
                                // TRANSACIONAL, ou seja, o objeto USUARIO está no ESTADO GERENCIADO, portanto o
                                // método MERGE não é necessário para que ocorra a alteração no banco de dados

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
