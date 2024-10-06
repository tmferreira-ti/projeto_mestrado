package br.com.unesp.condominio.repository;

import br.com.unesp.condominio.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // Podemos adicionar métodos customizados aqui, se necessário
}
