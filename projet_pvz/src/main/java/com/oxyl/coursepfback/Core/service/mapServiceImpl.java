package com.oxyl.coursepfback.Core.service;

import com.oxyl.coursepfback.Core.model.map;
import com.oxyl.coursepfback.Persistance.mapDAO;
import com.oxyl.coursepfback.Persistance.mapDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mapServiceImpl implements mapService {

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
    public map read(int id_map) {
        return MapDAO.read(id_map);
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
    public void delete(int id_map) {
        MapDAO.delete(id_map);
    }
}
