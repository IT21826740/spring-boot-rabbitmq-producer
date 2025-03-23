package lk.zerocode.api.controller;

import lk.zerocode.api.producer.RabbitMqFanOutProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fanout")
@AllArgsConstructor
public class FanoutMessageController {

    private final RabbitMqFanOutProducer fanoutProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        fanoutProducer.sendMessage(message);
        return "Message sent to Fanout Exchange: " + message;
    }
}
