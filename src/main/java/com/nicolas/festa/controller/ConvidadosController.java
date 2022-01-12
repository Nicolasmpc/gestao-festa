package com.nicolas.festa.controller;

import com.nicolas.festa.model.Convidado;
import com.nicolas.festa.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("ListaConvidados");
        modelAndView.addObject("convidados", convidadoRepository.findAll());
        modelAndView.addObject(new Convidado());

        return modelAndView;
    }

    @PostMapping
    public String salvar(Convidado convidado){
        this.convidadoRepository.save(convidado);
        return "redirect:/convidados";
    }
}
