package teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class ObterFilmes {
    public static void main(String[] args) {
        
        DAO<Filme> dao = new DAO<>(Filme.class);
        List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 9.0);

        for (Filme filme : filmes) {
            System.out.println("\nNome: " + filme.getNome() + "\nNota: " + filme.getNota());

        for (Ator ator : filme.getAtores()) {
            System.out.println(ator.getNome());
        }
        }
    }
}
