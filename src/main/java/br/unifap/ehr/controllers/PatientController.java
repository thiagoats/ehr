package br.unifap.ehr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.unifap.ehr.models.Disability;
import br.unifap.ehr.models.Ethnicity;
import br.unifap.ehr.models.Gender;
import br.unifap.ehr.models.Marital;
import br.unifap.ehr.models.Modality;
import br.unifap.ehr.models.Orientation;
import br.unifap.ehr.models.Patient;
import br.unifap.ehr.models.Religion;
import br.unifap.ehr.repositories.PatientRepository;
import br.unifap.ehr.services.PatientService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/patients")
public class PatientController {

	private static final String MENU = "patients";
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ModelAndView search() {
		ModelAndView mv = new ModelAndView("patients/search");
		mv.addObject("menu", MENU);
		mv.addObject("patients", patientRepository.findAll());
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView create(Patient patient) {
		ModelAndView mv = new ModelAndView("patients/create");
		mv.addObject("menu", MENU);
		mv.addObject("genders", Gender.values());
		mv.addObject("modalities", Modality.values());
		mv.addObject("orientations", Orientation.values());
		mv.addObject("maritalStatus", Marital.values());
		mv.addObject("religions", Religion.values());
		mv.addObject("disabilities", Disability.values());
		mv.addObject("ethnicities", Ethnicity.values());
		return mv;
	}
	
	@PostMapping("/create")
	public ModelAndView create(@Valid Patient patient, BindingResult result) {
		if(result.hasErrors())
			return create(patient);
		patient.getContact().setPatient(patient);
		patient.getDemographic().setPatient(patient);
		patient.getDemographic().getAddress().setDemographic(patient.getDemographic());
		patientService.persist(patient);
		return new ModelAndView("redirect:/patients");
	}
	
	@GetMapping("/update")
	public ModelAndView update(@RequestParam("id") Long id, Patient patient, boolean isInvalid) {
		ModelAndView mv = new ModelAndView("patients/update");
		if(!isInvalid)
			patient = patientService.findOrFail(id);
		mv.addObject("menu", MENU);
		mv.addObject("patient", patient);
		mv.addObject("genders", Gender.values());
		mv.addObject("modalities", Modality.values());
		mv.addObject("orientations", Orientation.values());
		mv.addObject("maritalStatus", Marital.values());
		mv.addObject("religions", Religion.values());
		mv.addObject("disabilities", Disability.values());
		mv.addObject("ethnicities", Ethnicity.values());
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView update(@Valid Patient patient, BindingResult result) {
		if(result.hasErrors())
			return update(patient.getId(), patient, true);
		patient.getContact().setId(patient.getId());
		patient.getDemographic().setId(patient.getId());
		patient.getDemographic().getAddress().setId(patient.getId());
		patientService.persist(patient);
		return new ModelAndView("redirect:/patients");
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		Patient patient = patientService.findOrFail(id);
		patientService.remove(patient);
		return new ModelAndView("redirect:/patients");
	}
}