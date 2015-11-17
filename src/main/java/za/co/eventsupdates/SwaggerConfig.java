package za.co.eventsupdates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;

@Configuration
@EnableSwagger
class SwaggerConfig  {
	
	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
				apiInfo()).includePatterns("/.*");
	}
	
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Events Update API", "API for Events Update",
				"Events Update API terms of service", "lkonaite@gmail.com",
				"Events Update API Licence Type", "Events Update API License URL");
		return apiInfo;
	}
   
}
