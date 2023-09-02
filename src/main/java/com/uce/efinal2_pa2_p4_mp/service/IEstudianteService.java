package com.uce.efinal2_pa2_p4_mp.service;

import com.uce.efinal2_pa2_p4_mp.repository.modelo.Estudiante;

public interface IEstudianteService {
    
    public void ingresarEstudiante(Estudiante estudiante);   

    public void matricularEstudiante(String cedula, String mat1, String mat2, String mat3, String mat4);
}
