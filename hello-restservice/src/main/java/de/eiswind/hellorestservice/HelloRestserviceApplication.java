package de.eiswind.hellorestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.metrics.atlas.EnableAtlas;

@SpringBootApplication
@EnableDiscoveryClient
// @EnableAtlas
public class HelloRestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloRestserviceApplication.class, args);
	}
}
