package br.unifap.ehr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Home controller class
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@Controller
@RequestMapping("/")
public class HomeController {
	
	public static final String MENU = "home";

	/**
	 * Homepage action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("menu", MENU);
		return mv;
	}
}