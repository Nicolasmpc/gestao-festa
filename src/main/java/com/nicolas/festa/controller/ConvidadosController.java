package com.nicolas.festa.controller;

import com.nicolas.festa.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvidadosController {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @GetMapping("/convidados")
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("ListaConvidados");
        modelAndView.addObject("convidados", convidadoRepository.findAll());

        return modelAndView;
    }
}
