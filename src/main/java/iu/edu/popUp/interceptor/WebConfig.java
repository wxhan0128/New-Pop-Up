package iu.edu.popUp.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	private List<String> interceptUrls = new ArrayList<String>();
	private List<String> excludeUrls = new ArrayList<String>();

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// the urls which cannot visited without login session
		this.interceptUrls.add("/");
		this.interceptUrls.add("/*");
		this.interceptUrls.add("/api/v1/**");
		this.interceptUrls.add("/search/*");

		// the urls which can be visited without login session
		this.excludeUrls.add("/login");
		this.excludeUrls.add("/register");

		registry.addInterceptor(new LoginInterceptor()).addPathPatterns(interceptUrls).excludePathPatterns(excludeUrls);

		super.addInterceptors(registry);
	}
}
