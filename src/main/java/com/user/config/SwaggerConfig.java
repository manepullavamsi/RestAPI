package com.user.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
//	.apiInfo(metaInfo()

//	private ApiInfo metaInfo() {
//		
//		ApiInfo apiInfo=new ApiInfo("User Service API", "This user service Api is used to manpulate userService we provide curd operations", "1.7", "http://localhost:8080/user-app/swagger-ui.html#/",null, null, null, null);
//		
//		return apiInfo;
//	}

	
//	
//	@Bean
//	public RedisCacheConfiguration cacheConfiguration() {
//	    return RedisCacheConfiguration.defaultCacheConfig()
//	      .entryTtl(Duration.ofMinutes(60))
//	      .disableCachingNullValues()
//	      .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//	}
}
