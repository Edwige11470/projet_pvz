package com.oxyl.coursepfback.Persistance;

import com.oxyl.coursepfback.Core.model.plante;
import com.oxyl.coursepfback.Core.model.Effet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class planteRowMapper implements RowMapper<plante> {
    @Override
    public plante mapRow(ResultSet rs, int rowNum) throws SQLException {
        String effetString = rs.getString("effet");
        Effet effet = Effet.valueOf(effetString.toUpperCase().replace(' ', '_'));

        return new plante(
                rs.getInt("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getDouble("soleil_par_seconde"),
                effet,
                rs.getString("chemin_image")
        );
    }
}
