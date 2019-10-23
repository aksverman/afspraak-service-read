package com.iddink.afspraak.read;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class AfspraakServiceReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfspraakServiceReadApplication.class, args);
	}
	
	@Configuration
    @EnableSwagger2
    public static class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.iddink.afspraak.read"))
                    .paths(PathSelectors.any())
                    .build().apiInfo(apiInfo());
        }

		@SuppressWarnings("deprecation")
		private ApiInfo apiInfo() {
			return new ApiInfo("AFSPRAAK READ SERVICE API", 
					"Read Side of Afspraak Service", 
					"alfa", "Terms of service", 
					"Team Eduarte India",
					"License of API", 
					"API license URL");
		}
    }
}
