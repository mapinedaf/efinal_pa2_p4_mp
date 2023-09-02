package com.uce.efinal2_pa2_p4_mp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.efinal2_pa2_p4_mp.repository.modelo.Estudiante;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Repository
@Transactional(value =  TxType.REQUIRED)
public class EstudianteRepositoryImpl implements IEstudianteRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void insertarEstudiante(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public Estudiante buscarEstudiantePorCedula(String cedula) {
                String jpql = "select Estudiante m from Estudiante m where m.cedula = :datoCodigo";
        TypedQuery<Estudiante> query =  entityManager.createQuery(jpql, Estudiante.class);

        query.setParameter("datoCodigo", cedula);

        return query.getSingleResult();
    }
    
}
