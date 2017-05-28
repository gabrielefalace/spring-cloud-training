package de.eiswind.hellofrontend;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import static java.awt.SystemColor.text;

@Controller
public class HelloFrontendController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloFrontendController.class);


    @Autowired
    private HelloFeignClient client;

    // @Autowired
    // private RestTemplate restTemplate;

    // @Autowired
    // private EurekaClient eurekaClient;

    @GetMapping("/")
    public String showHello(Model model){
        // Without @LoadBalanced
        // InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("hello-restservice", false);
        // String text = restTemplate.getForObject(nextServerFromEureka.getHomePageUrl(), String.class);

        // With Ribbon & @LoadBalanced
        // String text = restTemplate.getForObject("http://hello-restservice", String.class);

        // Feign
        LOG.info("Frontend Controller called");
        String text = client.callSayHallo();
        model.addAttribute("response", text);
        return "hello";
    }

}
