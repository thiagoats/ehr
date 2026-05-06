package br.unifap.ehr.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.unifap.ehr.services.AuditService;

@Configuration
@EnableJpaAuditing
public class AuditorAwareConfig {

	public AuditorAware<String> auditorProvider() {
		return new AuditService();
	}
}