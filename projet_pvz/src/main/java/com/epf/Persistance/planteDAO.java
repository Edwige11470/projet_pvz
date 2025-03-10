package com.epf.Persistance;

import com.epf.Core.plante;

import java.util.List;

public interface planteDAO {

    void create(plante Plante);
    plante read(int id);
    List<plante> readAll();
    void update(plante Plante);
    void delete(int id);
}
