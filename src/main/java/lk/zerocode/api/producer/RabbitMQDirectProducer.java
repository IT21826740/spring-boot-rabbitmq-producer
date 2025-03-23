package lk.zerocode.api.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQDirectProducer {
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQDirectProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String queue, String message) {
        rabbitTemplate.convertAndSend(queue, message);
        System.out.println("Sent to queue [" + message + "]: " + message);
    }
}
