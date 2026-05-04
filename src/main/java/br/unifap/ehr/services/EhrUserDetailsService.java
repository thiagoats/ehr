package br.unifap.ehr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.unifap.ehr.models.User;
import br.unifap.ehr.repositories.UserRepository;

/**
 * Bridges the database user entities with Spring Security authentication.
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@Service
public class EhrUserDetailsService implements UserDetailsService {

	/**
	 * Dependency injection with the user repository
	**/
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Loads user data from the database and maps it to Spring Security's UserDetails.
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isEmpty())
			throw new UsernameNotFoundException("Usuário não encontrado");
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), user.get().getAuthorities());
	}
}