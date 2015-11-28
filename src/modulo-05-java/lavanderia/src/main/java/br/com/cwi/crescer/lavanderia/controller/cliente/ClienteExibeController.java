package br.com.cwi.crescer.lavanderia.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.service.ClienteService;
import br.com.cwi.crescer.lavanderia.controller.cliente.ClienteController;
import br.com.cwi.crescer.lavanderia.service.CidadeService;

@Controller
@RequestMapping("/clientes")
public class ClienteExibeController extends ClienteController{

	@Autowired
	public ClienteExibeController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}
	
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("cliente/lista", "clientes", clienteService.listarTodosClientes());
    }
	
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }
}
