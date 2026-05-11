package br.unifap.ehr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.unifap.ehr.exceptions.EntityInUseException;
import br.unifap.ehr.exceptions.EntityNotFoundException;
import br.unifap.ehr.exceptions.EntityNotPersistedException;
import br.unifap.ehr.models.Patient;
import br.unifap.ehr.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Transactional
	public void persist(Patient patient) {
		if(patientRepository.save(patient) == null)
			throw new EntityNotPersistedException("Erro ao salvar paciente");
	}
	
	public Patient findOrFail(Long id) {
		return patientRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("Paciente %d não encontrado", id)));
	}
	
	@Transactional
	public void remove(Patient patient) {
		try {
			patientRepository.deleteById(patient.getId());
			patientRepository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Paciente %d possui dependências", patient.getId()));
		}
	}
}