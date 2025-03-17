package com.epf.Core.service;

import com.epf.Core.model.map;

import java.util.List;

public interface mapService {
    void create(map Map);
    map read(int id);
    List<map> readAll();
    void update(map Map);
    void delete(int id);
}
