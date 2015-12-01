package br.com.cwi.crescer.lavanderia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.service.ClienteService;
import br.com.cwi.crescer.lavanderia.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;
    private ClienteService clienteService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ClienteService clienteService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidos());
    }

    @RequestMapping(path = "/cadastra", method = RequestMethod.GET)
    public ModelAndView viewCadastra() {
        return new ModelAndView("pedido/cadastra", "pedido", new PedidoDTO());
    }

    @RequestMapping(path = "/cadastra", method = RequestMethod.POST)
    public ModelAndView cadastra(@Valid @ModelAttribute("pedido") PedidoDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("pedido/cadastra");
        }
        Long idPedido = pedidoService.incluir(dto);
        return new ModelAndView("redirect:/pedidos/editar/" + idPedido);
    }
    
	@RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		return new ModelAndView("pedido/edita", "pedido", pedidoService.findById(id));
	}
	
	@RequestMapping(path = "/exibir/{id}", method = RequestMethod.GET)
	public ModelAndView exibir(@PathVariable("id") Long id){
		return new ModelAndView("pedido/exibe", "pedido", pedidoService.findById(id));
	}
	
	@RequestMapping(path = "/buscar", method = RequestMethod.GET)
	public ModelAndView buscar(@RequestParam Map<String, String> param){
		List<PedidoDTO> dtos = new ArrayList<>();
		if(param.containsKey("cpf")){
			dtos = pedidoService.findByCpf(param.get("cpf"));
		}else {
			dtos = pedidoService.findBySituacao(param.get("situacao"));
		}
		
		return new ModelAndView("pedido/lista", "pedidos", dtos);
	}

    @ModelAttribute("clientes")
    private List<ClienteResumoDTO> comboCliente() {
        return clienteService.listarClientesAtivos();
    }
    
    @ModelAttribute("situacoes")
    private List<SituacaoPedido> comboSituacoes() {
        return pedidoService.listarSituacoes();
    }
}
