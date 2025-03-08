package br.com.senac.services;

import br.com.senac.entidades.Clientes;
import br.com.senac.repositorios.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes criarCliente(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    public Clientes buscarClientePorId(Long id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);
        return cliente.orElse(null);
    }

    public Clientes atualizarCliente(Long id, Clientes clienteAtualizado) {
        clienteAtualizado.setId(id);
        return clientesRepository.save(clienteAtualizado);
    }

    public boolean excluirCliente(Long id) {
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);
        if (clienteExistente.isPresent()) {
            clientesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
