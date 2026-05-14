package br.unifap.ehr.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patient_demographics")
public class Demographic {

	@Id
	@Column(name = "patients_id")
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Nascimento é obrigatório")
	@Column(columnDefinition = "date", nullable = false)
	private Date birth;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	private Modality modality;
	
	@Enumerated(EnumType.STRING)
	private Orientation orientation;
	
	@Enumerated(EnumType.STRING)
	private Religion religion;
	
	@Enumerated(EnumType.STRING)
	private Ethnicity ethnicity;
	
	@Enumerated(EnumType.STRING)
	private Marital marital;
	
	@Enumerated(EnumType.STRING)
	private Disability disability;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "patients_id")
	private Patient patient;
	
	@Valid
	@OneToOne(mappedBy = "demographic", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;
}