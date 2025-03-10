package com.epf.Persistance;

import com.epf.Core.zombie;
import java.util.List;

public interface zombieDAO {

    void create(zombie Zombie);
    zombie read(int id);
    List<zombie> readAll();
    void update(zombie Zombie);
    void delete(int id);

    // Méthode pour récupérer les zombies associés à une carte spécifique
    List<zombie> findZombiesByMap(int mapId);
}
