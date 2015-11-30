package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        pedidoService.incluir(dto);

        redirectAttributes.addFlashAttribute("message", "Cadastrado com sucesso");
        return new ModelAndView("redirect:/pedidos");
    }

    @ModelAttribute("clientes")
    private List<ClienteResumoDTO> comboCliente() {
        return clienteService.listarClientesAtivos();
    }
}
