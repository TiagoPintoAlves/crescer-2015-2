package br.com.cwi.crescer.lavanderia.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ClienteRemoverController extends ClienteController{

	@Autowired
	public ClienteRemoverController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
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
}
