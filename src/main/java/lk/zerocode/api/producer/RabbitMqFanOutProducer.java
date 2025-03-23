package lk.zerocode.api.producer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitMqFanOutProducer {

    private static final String FANOUT_EXCHANGE = "fanoutExchange";

    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(FANOUT_EXCHANGE, "test", message);
        System.out.println("Sent message: '" + message + "' to Fanout Exchange");
    }
}
