package com.epf.Persistance;

import com.epf.Core.map;

import java.util.List;

public interface mapDAO {

    void create(map Map);
    map read(int id);
    List<map> readAll();
    void update(map Map);
    void delete(int id);
}


