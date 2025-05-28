package spring.boot.apirest.swagger.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.apirest.swagger.api.entity.Cliente;
import spring.boot.apirest.swagger.api.repository.ClienteRepository;

@RestController
@RequestMapping("/pessoas")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repo;

    @GetMapping
    public List<Cliente> listar(){
        return repo.findAll();
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente){
        return repo.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente novoCliente){
        return repo.findById(id).map(p->{
            p.setNome(novoCliente.getNome());
            return repo.save(p);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }
}
