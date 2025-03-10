package com.epf.Persistance;

import com.epf.Core.zombie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class zombieRowMapper implements RowMapper<zombie> {
    @Override
    public zombie mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new zombie(
                rs.getInt("id_map"),      // Récupère l'id_map de la ligne
                rs.getInt("ligne"),       // Récupère la ligne de la table
                rs.getInt("colonne"),     // Récupère la colonne de la table
                rs.getString("chemin_image") // Récupère le chemin de l'image
        );
    }
}
