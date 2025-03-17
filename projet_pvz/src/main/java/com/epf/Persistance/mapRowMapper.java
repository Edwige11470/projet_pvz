package com.epf.Persistance;

import com.epf.Core.model.map;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class mapRowMapper implements RowMapper<map> {
    @Override
    public map mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new map(
                rs.getInt("id_map"),      // Récupère l'id_map de la ligne
                rs.getInt("ligne"),       // Récupère la ligne de la table
                rs.getInt("colonne"),     // Récupère la colonne de la table
                rs.getString("chemin_image") // Récupère le chemin de l'image
        );
    }
}
