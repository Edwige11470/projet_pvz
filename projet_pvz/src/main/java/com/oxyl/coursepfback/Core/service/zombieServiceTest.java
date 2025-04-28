package com.oxyl.coursepfback.Core.service;

import static org.junit.jupiter.api.Assertions.*;

import com.oxyl.coursepfback.Persistance.zombieDAO;
import com.oxyl.coursepfback.Core.model.zombie;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

class zombieServiceTest {

    @InjectMocks
    private zombieServiceImpl ZombieService;

    @Mock
    private zombieDAO ZombieDAO;

    public zombieServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        zombie Zombie = new zombie(4, "Runner Zombie", 80, 1.0, 8, 0.7, "images/zombie/runner.png", 2);

        when(ZombieDAO.read(4)).thenReturn(Zombie);

        zombie result = ZombieService.read(4);

        assertNotNull(result);
        assertEquals("Runner Zombie", result.getNom());
    }
}

