package br.com.senac.services;

import br.com.senac.entidades.Endereco;
import br.com.senac.repositorios.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
