package com.oxyl.coursepfback.Core.service;

import com.oxyl.coursepfback.Core.model.plante;
import com.oxyl.coursepfback.Persistance.planteDAO;
import com.oxyl.coursepfback.Persistance.planteDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class planteServiceImpl implements planteService {

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
    public plante read(int id_plante) {
        return PlanteDAO.read(id_plante);
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
    public void delete(int id_plante) {
        PlanteDAO.delete(id_plante);
    }
}
