package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import feign.Capability;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.example.application.proxies")
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada");
	}
	
	@Bean 
	RestTemplate srvRT(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean 
	@LoadBalanced
	RestTemplate srvRTLB(RestTemplateBuilder builder) {
		return builder.build();
	}
    
	@Bean
	public Capability capability(final MeterRegistry registry) {
		return new MicrometerCapability(registry);
	}

}
