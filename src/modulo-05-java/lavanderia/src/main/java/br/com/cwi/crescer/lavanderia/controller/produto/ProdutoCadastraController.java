package br.com.cwi.crescer.lavanderia.controller.produto;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.ProdutoCadastraDTO;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoCadastraController extends ProdutoController{

	public ProdutoCadastraController(ProdutoService produtoService, MaterialService materialService, ServicoService serviceService) {
		super(produtoService, materialService, serviceService);
	}

	@PreAuthorize(value="hasRole('ADMIN')")
    @RequestMapping(path = "/cadastra", method = RequestMethod.GET)
    public ModelAndView viewCadastra() {
        return new ModelAndView("produto/cadastra", "produto", new ProdutoCadastraDTO());
    }

	@PreAuthorize(value="hasRole('ADMIN')")
    @RequestMapping(path = "/cadastra", method = RequestMethod.POST)
    public ModelAndView cadastra(@Valid @ModelAttribute("produto") ProdutoCadastraDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return new ModelAndView("produto/cadastra");
        }
        produtoService.incluir(dto);
        
        redirectAttributes.addFlashAttribute("message", "Cadastrado com sucesso");
        return new ModelAndView("redirect:/produtos");
    }
}
