package br.com.senac.controller;

import br.com.senac.entidades.Clientes;
import br.com.senac.entidades.Endereco;
import br.com.senac.services.ClientesService;
import br.com.senac.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/listar")
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        List<Endereco> enderecos = enderecoService.listarTodos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/listar/{clienteId}")
    public ResponseEntity<?> listarEnderecosPorCliente(@PathVariable Long clienteId) {
        Clientes cliente = clientesService.buscarClientePorId(clienteId);
        if (cliente == null) {
            return ResponseEntity.status(404).body("Cliente não encontrado.");
        }

        List<Endereco> enderecos = cliente.getEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarEndereco(@RequestBody Endereco endereco) {
        if (endereco.getCliente().getEnderecos().size() >= 3) {
            return ResponseEntity.status(400).body("O cliente já possui 3 endereços cadastrados.");
        }

        Endereco novoEndereco = enderecoService.criarEndereco(endereco);
        return ResponseEntity.status(201).body(novoEndereco);
    }
}
