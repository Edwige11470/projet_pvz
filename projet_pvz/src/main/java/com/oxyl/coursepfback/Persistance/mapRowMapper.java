package com.oxyl.coursepfback.Persistance;

import com.oxyl.coursepfback.Core.model.map;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class mapRowMapper implements RowMapper<map> {
    @Override
    public map mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new map(
                rs.getInt("id_map"),
                rs.getInt("ligne"),
                rs.getInt("colonne"),
                rs.getString("chemin_image")
        );
    }
}
