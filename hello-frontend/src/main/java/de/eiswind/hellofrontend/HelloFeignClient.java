package de.eiswind.hellofrontend;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "hello-restservice", fallback = HelloFeignFallback.class)
public interface HelloFeignClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String callSayHallo();
}
