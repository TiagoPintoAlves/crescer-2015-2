package br.com.cwi.crescer.lavanderia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping("clientes")
public class ClienteController {

    ClienteService clienteService;

    @RequestMapping(path="/clientes/lista", method = RequestMethod.GET)
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("clientes/lista", "clientes", clienteService.listarClientesAtivos());
        return mv;
    }
}
