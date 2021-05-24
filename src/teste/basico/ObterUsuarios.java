package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        String jpql = "select u from Usuario u"; // Está consultando a ENTIDADE(classe), e não a TABELA
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setMaxResults(3); // Define o máximo de retornos a serem obtidos

        // A consulta acima pode ser escrita de forma mais concatenada em apenas uma linha
        // List<Usuario> usuarios = em.createQuery("select u from Usuario u", Usuario.class).setMaxResults(3).getResultList(); 

        List<Usuario> usuarios = query.getResultList();
        
        for (Usuario usuario : usuarios) {
            System.out.println("\nID: " + usuario.getId() + "\nE-mail: " + usuario.getEmail() + "\nNome: "
                    + usuario.getNome() + "\n-----------");
        }

        em.close();
        emf.close();
    }
}
