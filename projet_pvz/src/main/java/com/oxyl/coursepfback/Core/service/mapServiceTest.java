package com.oxyl.coursepfback.Core.service;

import static org.junit.jupiter.api.Assertions.*;

import com.oxyl.coursepfback.Core.service.mapServiceImpl;
import com.oxyl.coursepfback.Persistance.mapDAO;
import com.oxyl.coursepfback.Core.model.map;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

class mapServiceTest {

    @InjectMocks
    private mapServiceImpl MapService;

    @Mock
    private mapDAO MapDAO;

    public mapServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        map Map = new map(5, 5, 9, "/images/maps/default.png");

        when(MapDAO.read(5)).thenReturn(Map);

        map result = MapService.read(5);

        assertNotNull(result);
        assertEquals(5, result.getLigne());
    }
}


