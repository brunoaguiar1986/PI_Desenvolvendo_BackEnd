package br.senai.sp.informatica.ead.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.senai.sp.informatica.ead.model.Pessoa;
import br.senai.sp.informatica.ead.repository.PessoaRepository;

@Controller
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoa/obj")
	public List<Pessoa> lista(){
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoa")
	public ModelAndView ListarPessoas() {
		ModelAndView mv = new ModelAndView("/pessoa/index");
		mv.addObject("listaDePessoas", pessoaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/pessoa/cadastro")
	public String cadastrar(Model model) {
		Pessoa pessoa = new Pessoa();
		model.addAttribute(pessoa);
		return "/pessoa/pessoaCadastro";
	}
	
	@PostMapping("/pessoa/salvar")
	public String salvar(@ModelAttribute("pessoa") Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return "redirect:/pessoa";
	}
	
	@GetMapping("/pessoa/editar/{id}")
	public ModelAndView editarPessoa(@PathVariable Long id) {
	 Optional<Pessoa> pessoaRetornada = pessoaRepository.findById(id);
	 ModelAndView mv = new ModelAndView("/pessoa/pessoaEditar");
	 mv.addObject("pessoa", pessoaRetornada);
	 return mv;
	}
	
	@GetMapping("/pessoa/remover/{id}")
	public String remover(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
		
		return "redirect:/pessoa";
	}
	
}
