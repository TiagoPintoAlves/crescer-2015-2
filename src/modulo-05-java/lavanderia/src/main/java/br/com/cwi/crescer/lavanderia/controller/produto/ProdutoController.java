package br.com.cwi.crescer.lavanderia.controller.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	protected ProdutoService produtoService;
    protected MaterialService materialService;
    protected ServicoService serviceService;
    
    @Autowired
    public ProdutoController(ProdutoService produtoService, MaterialService materialService, ServicoService serviceService) {
        this.produtoService = produtoService;
		this.materialService = materialService;
		this.serviceService = serviceService;
    }
	
	@ModelAttribute("materiais")
    protected List<Material> comboMateriais() {
        return materialService.listar();
    }
	
	@ModelAttribute("servicos")
    protected List<Servico> comboServicos() {
        return serviceService.listar();
    }
}
