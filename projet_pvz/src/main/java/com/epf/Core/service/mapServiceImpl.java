package com.epf.Core.service;

import com.epf.Core.model.map;
import com.epf.Persistance.mapDAO;
import com.epf.Persistance.mapDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mapServiceImpl implements mapService {

    // Injection du DAO via Spring
    private final mapDAO MapDAO;

    @Autowired
    public mapServiceImpl(mapDAOImpl MapDAO) {
        this.MapDAO = MapDAO;
    }

    @Override
    public void create(map Map) {
        MapDAO.create(Map);
    }

    @Override
    public map read(int id) {
        return MapDAO.read(id);
    }

    @Override
    public List<map> readAll() {
        return MapDAO.readAll();
    }

    @Override
    public void update(map Map) {
        MapDAO.update(Map);

    }

    @Override
    public void delete(int id) {
        MapDAO.delete(id);
    }
}
