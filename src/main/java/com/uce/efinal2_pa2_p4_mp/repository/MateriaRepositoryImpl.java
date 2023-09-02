package com.uce.efinal2_pa2_p4_mp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.efinal2_pa2_p4_mp.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional(value = TxType.REQUIRED)

public class MateriaRepositoryImpl implements IMateriaRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void insertarMateria(Materia materia) {
        entityManager.persist(materia);
    }

    @Override
    public void actualizarMateria(Materia materia) {
        this.entityManager.persist(materia);
    }

    @Override
    public Materia buscarMateriaPorCodigo(String codigo) {

        String jpql = "select Materia m from Materia m where m.codigo = :datoCodigo";
        TypedQuery<Materia> query =  entityManager.createQuery(jpql, Materia.class);

        query.setParameter("datoCodigo", codigo);

        return query.getSingleResult();
    }
    
}
