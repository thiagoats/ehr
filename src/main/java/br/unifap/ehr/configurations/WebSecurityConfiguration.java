package br.unifap.ehr.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;
import br.unifap.ehr.services.EhrUserDetailsService;

/**
 * Security configuration for session-based authentication.
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@Configuration
public class WebSecurityConfiguration {

	/**
	 * Dependency injection with the user details service implementation
	**/
	@Autowired
	private EhrUserDetailsService ehrUserDetailsService;
	
	/**
	 * Configures HTTP security, session management, and access control for web endpoints.
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
		requestCache.setMatchingRequestParameterName(null);
		http
		.requestCache(
				cache -> {
					cache.requestCache(requestCache);
				}
		)
		.authorizeHttpRequests(
				authorize -> {
					authorize.requestMatchers("/login", "/css/**", "/images/**", "/js/**", "/vendors/**").permitAll();
					authorize.anyRequest().authenticated();
				}
		)
		.formLogin(
				form -> {
					form.loginPage("/login");
					form.defaultSuccessUrl("/", true);
					form.usernameParameter("username");
					form.passwordParameter("password");
					form.failureUrl("/login?error=true");
				}
		)
		.logout(
				shutdown -> {
					shutdown.logoutSuccessUrl("/login?logout=true");
					shutdown.logoutRequestMatcher(PathPatternRequestMatcher.withDefaults().matcher( HttpMethod.GET,"/logout"));
				}
		);
		
		return http.build();
	}
	
	/**
	 * Integrates the custom user identity store with the auth provider.
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@Bean
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(ehrUserDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
}