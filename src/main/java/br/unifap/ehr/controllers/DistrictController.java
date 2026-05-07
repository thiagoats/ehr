package br.unifap.ehr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.unifap.ehr.models.District;
import br.unifap.ehr.repositories.DistrictRepository;
import br.unifap.ehr.services.DistrictService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/districts")
public class DistrictController {

	private static final String MENU = "districts";
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private DistrictService districtService;
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("districts/search");
		mv.addObject("menu", MENU);
		mv.addObject("districts", districtRepository.findAll());
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView create(District district) {
		ModelAndView mv = new ModelAndView("districts/create");
		mv.addObject("menu", MENU);
		return mv;
	}
	
	@PostMapping("/create")
	public ModelAndView create(@Valid District district, BindingResult result) {
		if(result.hasErrors())
			return create(district);
		districtService.persist(district);
		return new ModelAndView("redirect:/districts");
	}
	
	@GetMapping("/update")
	public ModelAndView update(@RequestParam("id") Long id, District district, boolean isInvalid) {
		ModelAndView mv = new ModelAndView("districts/update");
		if(!isInvalid)
			district = districtService.findOrFail(id);
		mv.addObject("menu", MENU);
		mv.addObject("district", district);
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView update(@Valid District district, BindingResult result) {
		if(result.hasErrors())
			return update(district.getId(), district, true);
		districtService.persist(district);
		return new ModelAndView("redirect:/districts");
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		District district = districtService.findOrFail(id);
		districtService.remove(district);
		return new ModelAndView("redirect:/districts");
	}
}