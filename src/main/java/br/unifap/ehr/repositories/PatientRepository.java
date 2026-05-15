package br.unifap.ehr.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.unifap.ehr.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	
	@Query("SELECT p, c, d1, a, d2 FROM Patient p join Contact c on p.id = c.id join Demographic d1 on p.id = d1.id join Address a on d1.id = a.id join a.district d2 where p.id = :id")
	public Optional<Patient> findById(Long id);
}