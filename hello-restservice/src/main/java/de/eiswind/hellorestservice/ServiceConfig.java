package de.eiswind.hellorestservice;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "helloservice.config")
public class ServiceConfig {

    private String changeMe;

    public String getChangeMe() {
        return changeMe;
    }

    public void setChangeMe(String changeMe) {
        this.changeMe = changeMe;
    }
}
