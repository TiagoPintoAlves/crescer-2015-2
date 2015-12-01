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

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping(path = "/itens")
public class ItemController {
	
	private ItemService itemService;
	private MaterialService materialService;
	private ServicoService servicoService;

	@Autowired
	public ItemController(ItemService itemService, MaterialService materialService, ServicoService servicoService) {
		this.itemService = itemService;
		this.materialService = materialService;
		this.servicoService = servicoService;
	}
	
	@RequestMapping(path = "/cadastra/{id}", method = RequestMethod.GET)
	public ModelAndView incluir(@PathVariable("id") Long id){
		return new ModelAndView("item/novo", "item", new ItemDTO(id));
	}
	
	@RequestMapping(path = "/cadastra", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("item") ItemDTO itemDTO, BindingResult result, final RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return new ModelAndView("item/novo");
		}
		
		itemService.incluir(itemDTO);
		return new ModelAndView("redirect:/pedidos/editar/" + itemDTO.getIdPedido());
	}
	
	@ModelAttribute("materiais")
    protected List<Material> comboMateriais() {
        return materialService.listar();
    }
	
	@ModelAttribute("servicos")
    protected List<Servico> comboServicos() {
        return servicoService.listar();
    }
}