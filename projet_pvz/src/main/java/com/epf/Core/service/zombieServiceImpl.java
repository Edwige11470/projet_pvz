package com.epf.Core.service;

import com.epf.Core.model.zombie;
import com.epf.Persistance.zombieDAO;
import com.epf.Persistance.zombieDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class zombieServiceImpl implements zombieService {

    // Injection du DAO via Spring
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
    public zombie read(int id) {
        return ZombieDAO.read(id);
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
    public void delete(int id) {
        ZombieDAO.delete(id);
    }

    @Override
    public List<zombie>  findZombiesByMap(int mapId){
        return ZombieDAO.findZombiesByMap(mapId);
    }
}
