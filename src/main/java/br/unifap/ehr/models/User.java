package br.unifap.ehr.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "E-mail é obrigatório")
	@Length(min = 10, max = 60, message = "E-mail deve conter entre 10 e 60 caracteres")
	@Email(message = "E-mail inválido")
	@Column(length = 60, nullable = false, unique = true)
	private String username;
	
	@NotBlank(message = "Senha é obrigatória")
	@Column(columnDefinition = "char(60)", nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Perfil é obrigatório")
	@Column(columnDefinition = "char(3)", nullable = false)
	private Role role;
	
	@Column(columnDefinition = "tinyint(1) default 1", nullable = false)
	private Boolean enabled;
	
	@CreationTimestamp
	@Column(columnDefinition = "datetime", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@CreatedBy
	@Column(length = 60, nullable = false, updatable = false)
	private String createdBy;
	
	@UpdateTimestamp
	@Column(columnDefinition = "datetime", nullable = false)
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	@Column(length = 60, nullable = false)
	private String updatedBy;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.getAuthority()));
	}
}