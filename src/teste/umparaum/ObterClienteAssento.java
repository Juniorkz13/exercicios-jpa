package teste.umparaum;

import infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class ObterClienteAssento {
    public static void main(String[] args) {

        // Mostrando a relação bidirecional, onde é possível recuperar os dados tanto a partir do CLIENTE quanto a partir do ASSENTO
        
        DAO<Cliente> daoCliente = new DAO<>(Cliente.class);

        Cliente cliente = daoCliente.obterPorID(1L);
        System.out.println(cliente.getAssento().getNome());
        System.out.println(cliente.getAssento().getCliente().getNome());
        daoCliente.fechar();

        DAO<Assento> daoAssento = new DAO<>(Assento.class);

        Assento assento = daoAssento.obterPorID(1L);
        System.out.println(assento.getCliente().getNome());
        daoAssento.fechar();
    }
}
