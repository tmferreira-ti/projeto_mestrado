package br.com.unesp.condominio.controller;

import br.com.unesp.condominio.model.Morador;
import br.com.unesp.condominio.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moradores")
public class MoradorController {

    @Autowired
    private MoradorRepository moradorRepository;

    // Método para listar todos os moradores
    @GetMapping
    public List<Morador> getAllMoradores() {
        return moradorRepository.findAll();
    }

    // Método para buscar um morador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Morador> getMoradorById(@PathVariable int id) {
        Optional<Morador> morador = moradorRepository.findById(id);
        return morador.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para criar um novo morador
    @PostMapping
    public Morador createMorador(@RequestBody Morador morador) {
        return moradorRepository.save(morador);
    }


    // Método para atualizar um morador
    @PutMapping("/{id}")
    public ResponseEntity<Morador> updateMorador(@PathVariable int id, @RequestBody Morador moradorDetails) {
        Optional<Morador> optionalMorador = moradorRepository.findById(id);
        if (optionalMorador.isPresent()) {
            Morador morador = optionalMorador.get();
            morador.setMoradorTipo(moradorDetails.getMoradorTipo());
            return ResponseEntity.ok(moradorRepository.save(morador));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar um morador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMorador(@PathVariable int id) {
        if (moradorRepository.existsById(id)) {
            moradorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
