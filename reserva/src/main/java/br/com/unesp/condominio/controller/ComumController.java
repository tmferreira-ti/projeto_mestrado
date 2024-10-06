package br.com.unesp.condominio.controller;

import br.com.unesp.condominio.model.Comum;
import br.com.unesp.condominio.repository.ComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comuns")
public class ComumController {

    @Autowired
    private ComumRepository comumRepository;

    // Método para listar todas as áreas comuns
    @GetMapping
    public List<Comum> getAllComuns() {
        return comumRepository.findAll();
    }

    // Método para buscar uma área comum por ID
    @GetMapping("/{id}")
    public ResponseEntity<Comum> getComumById(@PathVariable int id) {
        Optional<Comum> comum = comumRepository.findById(id);
        return comum.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para criar uma nova área comum
    @PostMapping
    public Comum createComum(@RequestBody Comum comum) {
        return comumRepository.save(comum);
    }

    // Método para atualizar uma área comum
    @PutMapping("/{id}")
    public ResponseEntity<Comum> updateComum(@PathVariable int id, @RequestBody Comum comumDetails) {
        Optional<Comum> optionalComum = comumRepository.findById(id);
        if (optionalComum.isPresent()) {
            Comum comum = optionalComum.get();
            comum.setLocalizacao(comumDetails.getLocalizacao());
            return ResponseEntity.ok(comumRepository.save(comum));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar uma área comum
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComum(@PathVariable int id) {
        if (comumRepository.existsById(id)) {
            comumRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
