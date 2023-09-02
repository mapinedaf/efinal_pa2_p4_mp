package com.uce.efinal2_pa2_p4_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.efinal2_pa2_p4_mp.repository.IMateriaRepository;
import com.uce.efinal2_pa2_p4_mp.repository.IMatriculaRepository;
import com.uce.efinal2_pa2_p4_mp.repository.modelo.Materia;
import com.uce.efinal2_pa2_p4_mp.repository.modelo.Matricula;


@Service
public class MateriaServiceImpl implements IMateriaService{


    @Autowired
    IMateriaRepository materiaRepository;
    @Override
    public void registrar(Materia materia) {
        // TODO Auto-generated method stub
        materiaRepository.insertarMateria(materia);
    }


    
}
