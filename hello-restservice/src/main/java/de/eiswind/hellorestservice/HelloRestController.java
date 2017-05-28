package de.eiswind.hellorestservice;

import com.netflix.spectator.api.Counter;
import com.netflix.spectator.api.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class HelloRestController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloRestController.class);

    private Counter callCounter;

    // private Counter failCounter;

    @Autowired
    private Registry registry;

    @Autowired
    ServiceConfig serviceConfig;

    @Value("${helloservice.message}")
    private String helloMessage;


    @PostConstruct
    public void setup() {
        callCounter = registry.counter("hello-restservice", "hello", "call");
        // failCounter = registry.counter("helloservice", "hello", "fail");
    }


    @GetMapping("/")
    public String sayHallo() {
        callCounter.increment();
        LOG.info("RestController answers ... ");
        return helloMessage + " - changable content is: " + serviceConfig.getChangeMe();
    }

}
