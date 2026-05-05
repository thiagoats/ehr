package br.unifap.ehr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.unifap.ehr.models.User;
import br.unifap.ehr.repositories.UserRepository;
import br.unifap.ehr.security.Account;

@Service
public class EhrUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isEmpty())
			throw new UsernameNotFoundException("Usuário não encontrado");
		return new Account(user.get());
	}
}