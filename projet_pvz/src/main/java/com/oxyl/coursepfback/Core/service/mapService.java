package com.oxyl.coursepfback.Core.service;

import com.oxyl.coursepfback.Core.model.map;

import java.util.List;

public interface mapService {
    void create(map Map);
    map read(int id_map);
    List<map> readAll();
    void update(map Map);
    void delete(int id_map);
}
