package br.com.senac.controller;

import br.com.senac.entidades.Clientes;
import br.com.senac.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @PostMapping("/criar")
    public ResponseEntity<Clientes> criarCliente(@RequestBody Clientes cliente) {
        Clientes novoCliente = clientesService.criarCliente(cliente);
        return ResponseEntity.status(201).body(novoCliente);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody Clientes clienteAtualizado) {
        Clientes clienteExistente = clientesService.buscarClientePorId(id);
        if (clienteExistente == null) {
            return ResponseEntity.status(404).body("Cliente não encontrado.");
        }
        clienteAtualizado.setId(id);
        Clientes clienteSalvo = clientesService.atualizarCliente(id, clienteAtualizado);
        return ResponseEntity.status(200).body(clienteSalvo);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        boolean clienteExcluido = clientesService.excluirCliente(id);
        if (!clienteExcluido) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> carregarClientesById(@PathVariable Long id) {
        Clientes result = clientesService.buscarClientePorId(id);
        if (result != null) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.status(404).body("Cliente não encontrado.");
    }
}
