package com.epf.Persistance;

import com.epf.Core.zombie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class zombieDAOImpl implements zombieDAO {

    private final JdbcTemplate jdbcTemplate;

    public zombieDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(zombie Zombie) {
        String sql = "INSERT INTO zombies (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, Zombie.getNom(), Zombie.getPoint_de_vie(), Zombie.getAttaque_par_seconde(), Zombie.getDegat_attaque(), Zombie.getVitesse_de_deplacement(), Zombie.getChemin_image(), Zombie.getId_map());
    }


    @Override
    public zombie read(int id) {
        String sql = "SELECT * FROM zombies WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new zombieRowMapper());
    }

    @Override
    public List<zombie> readAll() {
        String sql = "SELECT * FROM zombies";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    @Override
    public void update(zombie Zombie) {
        String sql = "UPDATE zombies SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id = ?";
        jdbcTemplate.update(sql, Zombie.getNom(), Zombie.getPoint_de_vie(), Zombie.getAttaque_par_seconde(), Zombie.getDegat_attaque(), Zombie.getVitesse_de_deplacement(), Zombie.getChemin_image(), Zombie.getId_map());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM zombies WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<zombie> findZombiesByMap(int idMap) {
        String sql = "SELECT * FROM zombies WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{idMap}, new zombieRowMapper());
    }
}

