package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Uma tabela por classe
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Estratégia padrão, junta tudo em uma única tabela, necessita de discriminar qual o tipo de cada classe
@Inheritance(strategy = InheritanceType.JOINED) // Cria a tabela com atributos comuns e uma tabela com atributos caracteristicos, também necessita discrimar igual a SINGLE
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AC")
public class Aluno {

    @Id
    private Long matricula;
    private String nome;

    public Aluno() {
    }

    public Aluno(Long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Long getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
