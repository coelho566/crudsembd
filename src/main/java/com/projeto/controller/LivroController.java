package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Livro;
import com.projeto.repository.LivrosRepository;

@Controller
@RequestMapping("/titulos")
public class LivroController {

	@Autowired
	private LivrosRepository livros;
	
	@RequestMapping(value = "/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastraLivro");
		mv.addObject(new Livro());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Validated Livro livro, Errors errors) {
		ModelAndView mv = new ModelAndView("CadastraLivro");
		if(errors.hasErrors()) {
			return mv;
		}
		livros.save(livro);
		
		return new ModelAndView("redirect:titulos");
	}
	
	@RequestMapping
	public ModelAndView listar() {
		List<Livro> todosLivros = livros.findAll();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("livros", todosLivros);
		
		return mv;
	}
	
	@RequestMapping("editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Livro livro = livros.getOne(id);
		
	ModelAndView mv = new ModelAndView("CadastraLivro");
	mv.addObject(livro);
	
	return mv;
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView excluir(@PathVariable("id") long id) {
		Livro livro = livros.getOne(id);	
		livros.delete(livro);
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("livros", livros.findAll());
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
