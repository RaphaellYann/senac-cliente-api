package br.com.senac.controllers;

import br.com.senac.entidades.Clientes;
import br.com.senac.servicos.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> carregarClientes() {
        try {
            List<Clientes> clientes = clientesService.carregarClientes();
            return ResponseEntity.ok(clientes);
        } catch (RuntimeException e) {
            return ResponseEntity.status(204).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Clientes> criarCliente(@RequestBody Clientes cliente) {
        try {
            Clientes clienteCriado = clientesService.criarCliente(cliente);
            return ResponseEntity.ok(clienteCriado);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Clientes> atualizarCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        try {
            Clientes clienteAtualizado = clientesService.atualizarCliente(id, cliente);
            return ResponseEntity.ok(clienteAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);  // Cliente não encontrado
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        try {
            clientesService.excluirCliente(id);
            return ResponseEntity.ok(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);  // Cliente não encontrado
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }
}
