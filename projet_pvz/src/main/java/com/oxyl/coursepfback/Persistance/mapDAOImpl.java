package com.oxyl.coursepfback.Persistance;

import com.oxyl.coursepfback.Core.model.map;
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
    public map read(int id_map) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_map}, new mapRowMapper());
    }

    @Override
    public List<map> readAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, new mapRowMapper());
    }

    @Override
    public void update(map Map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, Map.getLigne(), Map.getColonne(), Map.getChemin_image(), Map.getId_map());
    }

    @Override
    public void delete(int id_map) {
        String sql_zombies = "DELETE FROM zombie WHERE id_map = ?";
        jdbcTemplate.update(sql_zombies, id_map);
        String sql_map = "DELETE FROM map WHERE id_map = ?";
        jdbcTemplate.update(sql_map, id_map);
    }
}


