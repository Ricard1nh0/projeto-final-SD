package com.projetofinal.discovery_server; // Verifique se o package corresponde ao criado pelo initializr

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}
}