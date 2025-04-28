package com.oxyl.coursepfback.API.controller;

import com.oxyl.coursepfback.API.DTO.mapDTO;
import com.oxyl.coursepfback.Core.model.map;
import com.oxyl.coursepfback.Core.model.plante;
import com.oxyl.coursepfback.Core.service.mapService;
import com.oxyl.coursepfback.Core.service.mapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maps")
public class mapController {

    private final mapService MapService;

    @Autowired
    public mapController(mapServiceImpl MapService) {
        this.MapService = MapService;
    }

    @GetMapping
    public ResponseEntity<List<mapDTO>> readAll() {
        List<map> Maps = MapService.readAll();
        List<mapDTO> MapDTOs = Maps.stream()
                .map(Map -> new mapDTO(Map.getId_map(), Map.getLigne(), Map.getColonne(), Map.getChemin_image()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(MapDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id_map}")
    public ResponseEntity<mapDTO> getMapById(@PathVariable int id_map) {
        map Map = MapService.read(id_map);
        if (Map != null) {
            mapDTO MapDTO = new mapDTO(Map.getId_map(), Map.getLigne(), Map.getColonne(), Map.getChemin_image());
            return new ResponseEntity<>(MapDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> addMap(@RequestBody mapDTO MapDTO) {
        map Map = new map(MapDTO.getId_map(), MapDTO.getLigne(), MapDTO.getColonne(), MapDTO.getChemin_image());
        MapService.create(Map);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id_map}")
    public ResponseEntity<Void> updateMap(@PathVariable int id_map, @RequestBody mapDTO MapDTO) {
        map Map = new map(id_map, MapDTO.getLigne(), MapDTO.getColonne(), MapDTO.getChemin_image());
        MapService.update(Map);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id_map}")
    public ResponseEntity<Void> deleteMap(@PathVariable int id_map) {
        MapService.delete(id_map);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
