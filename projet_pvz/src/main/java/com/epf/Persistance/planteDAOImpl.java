package com.epf.Persistance;

import com.epf.Core.plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class planteDAOImpl implements planteDAO {

    private final JdbcTemplate jdbcTemplate;

    public planteDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(plante Plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, Plante.getNom(), Plante.getPoint_de_vie(), Plante.getAttaque_par_seconde(), Plante.getDegat_attaque(), Plante.getCout(), Plante.getSoleil_par_seconde(), Plante.getEffet(), Plante.getChemin_image());
    }


    @Override
    public plante read(int id) {
        String sql = "SELECT * FROM plante WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new planteRowMapper());
    }

    @Override
    public List<plante> readAll() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, new planteRowMapper());
    }

    @Override
    public void update(plante Plante) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id = ?";
        jdbcTemplate.update(sql, Plante.getNom(), Plante.getPoint_de_vie(), Plante.getAttaque_par_seconde(), Plante.getDegat_attaque(), Plante.getCout(), Plante.getSoleil_par_seconde(), Plante.getEffet(), Plante.getChemin_image());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM plante WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}

