package spring.boot.apirest.swagger.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.apirest.swagger.api.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
