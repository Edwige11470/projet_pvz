package com.oxyl.coursepfback.API.controller;

import com.oxyl.coursepfback.Core.service.zombieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oxyl.coursepfback.API.DTO.zombieDTO;
import com.oxyl.coursepfback.Core.model.zombie;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zombies")
public class zombieController {

    private final zombieService ZombieService;

    @Autowired
    public zombieController(zombieService ZombieService) {
        this.ZombieService = ZombieService;
    }

    @GetMapping
    public ResponseEntity<List<zombieDTO>> readAll() {
        List<zombie> Zombies = ZombieService.readAll();
        List<zombieDTO> ZombiesDTO = Zombies.stream()
                .map(Zombie -> new zombieDTO(Zombie.getId_zombie(), Zombie.getNom(), Zombie.getPoint_de_vie(),
                        Zombie.getAttaque_par_seconde(), Zombie.getDegat_attaque(), Zombie.getVitesse_de_deplacement(),
                        Zombie.getChemin_image(), Zombie.getId_map()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(ZombiesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id_zombie}")
    public ResponseEntity<zombieDTO> read(@PathVariable int id_zombie) {
        zombie Zombie = ZombieService.read(id_zombie);
        if (Zombie != null) {
            zombieDTO ZombieDTO = new zombieDTO(Zombie.getId_zombie(), Zombie.getNom(), Zombie.getPoint_de_vie(),
                    Zombie.getAttaque_par_seconde(), Zombie.getDegat_attaque(), Zombie.getVitesse_de_deplacement(),
                    Zombie.getChemin_image(), Zombie.getId_map());
            return new ResponseEntity<>(ZombieDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id_map}")
    public ResponseEntity<List<zombieDTO>> findZombiesByMap(@PathVariable int id_map) {
        List<zombie> Zombies = ZombieService.findZombiesByMap(id_map);
        if (Zombies != null) {
            List<zombieDTO> ZombiesDTO = Zombies.stream()
                    .map(Zombie -> new zombieDTO(Zombie.getId_zombie(), Zombie.getNom(), Zombie.getPoint_de_vie(),
                            Zombie.getAttaque_par_seconde(), Zombie.getDegat_attaque(), Zombie.getVitesse_de_deplacement(),
                            Zombie.getChemin_image(), Zombie.getId_map()))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(ZombiesDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody zombieDTO ZombieDTO) {
        zombie Zombie = new zombie(ZombieDTO.getNom(), ZombieDTO.getPoint_de_vie(), ZombieDTO.getAttaque_par_seconde(),
                ZombieDTO.getDegat_attaque(), ZombieDTO.getVitesse_de_deplacement(), ZombieDTO.getChemin_image(),
                ZombieDTO.getId_map());
        ZombieService.create(Zombie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id_zombie}")
    public ResponseEntity<Void> update(@PathVariable int id_zombie, @RequestBody zombieDTO ZombieDTO) {
        zombie Zombie = new zombie(id_zombie, ZombieDTO.getNom(), ZombieDTO.getPoint_de_vie(), ZombieDTO.getAttaque_par_seconde(),
                ZombieDTO.getDegat_attaque(), ZombieDTO.getVitesse_de_deplacement(), ZombieDTO.getChemin_image(),
                ZombieDTO.getId_map());
        ZombieService.update(Zombie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id_zombie}")
    public ResponseEntity<Void> delete(@PathVariable int id_zombie) {
        ZombieService.delete(id_zombie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

