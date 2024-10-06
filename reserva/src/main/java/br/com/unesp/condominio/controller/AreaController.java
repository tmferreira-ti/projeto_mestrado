package br.com.unesp.condominio.controller;

import br.com.unesp.condominio.model.Area;
import br.com.unesp.condominio.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    @Autowired
    private AreaRepository areaRepository;

    // Método para listar todas as áreas
    @GetMapping
    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    // Método para buscar uma área por ID
    @GetMapping("/{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable int id) {
        Optional<Area> area = areaRepository.findById(id);
        return area.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para criar uma nova área
    @PostMapping
    public Area createArea(@RequestBody Area area) {
        return areaRepository.save(area);
    }

    // Método para atualizar uma área
    @PutMapping("/{id}")
    public ResponseEntity<Area> updateArea(@PathVariable int id, @RequestBody Area areaDetails) {
        Optional<Area> optionalArea = areaRepository.findById(id);
        if (optionalArea.isPresent()) {
            Area area = optionalArea.get();
            area.setNome(areaDetails.getNome());
            area.setDescricao(areaDetails.getDescricao());
            area.setTamanhoMetroQuadrado(areaDetails.getTamanhoMetroQuadrado());
            area.setUtilizavel(areaDetails.isUtilizavel());
            return ResponseEntity.ok(areaRepository.save(area));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar uma área
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable int id) {
        if (areaRepository.existsById(id)) {
            areaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
