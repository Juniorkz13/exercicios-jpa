package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {
    public static void main(String[] args) {
        
        DAO<Aluno> dao = new DAO<>();

        Aluno aluno = new Aluno(123L, "Júnior");
        AlunoBolsista alunoBolsista = new AlunoBolsista(321L, "João", 1000);
        
        dao.incluirCompleto(aluno).incluirCompleto(alunoBolsista).fechar();
    }
}
