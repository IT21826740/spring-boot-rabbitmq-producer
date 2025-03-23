package lk.zerocode.api.controller;

import lk.zerocode.api.config.RabbitMQDirectConfig;
import lk.zerocode.api.producer.RabbitMQDirectProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/direct")
public class DirectMessageController {

    private final RabbitMQDirectProducer producer;

    @GetMapping("/send")
    public void sendMessage(@RequestParam String message) {
        producer.sendMessage(RabbitMQDirectConfig.QUEUE_ONE, message + "_q1");
        producer.sendMessage(RabbitMQDirectConfig.QUEUE_TWO, message + "_q2");
        System.out.println("send message ...");
    }
}
