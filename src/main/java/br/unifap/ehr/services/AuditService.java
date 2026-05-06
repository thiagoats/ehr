package br.unifap.ehr.services;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuditService implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return Optional.of(((UserDetails) principal).getUsername());
		return Optional.of(null);
	}
}