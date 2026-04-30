package br.unifap.ehr.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unifap.ehr.models.User;

/**
 * User repository interface
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	/**
	 * Find user by username
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	public Optional<User> findByUsername(String username);
}