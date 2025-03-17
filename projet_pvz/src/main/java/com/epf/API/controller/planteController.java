package com.epf.API.controller;

import com.epf.Core.service.planteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epf.API.DTO.planteDTO;
import com.epf.Core.model.plante;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plantes")
public class planteController {

    private final planteService PlanteService;

    @Autowired
    public planteController(planteService PlanteService) {
        this.PlanteService = PlanteService;
    }

    // Récupérer toutes les plantes
    @GetMapping
    public ResponseEntity<List<planteDTO>> readAll() {
        List<plante> Plantes = PlanteService.readAll();
        List<planteDTO> PlantesDTO = Plantes.stream()
                .map(Plante -> new planteDTO(Plante.getId_plante(), Plante.getNom(), Plante.getPoint_de_vie(),
                        Plante.getAttaque_par_seconde(), Plante.getDegat_attaque(), Plante.getCout(),
                        Plante.getSoleil_par_seconde(), Plante.getEffet(), Plante.getChemin_image()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(PlantesDTO, HttpStatus.OK);
    }

    // Récupérer une plante par ID
    @GetMapping("/{id}")
    public ResponseEntity<planteDTO> read(@PathVariable int id) {
        plante Plante = PlanteService.read(id);
        if (Plante != null) {
            planteDTO PlanteDTO = new planteDTO(Plante.getId_plante(), Plante.getNom(), Plante.getPoint_de_vie(),
                    Plante.getAttaque_par_seconde(), Plante.getDegat_attaque(), Plante.getCout(),
                    Plante.getSoleil_par_seconde(), Plante.getEffet(), Plante.getChemin_image());
            return new ResponseEntity<>(PlanteDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Plante non trouvée
    }

    // Ajouter une nouvelle plante
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody planteDTO PlanteDTO) {
        plante Plante = new plante(PlanteDTO.getNom(), PlanteDTO.getPoint_de_vie(), PlanteDTO.getAttaque_par_seconde(),
                PlanteDTO.getDegat_attaque(), PlanteDTO.getCout(), PlanteDTO.getSoleil_par_seconde(),
                PlanteDTO.getEffet(), PlanteDTO.getChemin_image());
        PlanteService.create(Plante);
        return new ResponseEntity<>(HttpStatus.CREATED);  // Code 201 : Plante créée
    }

    // Mettre à jour une plante
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody planteDTO PlanteDTO) {
        plante Plante = new plante(id, PlanteDTO.getNom(), PlanteDTO.getPoint_de_vie(), PlanteDTO.getAttaque_par_seconde(),
                PlanteDTO.getDegat_attaque(), PlanteDTO.getCout(), PlanteDTO.getSoleil_par_seconde(),
                PlanteDTO.getEffet(), PlanteDTO.getChemin_image());
        PlanteService.update(Plante);
        return new ResponseEntity<>(HttpStatus.OK);  // Code 200 : Plante mise à jour
    }

    // Supprimer une plante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        PlanteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Code 204 : Plante supprimée
    }
}

