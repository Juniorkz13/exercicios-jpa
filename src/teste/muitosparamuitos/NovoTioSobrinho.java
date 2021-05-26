package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Sobrinho;
import modelo.muitosparamuitos.Tio;

public class NovoTioSobrinho {
    public static void main(String[] args) {

        Tio tio1 = new Tio("Magui");
        Tio tio2 = new Tio("Fausto");
        Sobrinho sobrinho1 = new Sobrinho("Júnior");
        Sobrinho sobrinho2 = new Sobrinho("Daniela");

        // mantendo a consistencia do bidirecional, o que é adicionado em um tem que ser
        // adicionado em outro
        tio1.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio1);
        tio1.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio1);
        tio2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio2);
        tio2.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio2);

        DAO<Object> dao = new DAO<>();
        dao.abrirT().incluir(tio1).incluir(tio2).incluir(sobrinho1).incluir(sobrinho2).fecharT().fechar();

    }
}
