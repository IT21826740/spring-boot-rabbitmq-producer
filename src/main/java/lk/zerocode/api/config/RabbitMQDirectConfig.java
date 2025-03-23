package lk.zerocode.api.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {
    public static final String QUEUE_ONE = "direct-queue-1";
    public static final String QUEUE_TWO = "direct-queue-2";

    @Bean
    public Queue directQueueOne() {
        return new Queue(QUEUE_ONE, true);
    }

    @Bean
    public Queue directQueueTwo() {
        return new Queue(QUEUE_TWO, true);
    }
}
