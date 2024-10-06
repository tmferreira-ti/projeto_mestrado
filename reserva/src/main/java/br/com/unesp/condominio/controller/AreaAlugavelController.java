package br.com.unesp.condominio.controller;

import br.com.unesp.condominio.model.AreaAlugavel;
import br.com.unesp.condominio.repository.AreaAlugavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/areas-alugaveis")
public class AreaAlugavelController {

    private final AreaAlugavelRepository areaAlugavelRepository;

    @Autowired
    public AreaAlugavelController(AreaAlugavelRepository areaAlugavelRepository) {
        this.areaAlugavelRepository = areaAlugavelRepository;
    }

    // Método para listar todas as áreas alugáveis
    @GetMapping
    public List<AreaAlugavel> getAllAreasAlugaveis() {
        return areaAlugavelRepository.findAll();
    }

    // Método para buscar uma área alugável por ID
    @GetMapping("/{id}")
    public ResponseEntity<AreaAlugavel> getAreaAlugavelById(@PathVariable int id) {
        Optional<AreaAlugavel> areaAlugavel = areaAlugavelRepository.findById(id);
        return areaAlugavel.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para criar uma nova área alugável
    @PostMapping
    public AreaAlugavel createAreaAlugavel(@RequestBody AreaAlugavel areaAlugavel) {
        return areaAlugavelRepository.save(areaAlugavel);
    }

    // Método para atualizar uma área alugável
    @PutMapping("/{id}")
    public ResponseEntity<AreaAlugavel> updateAreaAlugavel(@PathVariable int id, @RequestBody AreaAlugavel areaAlugavelDetails) {
        Optional<AreaAlugavel> optionalAreaAlugavel = areaAlugavelRepository.findById(id);
        if (optionalAreaAlugavel.isPresent()) {
            AreaAlugavel areaAlugavel = optionalAreaAlugavel.get();
            areaAlugavel.setLimitePessoas(areaAlugavelDetails.getLimitePessoas());
            areaAlugavel.setDisponivel(areaAlugavelDetails.isDisponivel());
            areaAlugavel.setDisponivelDe(areaAlugavelDetails.getDisponivelDe());
            areaAlugavel.setDisponivelAte(areaAlugavelDetails.getDisponivelAte());
            return ResponseEntity.ok(areaAlugavelRepository.save(areaAlugavel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar uma área alugável
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAreaAlugavel(@PathVariable int id) {
        if (areaAlugavelRepository.existsById(id)) {
            areaAlugavelRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
