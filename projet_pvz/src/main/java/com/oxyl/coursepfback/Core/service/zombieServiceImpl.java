package com.oxyl.coursepfback.Core.service;

import com.oxyl.coursepfback.Core.model.zombie;
import com.oxyl.coursepfback.Persistance.zombieDAO;
import com.oxyl.coursepfback.Persistance.zombieDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class zombieServiceImpl implements zombieService {

    private final zombieDAO ZombieDAO;

    @Autowired
    public zombieServiceImpl(zombieDAOImpl ZombieDAO) {
        this.ZombieDAO = ZombieDAO;
    }

    @Override
    public void create(zombie Zombie) {
        ZombieDAO.create(Zombie);
    }

    @Override
    public zombie read(int id_zombie) {
        return ZombieDAO.read(id_zombie);
    }

    @Override
    public List<zombie> readAll() {
        return ZombieDAO.readAll();
    }

    @Override
    public void update(zombie Zombie) {
        ZombieDAO.update(Zombie);

    }

    @Override
    public void delete(int id_zombie) {
        ZombieDAO.delete(id_zombie);
    }

    @Override
    public List<zombie>  findZombiesByMap(int id_map){
        return ZombieDAO.findZombiesByMap(id_map);
    }
}
