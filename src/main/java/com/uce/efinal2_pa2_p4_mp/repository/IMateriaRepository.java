package com.uce.efinal2_pa2_p4_mp.repository;

import com.uce.efinal2_pa2_p4_mp.repository.modelo.Materia;

public interface IMateriaRepository {
    

    public void insertarMateria(Materia materia);

    public void actualizarMateria(Materia materia);

    public Materia buscarMateriaPorCodigo(String codigo);
}
