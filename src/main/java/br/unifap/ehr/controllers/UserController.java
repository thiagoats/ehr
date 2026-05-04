package br.unifap.ehr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.unifap.ehr.exceptions.EntityWithInvalidFieldException;
import br.unifap.ehr.models.Role;
import br.unifap.ehr.models.User;
import br.unifap.ehr.repositories.UserRepository;
import br.unifap.ehr.services.UserService;
import jakarta.validation.Valid;

/**
 * User controller class
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@Controller
@RequestMapping("/users")
public class UserController {

	/**
	 * Users menu
	**/
	private static final String MENU = "users";
	
	/**
	 * Dependency injection with the user repository
	**/
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Dependency injection with the user service
	**/
	@Autowired
	private UserService userService;
	
	/**
	 * User list page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@GetMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("users/list");
		mv.addObject("menu", MENU);
		mv.addObject("users", userRepository.findAll());
		return mv;
	}
	
	/**
	 * User create page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@GetMapping("/create")
	public ModelAndView create(User user) {
		ModelAndView mv = new ModelAndView("users/create");
		mv.addObject("menu", MENU);
		mv.addObject("roles", Role.values());
		return mv;
	}
	
	/**
	 * User save action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@PostMapping("/create")
	public ModelAndView create(@Valid User user, BindingResult result) {
		if(result.hasErrors())
			return create(user);
		try {
			userService.persist(user);
		} catch (EntityWithInvalidFieldException e) {
			result.rejectValue(e.getField(), e.getMessage(), e.getMessage());
			return create(user);
		}
		return new ModelAndView("redirect:/users");
	}
	
	/**
	 * User update page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@GetMapping("/update")
	public ModelAndView update(@RequestParam("id") Long id, User user, boolean isInvalid) {
		ModelAndView mv = new ModelAndView("users/update");
		if(!isInvalid)
			user = userService.findOrFail(id);
		mv.addObject("menu", MENU);
		mv.addObject("user", user);
		mv.addObject("roles", Role.values());
		return mv;
	}
	
	/**
	 * User update action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@PostMapping("/update")
	public ModelAndView update(@Valid User user, BindingResult result) {
		if(result.hasErrors())
			return update(user.getId(), user, true);
		try {
			userService.persist(user);
		} catch (EntityWithInvalidFieldException e) {
			result.rejectValue(e.getField(), e.getMessage(), e.getMessage());
			return update(user.getId(), user, true);
		}
		return new ModelAndView("redirect:/users");
	}
}