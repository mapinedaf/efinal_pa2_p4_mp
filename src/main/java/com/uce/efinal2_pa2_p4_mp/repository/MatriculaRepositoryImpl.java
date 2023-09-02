package com.uce.efinal2_pa2_p4_mp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.efinal2_pa2_p4_mp.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional(value =  TxType.REQUIRED)
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

    @Autowired

    private EntityManager entityManager;

    @Override
    public void insertarMatricula(Matricula matricula) {
        this.entityManager.persist(matricula);
    }

}
