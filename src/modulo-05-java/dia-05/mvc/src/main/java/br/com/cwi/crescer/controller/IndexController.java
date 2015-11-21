package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.model.IndexModel;
import br.com.cwi.crescer.service.PessoaService;

@Controller
public class IndexController {
	
	private PessoaService pessoaService;
	
	@Autowired
	public IndexController(PessoaService pessoaService) {
		super();
		this.pessoaService = pessoaService;
	}

	@RequestMapping({ "/", "/index" })
	public String index(Model model) {
		
		IndexModel indexModel = new IndexModel();
		
		String mensagem = "#M05A05 - Página Root / Index";
		String nome = pessoaService.buscarNome(1L);
		
		indexModel.setMensagem(mensagem);
		indexModel.setNome(nome);
		
		model.addAttribute("model", indexModel);
		
		return "index";		
	}
	
	@RequestMapping("/index1")
	public String index1() {
		return "index1";
	}
	
	@RequestMapping("/index2")
	public ModelAndView index2() {
		
		ModelAndView mv = new ModelAndView("index2");
		
		String mensagem = "#M05A05 - Página Index2";
		
		mv.addObject("mensagem", mensagem);
		
		return mv;
	}
}