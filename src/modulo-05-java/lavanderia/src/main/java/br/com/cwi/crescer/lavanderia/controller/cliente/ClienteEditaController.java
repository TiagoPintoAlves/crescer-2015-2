package br.com.cwi.crescer.lavanderia.controller.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteEditaController extends ClienteController{

	@Autowired
    public ClienteEditaController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}

	@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/edita", "cliente", this.clienteService.buscarClientePorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return new ModelAndView("cliente/edita");
        }
        clienteService.atualizar(dto);
        redirectAttributes.addFlashAttribute("message", "Editado com sucesso");
        return new ModelAndView("redirect:/clientes");
    }

}
