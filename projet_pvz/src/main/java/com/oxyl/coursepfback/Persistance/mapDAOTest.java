package com.oxyl.coursepfback.Persistance;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import com.oxyl.coursepfback.Core.model.map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class mapDAOTest {

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private mapDAOImpl MapDAO;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(dataSource.getConnection()).thenReturn(connection);
    }

    @Test
    void testFindById() throws Exception {
        map expectedMap = new map(5, 5, 9, "/images/maps/default.png");

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id_map")).thenReturn(5);
        when(resultSet.getInt("ligne")).thenReturn(5);
        when(resultSet.getInt("colonne")).thenReturn(9);
        when(resultSet.getString("chemin_image")).thenReturn("/images/maps/default.png");

        map Map = MapDAO.read(5);

        assertNotNull(Map);
        assertEquals(expectedMap.getLigne(), Map.getLigne());
    }
}
