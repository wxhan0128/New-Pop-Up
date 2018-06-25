package iu.edu.popUp.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	private List<String> excludeUrls = new ArrayList<String>();

	@Value("${img.location}")
	private String location;

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("100MB");
		factory.setMaxRequestSize("100MB");
		return factory.createMultipartConfig();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// exclude the static resources
		this.excludeUrls.add("/css/**");
		this.excludeUrls.add("/images/**");
		this.excludeUrls.add("/js/**");

		// exclude the urls
		this.excludeUrls.add("/login");
		this.excludeUrls.add("/register");

		// "/**" contains all files inside classpath, should also exclude the static
		// resources.
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(excludeUrls);

		super.addInterceptors(registry);
	}
}
