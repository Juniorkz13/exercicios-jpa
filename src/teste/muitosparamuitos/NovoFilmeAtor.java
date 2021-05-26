package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class NovoFilmeAtor {
    public static void main(String[] args) {

        Filme filme1 = new Filme("Donnie Darko", 10.0);
        Filme filme2 = new Filme("Nightcrawler", 9.3);
        Ator ator1 = new Ator("Jake Gyllenhaal");
        Ator ator2 = new Ator("Maggie Gyllenhaal");

        filme1.adicionarAtor(ator1);
        filme1.adicionarAtor(ator2);
        filme2.adicionarAtor(ator1);

        // Por estar Bidirecional, ao adicionar o FILME1 na tabela, o código também irá
        // ver que o ATOR1 também possui o FILME2 e irá adicionar
        DAO<Filme> dao = new DAO<>();
        dao.incluirCompleto(filme1);

    }
}
