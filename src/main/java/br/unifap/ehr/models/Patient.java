package br.unifap.ehr.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "patients")
public class Patient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "\\d{15}", message = "Cartão SUS deve conter 15 dígitos")
	@Column(columnDefinition = "char(15)")
	private String susId;
	
	@CPF(message = "CPF inválido")
	@Column(columnDefinition = "char(11)", nullable = false)
	private String cpf;
	
	@NotBlank(message = "Nome é obrigatório")
	@Length(min = 3, max = 75, message = "Nome deve conter entre 3 e 75 caracteres")
	@Column(length = 75, nullable = false)
	private String name;
	
	@NotBlank(message = "Nome social é obrigatório")
	@Length(min = 3, max = 30, message = "Nome social deve conter entre 3 e 30 caracteres")
	@Column(length = 30, nullable = false)
	private String socialName;
	
	@Length(min = 3, max = 75, message = "Nome da mãe deve conter entre 3 e 75 caracteres")
	@Column(length = 75, nullable = false)
	private String motherName;
	
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
	
	@PrePersist @PreUpdate
	private void prePersistPreUpdate() {
		this.cpf = this.cpf.replaceAll("\\.|-", "");
	}
	
	@PostLoad
	private void postLoad() {
		this.cpf = this.cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})", "$1.$2.$3-");
	}
}