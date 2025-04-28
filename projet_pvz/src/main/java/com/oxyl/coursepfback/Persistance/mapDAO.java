package com.oxyl.coursepfback.Persistance;

import com.oxyl.coursepfback.Core.model.map;

import java.util.List;

public interface mapDAO {

    void create(map Map);
    map read(int id_map);
    List<map> readAll();
    void update(map Map);
    void delete(int id_map);
}


