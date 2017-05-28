package de.eiswind.hellostream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication
@EnableBinding(Processor.class)
public class HelloStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloStreamApplication.class, args);
	}

	@StreamListener("input")
	public void handle(String msg) {
		System.out.println("Consumer receives message: " + msg);
	}

}
