package com.oxyl.coursepfback.Core.service;

import com.oxyl.coursepfback.Core.model.zombie;

import java.util.List;

public interface zombieService {
    void create(zombie Zombie);
    zombie read(int id_zombie);
    List<zombie> readAll();
    void update(zombie Zombie);
    void delete(int id_zombie);

    // Méthode pour récupérer les zombies associés à une carte spécifique
    List<zombie> findZombiesByMap(int id_map);
}
