package br.unifap.ehr.security;

import org.springframework.security.core.userdetails.User;

import lombok.Getter;

/**
 * Logged-in user account representation class
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
public class Account extends User {

	/**
	 * Serial version UID for backward compatibility during serialization
	**/
	private static final long serialVersionUID = 1L;

	/**
	 * User model representation
	**/
	@Getter
	private br.unifap.ehr.models.User user;
	
	/**
	 * Account constructor
	**/
	public Account(br.unifap.ehr.models.User user) {
		super(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, user.getAuthorities());
		this.user = user;
	}
}