package com.oxyl.coursepfback.Core.service;

import com.oxyl.coursepfback.Core.model.plante;

import java.util.List;

public interface planteService {
    void create(plante Plante);
    plante read(int id_plante);
    List<plante> readAll();
    void update(plante Plante);
    void delete(int id_plante);
}
