package com.oxyl.coursepfback.API.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.oxyl.coursepfback.Core.model.Effet;
import com.oxyl.coursepfback.Core.model.plante;
import com.oxyl.coursepfback.Core.service.planteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class planteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private planteService PlanteService;

    @InjectMocks
    private planteController PlanteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(PlanteController).build();
    }

    @Test
    void testGetPlanteById() throws Exception {
        plante Plante = new plante(1, "Tournesol", 100, 0.0, 0, 50, 0.0, Effet.NORMAL, "images/plante/tournesol.png");

        when(PlanteService.read(1)).thenReturn(Plante);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plantes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Tournesol"));
    }
}
