package br.unifap.ehr.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patient_contacts")
public class Contact {

	@Id
	@Column(name = "patients_id")
	private Long id;
	
	@NotBlank(message = "Celular é obrigatório")
	@Column(columnDefinition = "char(15)", nullable = false)
	private String cellphone;
	
	@Email(message = "E-mail é inválido")
	@Length(max = 40, message = "E-mail deve ter no máximo 40 caracteres")
	@Column(length = 40)
	private String email;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "patients_id")
	private Patient patient;
}