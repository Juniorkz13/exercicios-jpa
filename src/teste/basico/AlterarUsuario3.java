package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 5L);

        em.detach(usuario); // Método para disassociar a ENTIDADE do ESTADO GERENCIADO, obrigando o uso do MERGE para atualizar o banco de dados.

        usuario.setNome("Shoguncio");

        em.merge(usuario); // MERGE é o comando para fazer a atualização

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
