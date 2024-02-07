package com.example;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class CircuitBreakerConfiguration {
//	@Bean
//	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
//	    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//	            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build())
//	            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//	            .build());
//	}
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
		var config = CircuitBreakerConfig.custom()
				  .failureRateThreshold(15)
				  .slowCallRateThreshold(50)
				  .waitDurationInOpenState(Duration.ofMillis(1000))
				  .slowCallDurationThreshold(Duration.ofSeconds(2))
				  .permittedNumberOfCallsInHalfOpenState(3)
				  .minimumNumberOfCalls(10)
				  .slidingWindowType(SlidingWindowType.TIME_BASED)
				  .slidingWindowSize(5)
				  .build();
	    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id).circuitBreakerConfig(config).build());
	}
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> slowCustomizer() {
		var config = CircuitBreakerConfig.custom()
				  .failureRateThreshold(15)
				  .slowCallRateThreshold(50)
				  .waitDurationInOpenState(Duration.ofMillis(1000))
				  .slowCallDurationThreshold(Duration.ofSeconds(2))
				  .permittedNumberOfCallsInHalfOpenState(3)
				  .minimumNumberOfCalls(10)
				  .slidingWindowType(SlidingWindowType.TIME_BASED)
				  .slidingWindowSize(5)
				  .build();
	    return factory -> factory.configure(builder -> builder.circuitBreakerConfig(config), "slow");
//	    return factory -> factory.configure(builder -> builder.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//	            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(1)).build()), "slow");
	}
}
