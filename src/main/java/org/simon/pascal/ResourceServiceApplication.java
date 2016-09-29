package org.simon.pascal;

import java.util.Collections;

import org.simon.pascal.sso.resource.JwtFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
@SpringBootApplication
public class ResourceServiceApplication {
	
	@Value("${services.auth}")
    private String authService;

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceApplication.class, args);
	}
	
	@Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.setInitParameters(Collections.singletonMap("services.auth", authService));
        registrationBean.addUrlPatterns("/protected-resource");

        return registrationBean;
    }
}
