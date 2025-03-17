package com.epf.Core.service;

import com.epf.Core.model.plante;
import com.epf.Core.model.zombie;

import java.util.List;

public interface zombieService {
    void create(zombie Zombie);
    zombie read(int id);
    List<zombie> readAll();
    void update(zombie Zombie);
    void delete(int id);

    // Méthode pour récupérer les zombies associés à une carte spécifique
    List<zombie> findZombiesByMap(int mapId);
}
