package com.uce.efinal2_pa2_p4_mp.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.efinal2_pa2_p4_mp.repository.IEstudianteRepository;
import com.uce.efinal2_pa2_p4_mp.repository.IMateriaRepository;
import com.uce.efinal2_pa2_p4_mp.repository.IMatriculaRepository;
import com.uce.efinal2_pa2_p4_mp.repository.modelo.Estudiante;
import com.uce.efinal2_pa2_p4_mp.repository.modelo.Materia;
import com.uce.efinal2_pa2_p4_mp.repository.modelo.Matricula;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Autowired
    private IMateriaRepository materiaRepository;

    @Autowired
    private IMatriculaRepository matriculaRepository;

    @Override
    public void ingresarEstudiante(Estudiante estudiante) {



        estudianteRepository.insertarEstudiante(estudiante);
    }

    @Override
    @Transactional(value =  TxType.REQUIRED)
    public void matricularEstudiante(String cedula, String mat1, String mat2, String mat3, String mat4) {

        Estudiante estudiante = estudianteRepository.buscarEstudiantePorCedula(cedula);
        List<String> codMaterias = Arrays.asList(mat1, mat2, mat3, mat4);

        List<Materia> materias = codMaterias.stream().map(materiaRepository::buscarMateriaPorCodigo)
                .collect(Collectors.toList());

        List<Matricula> matriculas = materias.stream().map(materia -> {

            Matricula mat = Matricula.builder().fecha(LocalDate.now()).estudiante(estudiante).materia(materia).build();

            return mat;
        }).collect(Collectors.toList());

        matriculas.parallelStream().forEach(
                matricula -> {
                    matricula.setNombreHilo(Thread.currentThread().getName());
                    matriculaRepository.insertarMatricula(matricula);
                });
    }


    
}
