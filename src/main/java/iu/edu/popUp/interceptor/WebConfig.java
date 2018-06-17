package iu.edu.popUp.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/").addPathPatterns("/*")
				.excludePathPatterns("/api/v1/**").excludePathPatterns("/login").excludePathPatterns("/register");

		super.addInterceptors(registry);
	}
}
