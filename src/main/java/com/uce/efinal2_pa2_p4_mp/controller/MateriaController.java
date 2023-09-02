package com.uce.efinal2_pa2_p4_mp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.efinal2_pa2_p4_mp.repository.modelo.Materia;
import com.uce.efinal2_pa2_p4_mp.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @Autowired 

    IMateriaService materiaService;

    @GetMapping("/registro-materia")
    public String principal() {

        return "vistaIngresarMateria";
    }

    @PostMapping("/registrar")
    public String registrar(Materia materia){

        materiaService.registrar(materia);


        return "redirect:/registro-materia";
    }
}
