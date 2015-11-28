package br.com.cwi.crescer.lavanderia.controller.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteCadastraController extends ClienteController{

	@Autowired
	public ClienteCadastraController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}

	@PreAuthorize(value="hasRole('ADMIN')")
    @RequestMapping(path = "/cadastra", method = RequestMethod.GET)
    public ModelAndView viewCadastra() {
        return new ModelAndView("cliente/cadastra", "cliente", new ClienteDTO());
    }

	@PreAuthorize(value="hasRole('ADMIN')")
    @RequestMapping(path = "/cadastra", method = RequestMethod.POST)
    public ModelAndView cadastra(@Valid @ModelAttribute("cliente") ClienteDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return new ModelAndView("cliente/cadastra");
        }
        clienteService.incluir(dto);
        redirectAttributes.addFlashAttribute("message", "Cadastrado com sucesso");
        return new ModelAndView("redirect:/clientes");
    }
}
