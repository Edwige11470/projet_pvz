package com.oxyl.coursepfback.Persistance;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import com.oxyl.coursepfback.Core.model.Effet;
import com.oxyl.coursepfback.Core.model.plante;
import com.oxyl.coursepfback.Core.model.zombie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class zombieDAOTest {

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private zombieDAOImpl ZombieDAO;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(dataSource.getConnection()).thenReturn(connection);
    }

    @Test
    void testFindById() throws Exception {
        zombie expectedZombie = new zombie(4, "Runner Zombie", 80, 1.0, 8, 0.7, "images/zombie/runner.png", 2);

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id_zombie")).thenReturn(4);
        when(resultSet.getString("nom")).thenReturn("Runner Zombie");
        when(resultSet.getInt("point_de_vie")).thenReturn(80);
        when(resultSet.getDouble("attaque_par_seconde")).thenReturn(1.0);
        when(resultSet.getInt("degat_attaque")).thenReturn(8);
        when(resultSet.getDouble("vitesse_de_deplacement")).thenReturn(0.7);
        when(resultSet.getString("chemin_image")).thenReturn("images/zombie/runner.png");
        when(resultSet.getInt("id_map")).thenReturn(2);


        zombie Zombie = ZombieDAO.read(4);

        assertNotNull(Zombie);
        assertEquals(expectedZombie.getNom(), Zombie.getNom());
    }
}
