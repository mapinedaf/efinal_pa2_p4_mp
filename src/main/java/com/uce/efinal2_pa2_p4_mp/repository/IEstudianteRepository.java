package com.uce.efinal2_pa2_p4_mp.repository;

import com.uce.efinal2_pa2_p4_mp.repository.modelo.Estudiante;

public interface IEstudianteRepository {

    public void insertarEstudiante( Estudiante estudiante);

    public void actualizarEstudiante( Estudiante estudiante);

    public Estudiante buscarEstudiantePorCedula(String cedula);
    
}
