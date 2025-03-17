package com.epf.Persistance;

import com.epf.Core.model.map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class mapDAOImpl implements mapDAO {

    private final JdbcTemplate jdbcTemplate;

    public mapDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(map Map) {
        String sql = "INSERT INTO map ( ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, Map.getLigne(), Map.getColonne(), Map.getChemin_image());
    }

    @Override
    public map read(int id) {
        String sql = "SELECT * FROM map WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new mapRowMapper());
    }

    @Override
    public List<map> readAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, new mapRowMapper());
    }

    @Override
    public void update(map Map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id = ?";
        jdbcTemplate.update(sql, Map.getLigne(), Map.getColonne(), Map.getChemin_image());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM map WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}


