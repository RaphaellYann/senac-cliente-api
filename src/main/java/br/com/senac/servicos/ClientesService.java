package br.com.senac.servicos;

import br.com.senac.entidades.Clientes;
import br.com.senac.repositorios.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> carregarClientes() {
        List<Clientes> clientes = clientesRepository.findAll();
        if (clientes.isEmpty()) {
            throw new RuntimeException("Nenhum cliente encontrado!");
        }
        return clientes;
    }

    public Clientes criarCliente(Clientes cliente) {
        if (cliente.getDocumento() == null || cliente.getNome() == null || cliente.getSobrenome() == null || cliente.getEmail() == null) {
            throw new RuntimeException("Documento, nome, sobrenome e email são obrigatórios!");
        }
        return clientesRepository.save(cliente);
    }

    public Clientes atualizarCliente(Long id, Clientes cliente) {
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);
        if (!clienteExistente.isPresent()) {
            throw new RuntimeException("Cliente não encontrado!");
        }

        cliente.setId(id);
        return clientesRepository.save(cliente);
    }

    public void excluirCliente(Long id) {
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);
        if (!clienteExistente.isPresent()) {
            throw new RuntimeException("Cliente não encontrado!");
        }
        clientesRepository.deleteById(id);
    }

    public Clientes carregarClientePorId(Long id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);
        if (!cliente.isPresent()) {
            throw new RuntimeException("Cliente não encontrado!");
        }
        return cliente.get();
    }
}
