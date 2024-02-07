package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//@LoadBalancerClient(value = "CATALOGO-SERVICE", configuration = LoadBalancerConfiguration.class)
public class LoadBalancerConfiguration {
	private static final Logger log = LoggerFactory.getLogger(LoadBalancerConfiguration.class);

//	@Bean
//	ReactorLoadBalancer<ServiceInstance> roundRobinLoadBalancer(Environment environment,
//			LoadBalancerClientFactory loadBalancerClientFactory) {
//		log.warn("Configuring Load balancer to random");
//		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//		return new RoundRobinLoadBalancer(
//				loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
//	}
//	@Bean
//	ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
//			LoadBalancerClientFactory loadBalancerClientFactory) {
//		log.warn("Configuring Load balancer to random");
//		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//		return new RandomLoadBalancer(
//				loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
//	}
//	@Bean
//	public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplierSameInstancePrefer(
//			ConfigurableApplicationContext context) {
//		log.warn("Configuring Load balancer to same instance prefer");
//		return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withSameInstancePreference()
//				.build(context);
//	}
//	@Bean
//	public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplierByZoneBased(
//			ConfigurableApplicationContext context) {
//		log.warn("Configuring Load balancer to zone-based");
//		return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withZonePreference().withCaching()
//				.build(context);
//	}
//	@Bean
//	public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplierByHealthChecks(
//			ConfigurableApplicationContext context) {
//		log.warn("Configuring Load balancer to health-check");
//		return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withBlockingHealthChecks()
//				.build(context);
//	}
}
