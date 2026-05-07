package br.unifap.ehr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.unifap.ehr.exceptions.EntityInUseException;
import br.unifap.ehr.exceptions.EntityNotFoundException;
import br.unifap.ehr.exceptions.EntityNotPersistedException;
import br.unifap.ehr.models.District;
import br.unifap.ehr.repositories.DistrictRepository;

@Service
public class DistrictService {

	@Autowired
	private DistrictRepository districtRepository;
	
	@Transactional
	public void persist(District district) {
		if(districtRepository.save(district) == null)
			throw new EntityNotPersistedException("Erro ao salvar bairro");
	}
	
	public District findOrFail(Long id) {
		return districtRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("Bairro %d não encontrado", id)));
	}
	
	@Transactional
	public void remove(District district) {
		try {
			districtRepository.deleteById(district.getId());
			districtRepository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Bairro %d possui dependências", district.getId()));
		}
	}
}