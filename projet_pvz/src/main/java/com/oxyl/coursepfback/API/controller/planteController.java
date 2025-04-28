package com.oxyl.coursepfback.API.controller;

import com.oxyl.coursepfback.Core.service.planteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oxyl.coursepfback.API.DTO.planteDTO;
import com.oxyl.coursepfback.Core.model.plante;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")
public class planteController {

    private final planteService PlanteService;

    @Autowired
    public planteController(planteService PlanteService) {
        this.PlanteService = PlanteService;
    }

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

    @GetMapping("/{id_plante}")
    public ResponseEntity<planteDTO> read(@PathVariable int id_plante) {
        plante Plante = PlanteService.read(id_plante);
        if (Plante != null) {
            planteDTO PlanteDTO = new planteDTO(Plante.getId_plante(), Plante.getNom(), Plante.getPoint_de_vie(),
                    Plante.getAttaque_par_seconde(), Plante.getDegat_attaque(), Plante.getCout(),
                    Plante.getSoleil_par_seconde(), Plante.getEffet(), Plante.getChemin_image());
            return new ResponseEntity<>(PlanteDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody planteDTO PlanteDTO) {
        plante Plante = new plante(PlanteDTO.getNom(), PlanteDTO.getPoint_de_vie(), PlanteDTO.getAttaque_par_seconde(),
                PlanteDTO.getDegat_attaque(), PlanteDTO.getCout(), PlanteDTO.getSoleil_par_seconde(),
                PlanteDTO.getEffet(), PlanteDTO.getChemin_image());
        PlanteService.create(Plante);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id_plante}")
    public ResponseEntity<Void> update(@PathVariable int id_plante, @RequestBody planteDTO PlanteDTO) {
        plante PlanteExistante = PlanteService.read(id_plante);

        if (PlanteExistante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (PlanteDTO.getNom() != null) PlanteExistante.setNom(PlanteDTO.getNom());
        if (PlanteDTO.getPoint_de_vie() > 0) PlanteExistante.setPoint_de_vie(PlanteDTO.getPoint_de_vie());
        if (PlanteDTO.getAttaque_par_seconde() > 0) PlanteExistante.setAttaque_par_seconde(PlanteDTO.getAttaque_par_seconde());
        if (PlanteDTO.getDegat_attaque() > 0) PlanteExistante.setDegat_attaque(PlanteDTO.getDegat_attaque());
        if (PlanteDTO.getCout() > 0) PlanteExistante.setCout(PlanteDTO.getCout());
        if (PlanteDTO.getSoleil_par_seconde() > 0) PlanteExistante.setSoleil_par_seconde(PlanteDTO.getSoleil_par_seconde());
        if (PlanteDTO.getEffet() != null) PlanteExistante.setEffet(PlanteDTO.getEffet());
        if (PlanteDTO.getChemin_image() != null) PlanteExistante.setChemin_image(PlanteDTO.getChemin_image());

        PlanteService.update(PlanteExistante);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id_plante}")
    public ResponseEntity<Void> delete(@PathVariable int id_plante) {
        PlanteService.delete(id_plante);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

