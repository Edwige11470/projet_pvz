package com.oxyl.coursepfback.Persistance;

import com.oxyl.coursepfback.Core.model.zombie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class zombieRowMapper implements RowMapper<zombie> {
    @Override
    public zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new zombie(
                rs.getInt("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getDouble("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map")
                );
    }
}
