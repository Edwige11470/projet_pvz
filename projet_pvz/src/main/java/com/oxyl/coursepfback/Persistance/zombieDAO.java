package com.oxyl.coursepfback.Persistance;

import com.oxyl.coursepfback.Core.model.zombie;
import java.util.List;

public interface zombieDAO {

    void create(zombie Zombie);
    zombie read(int id_zombie);
    List<zombie> readAll();
    void update(zombie Zombie);
    void delete(int id_zombie);

    List<zombie> findZombiesByMap(int id_map);
}
