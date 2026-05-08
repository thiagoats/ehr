package br.unifap.ehr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unifap.ehr.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}