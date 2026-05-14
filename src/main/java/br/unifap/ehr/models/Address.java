package br.unifap.ehr.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patient_addresses")
public class Address {

	@Id
	@Column(name = "patients_id")
	private Long id;
	
	@NotBlank(message = "Logradouro é obrigatório")
	@Length(min = 5, max = 60, message = "Logradouro deve ter entre 5 e 60 caracteres")
	@Column(length = 60, nullable = false)
	private String place;
	
	@Length(max = 80, message = "Complemente pode conter no máximo 80 caracteres")
	@Column(length = 80)
	private String complement;
	
	@NotNull(message = "Bairro é obrigatório")
	@ManyToOne
	@JoinColumn(name = "associates_id", nullable = false)
	private District district;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "patients_id")
	private Demographic demographic;
}