package br.com.unesp.condominio.repository;

import br.com.unesp.condominio.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    // Podemos adicionar métodos customizados aqui, se necessário
}
