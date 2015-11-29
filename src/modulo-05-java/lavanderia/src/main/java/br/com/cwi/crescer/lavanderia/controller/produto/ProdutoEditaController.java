package br.com.cwi.crescer.lavanderia.controller.produto;

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

import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoEditaController extends ProdutoController{

	@Autowired
	public ProdutoEditaController(ProdutoService produtoService, MaterialService materialService, ServicoService serviceService) {
		super(produtoService, materialService, serviceService);
	}
	
	@PreAuthorize(value="hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("produto/edita", "produto", produtoService.buscarProdutoPorId(id));
    }

	@PreAuthorize(value="hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return new ModelAndView("produto/edita");
        }
        produtoService.atualizar(dto);
        redirectAttributes.addFlashAttribute("message", "Editado com sucesso");
        return new ModelAndView("redirect:/produtos");
    }
}
