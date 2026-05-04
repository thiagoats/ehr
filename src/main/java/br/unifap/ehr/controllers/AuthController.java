package br.unifap.ehr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Auths controller class
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@Controller
public class AuthController {

	/**
	 * Login page action
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@GetMapping("/login")
	public String login() {
		return "auths/login";
	}
}