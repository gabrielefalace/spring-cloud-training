package de.eiswind.hellostream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendingBean {

    private MessageChannel output;

    // "output" is default why we use @EnableBinding with Processor.class
    @Autowired
    public SendingBean(@Qualifier("output") MessageChannel output) {
        this.output = output;
    }

    @Scheduled(fixedDelay = 2000)
    public void sayHello() {
        output.send(MessageBuilder.withPayload("Hello World from Producer " + System.currentTimeMillis()).build());
    }

}
