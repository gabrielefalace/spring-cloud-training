package de.eiswind.hellofrontend;

import org.springframework.stereotype.Component;

@Component
public class HelloFeignFallback implements HelloFeignClient {

    @Override
    public String callSayHallo() {
        return "Service unavailable";
    }
}
