package com.oxyl.coursepfback.Core.service;

import static org.junit.jupiter.api.Assertions.*;

import com.oxyl.coursepfback.Core.model.Effet;
import com.oxyl.coursepfback.Core.model.plante;
import com.oxyl.coursepfback.Persistance.planteDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;


class planteServiceTest {

    @InjectMocks
    private planteServiceImpl PlanteService;

    @Mock
    private planteDAO PlanteDAO;

    public planteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        plante Plante = new plante(1, "Tournesol", 100, 0.0, 0, 50, 0.0, Effet.NORMAL, "images/plante/tournesol.png");

        when(PlanteDAO.read(1)).thenReturn(Plante);

        plante result = PlanteService.read(1);

        assertNotNull(result);
        assertEquals("Tournesol", result.getNom());
    }
}

