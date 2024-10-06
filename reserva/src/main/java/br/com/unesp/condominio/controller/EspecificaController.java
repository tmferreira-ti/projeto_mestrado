package br.com.unesp.condominio.controller;

import br.com.unesp.condominio.model.Especifica;
import br.com.unesp.condominio.repository.EspecificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especificas")
public class EspecificaController {

    @Autowired
    private EspecificaRepository especificaRepository;

    // Método para listar todas as áreas específicas
    @GetMapping
    public List<Especifica> getAllEspecificas() {
        return especificaRepository.findAll();
    }

    // Método para buscar uma área específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<Especifica> getEspecificaById(@PathVariable int id) {
        Optional<Especifica> especifica = especificaRepository.findById(id);
        return especifica.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para criar uma nova área específica
    @PostMapping
    public Especifica createEspecifica(@RequestBody Especifica especifica) {
        return especificaRepository.save(especifica);
    }

    // Método para atualizar uma área específica
    @PutMapping("/{id}")
    public ResponseEntity<Especifica> updateEspecifica(@PathVariable int id, @RequestBody Especifica especificaDetails) {
        Optional<Especifica> optionalEspecifica = especificaRepository.findById(id);
        if (optionalEspecifica.isPresent()) {
            Especifica especifica = optionalEspecifica.get();
            especifica.setDescricao(especificaDetails.getDescricao());
            return ResponseEntity.ok(especificaRepository.save(especifica));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar uma área específica
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecifica(@PathVariable int id) {
        if (especificaRepository.existsById(id)) {
            especificaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
