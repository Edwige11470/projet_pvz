package com.epf.API.controller;

import com.epf.API.DTO.mapDTO;
import com.epf.Core.model.map;
import com.epf.Core.service.mapService;
import com.epf.Core.service.mapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/maps")
public class mapController {

    private final mapService MapService;

    @Autowired
    public mapController(mapServiceImpl MapService) {
        this.MapService = MapService;
    }

    // Récupérer toutes les maps
    @GetMapping
    public ResponseEntity<List<mapDTO>> readAll() {
        List<map> maps = mapService.readAll();
        List<mapDTO> mapDTOs = maps.stream()
                .map(map -> new mapDTO(map.getIdMap(), map.getLigne(), map.getColonne(), map.getCheminImage()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(mapDTOs, HttpStatus.OK);
    }

    // Récupérer une carte par ID
    @GetMapping("/{id}")
    public ResponseEntity<MapDTO> getMapById(@PathVariable int id) {
        Map map = mapService.getMapById(id);
        if (map != null) {
            MapDTO mapDTO = new MapDTO(map.getIdMap(), map.getLigne(), map.getColonne(), map.getCheminImage());
            return new ResponseEntity<>(mapDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Map non trouvée
    }

    // Ajouter une nouvelle carte
    @PostMapping
    public ResponseEntity<Void> addMap(@RequestBody MapDTO mapDTO) {
        Map map = new Map(mapDTO.getIdMap(), mapDTO.getLigne(), mapDTO.getColonne(), mapDTO.getCheminImage());
        mapService.addMap(map);
        return new ResponseEntity<>(HttpStatus.CREATED);  // Code 201 : Map créée
    }

    // Mettre à jour une carte
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMap(@PathVariable int id, @RequestBody MapDTO mapDTO) {
        Map map = new Map(id, mapDTO.getLigne(), mapDTO.getColonne(), mapDTO.getCheminImage());
        mapService.updateMap(map);
        return new ResponseEntity<>(HttpStatus.OK);  // Code 200 : Map mise à jour
    }

    // Supprimer une carte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable int id) {
        mapService.deleteMap(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Code 204 : Map supprimée
    }
}
