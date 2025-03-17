package com.epf.Core.service;

import com.epf.Core.model.plante;
import com.epf.Persistance.planteDAO;
import com.epf.Persistance.planteDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class planteServiceImpl implements planteService {

    // Injection du DAO via Spring
    private final planteDAO PlanteDAO;

    @Autowired
    public planteServiceImpl(planteDAOImpl PlanteDAO) {
        this.PlanteDAO = PlanteDAO;
    }

    @Override
    public void create(plante Plante) {
        PlanteDAO.create(Plante);
    }

    @Override
    public plante read(int id) {
        return PlanteDAO.read(id);
    }

    @Override
    public List<plante> readAll() {
        return PlanteDAO.readAll();
    }

    @Override
    public void update(plante Plante) {
        PlanteDAO.update(Plante);

    }

    @Override
    public void delete(int id) {
        PlanteDAO.delete(id);
    }
}
