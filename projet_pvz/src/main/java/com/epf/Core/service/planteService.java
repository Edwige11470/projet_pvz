package com.epf.Core.service;

import com.epf.Core.model.plante;

import java.util.List;

public interface planteService {
    void create(plante Plante);
    plante read(int id);
    List<plante> readAll();
    void update(plante Plante);
    void delete(int id);
}
