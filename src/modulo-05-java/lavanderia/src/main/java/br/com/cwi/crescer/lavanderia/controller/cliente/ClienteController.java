package br.com.cwi.crescer.lavanderia.controller.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    protected ClienteService clienteService;
    protected CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
}
