package com.oxyl.coursepfback.API.controller;

import com.oxyl.coursepfback.Core.model.zombie;
import com.oxyl.coursepfback.Core.service.zombieService;
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

class zombieControllerTest {

    private MockMvc mockMvc;

    @Mock
    private zombieService ZombieService;

    @InjectMocks
    private zombieController ZombieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ZombieController).build();
    }

    @Test
    void testGetZombieById() throws Exception {
        zombie Zombie = new zombie(4, "Runner Zombie", 80, 1.0, 8, 0.7, "images/zombie/runner.png", 2);

        when(ZombieService.read(4)).thenReturn(Zombie);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/zombies/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Runner Zombie"));
    }
}

