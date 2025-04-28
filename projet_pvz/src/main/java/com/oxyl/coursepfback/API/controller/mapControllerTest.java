package com.oxyl.coursepfback.API.controller;

import com.oxyl.coursepfback.Core.model.map;
import com.oxyl.coursepfback.Core.service.mapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class mapControllerTest {

    private MockMvc mockMvc;

    @Mock
    private mapService MapService;

    @InjectMocks
    private mapController MapController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(MapController).build();
    }

    @Test
    void testGetMapById() throws Exception {
        map Map = new map(5, 5, 9, "/images/maps/default.png");

        when(MapService.read(5)).thenReturn(Map);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/maps/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ligne").value(5));
    }
}


