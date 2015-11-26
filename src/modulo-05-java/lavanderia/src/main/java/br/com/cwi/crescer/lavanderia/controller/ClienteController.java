package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientesAtivos());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO dto, RedirectAttributes redirectAttributes, BindingResult result) {
        if(result.hasErrors()){
        	return new ModelAndView("cliente/edita");
        }
    	clienteService.atualizar(dto);
        redirectAttributes.addFlashAttribute("message", "Editado com sucesso");
        return new ModelAndView("redirect:/clientes");
    }

    @RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
    public ModelAndView viewRemove(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/remover", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView remove(ClienteDTO dto, RedirectAttributes redirectAttributes) {
        clienteService.excluir(dto.getId());
        redirectAttributes.addFlashAttribute("message", "Removido com sucesso");
        return new ModelAndView("redirect:/clientes");
    }
    
    @RequestMapping(path = "/cadastra", method = RequestMethod.GET)
    public ModelAndView viewCadastra() {
        return new ModelAndView("cliente/cadastra", "cliente", new ClienteDTO());
    }

    @RequestMapping(path = "/cadastra", method = RequestMethod.POST)
    public ModelAndView cadastra(@Valid @ModelAttribute("cliente") ClienteDTO dto, RedirectAttributes redirectAttributes, BindingResult result) {
        if(result.hasErrors()){
        	return new ModelAndView("cliente/cadastra");
        }
        clienteService.incluir(dto);
        redirectAttributes.addFlashAttribute("message", "Cadastrado com sucesso");
        return new ModelAndView("redirect:/clientes");
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
}
