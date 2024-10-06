package br.com.unesp.condominio.repository;

import br.com.unesp.condominio.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Integer> {
    // Podemos adicionar métodos customizados aqui, se necessário
}
