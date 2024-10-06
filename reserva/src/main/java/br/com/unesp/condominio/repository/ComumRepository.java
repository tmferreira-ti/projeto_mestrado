package br.com.unesp.condominio.repository;

import br.com.unesp.condominio.model.Comum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComumRepository extends JpaRepository<Comum, Integer> {
    // Podemos adicionar métodos customizados aqui, se necessário
}
