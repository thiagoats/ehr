package br.unifap.ehr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.unifap.ehr.exceptions.EntityNotFoundException;
import br.unifap.ehr.exceptions.EntityNotPersistedException;
import br.unifap.ehr.exceptions.EntityWithInvalidFieldException;
import br.unifap.ehr.models.User;
import br.unifap.ehr.repositories.UserRepository;

/**
 * User service class
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@Service
public class UserService {

	/**
	 * Dependency injection with the user repository
	**/
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * User persistence method
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@Transactional
	public void persist(User user) throws EntityWithInvalidFieldException {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		if(isUsernameAlreadyExist(user))
			throw new EntityWithInvalidFieldException("E-mail cadastrado para outro usuário", "username");
		if(userRepository.save(user) == null)
			throw new EntityNotPersistedException("Erro ao salvar usuário");
	}
	
	/**
	 * Find user by id method
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	public User findOrFail(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("Usuário %d não encontrado", id)));
	}
	
	/**
	 * Existing username verification method
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	private boolean isUsernameAlreadyExist(User user) {
		Optional<User> persistedUser = userRepository.findByUsername(user.getUsername().toLowerCase());
		return (persistedUser.isPresent() && !user.equals(persistedUser.get()));
	}
}