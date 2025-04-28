package com.oxyl.coursepfback.Persistance;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import com.oxyl.coursepfback.Core.model.Effet;
import com.oxyl.coursepfback.Core.model.plante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class planteDAOTest {

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private planteDAOImpl PlanteDAO;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(dataSource.getConnection()).thenReturn(connection);
    }

    @Test
    void testFindById() throws Exception {
        plante expectedPlante = new plante(1, "Tournesol", 100, 0.0, 0, 50, 0.0, Effet.NORMAL, "images/plante/tournesol.png");

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id_plante")).thenReturn(1);
        when(resultSet.getString("nom")).thenReturn("Tournesol");
        when(resultSet.getInt("point_de_vie")).thenReturn(100);
        when(resultSet.getDouble("attaque_par_seconde")).thenReturn(0.0);
        when(resultSet.getInt("degat_attaque")).thenReturn(0);
        when(resultSet.getInt("cout")).thenReturn(50);
        when(resultSet.getDouble("soleil_par_seconde")).thenReturn(0.0);
        when(resultSet.getString("effet")).thenReturn(Effet.NORMAL.toString());
        when(resultSet.getString("chemin_image")).thenReturn("images/plante/tournesol.png");

        plante Plante = PlanteDAO.read(1);

        assertNotNull(Plante);
        assertEquals(expectedPlante.getNom(), Plante.getNom());
    }
}

