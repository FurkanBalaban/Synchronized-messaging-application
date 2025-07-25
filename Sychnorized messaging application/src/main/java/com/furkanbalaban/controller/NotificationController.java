package com.furkanbalaban.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furkanbalaban.pubsub.MessagePublisher;
import com.furkanbalaban.pubsub.MessageSubscriber;

@RestController
@RequestMapping("/api")
public class NotificationController {

    private final MessagePublisher publisher;

    public NotificationController(MessagePublisher publisher) {
        this.publisher = publisher;
    }

 // Şuna:
    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam String message) {
        publisher.publish(message);
        return ResponseEntity.ok("Mesaj yayınlandı: " + message);
    }


}
