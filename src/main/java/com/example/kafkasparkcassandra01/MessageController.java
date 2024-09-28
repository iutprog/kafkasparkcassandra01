package com.example.kafkasparkcassandra01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkasparkcassandra01.service.KafkaProducerService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducerService.sendMessage("demo-topic", message);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}
