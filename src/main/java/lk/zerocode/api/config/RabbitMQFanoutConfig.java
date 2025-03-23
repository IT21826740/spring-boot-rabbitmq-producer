package lk.zerocode.api.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    // Exchange Name
    private static final String FANOUT_EXCHANGE = "fanoutExchange";

    // Queue Names
    private static final String QUEUE_ONE = "fanout-queue-1";
    private static final String QUEUE_TWO = "fanout-queue-2";

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    Queue fanOutQueueOne() {
        return new Queue(QUEUE_ONE, true);
    }

    @Bean
    Queue fanOutQueueTwo() {
        return new Queue(QUEUE_TWO, true);
    }

    @Bean
    Binding bindingFanOutQueueOne(Queue fanOutQueueOne, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanOutQueueOne).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanOutQueueTwo(Queue fanOutQueueTwo, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanOutQueueTwo).to(fanoutExchange);
    }
}
