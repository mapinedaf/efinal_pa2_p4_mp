package com.uce.efinal2_pa2_p4_mp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.efinal2_pa2_p4_mp.repository.modelo.Estudiante;
import com.uce.efinal2_pa2_p4_mp.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/sign-in")
    public String principal(Model model){


        model.addAttribute("estudiante", new Estudiante());
        
        return "vistaIngresarEstudiante";
    }
    

    @PostMapping("/registrar")
    public String registrarEstudiante (Estudiante estudiante){
        estudianteService.ingresarEstudiante(estudiante);
        return "redirect:/estudiantes/sign-in";
    }

    @GetMapping("/matricula")
    public String paginaMatricula(){

        return "vistaMatricularEstudiante";
    }

    

}
