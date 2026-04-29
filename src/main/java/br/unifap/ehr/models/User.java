package br.unifap.ehr.models;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User model class
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User implements Serializable {
	
	/**
	 * Serial version UID for backward compatibility during serialization
	**/
	private static final long serialVersionUID = 1L;
	
	/**
	 * User id
	**/
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * User email
	**/
	@NotBlank(message = "E-mail é obrigatório")
	@Length(min = 10, max = 60, message = "E-mail deve conter entre 10 e 60 caracteres")
	@Email(message = "E-mail inválido")
	@Column(length = 60, nullable = false)
	private String username;
	
	/**
	 * User password
	**/
	@Column(columnDefinition = "char(60)", nullable = false)
	private String password;
	
	/**
	 * User authority
	**/
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Perfil é obrigatório")
	@Column(columnDefinition = "char(3)", nullable = false)
	private Role role;
	
	/**
	 * Indicates whether the user is enabled.
	**/
	@Column(columnDefinition = "tinyint(1) default 1", nullable = false)
	private Boolean enabled;
}