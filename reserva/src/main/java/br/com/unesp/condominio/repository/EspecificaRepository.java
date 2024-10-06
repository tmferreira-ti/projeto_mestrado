package br.com.unesp.condominio.repository;

import br.com.unesp.condominio.model.Especifica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecificaRepository extends JpaRepository<Especifica, Integer> {
    // Podemos adicionar métodos customizados aqui, se necessário
}
