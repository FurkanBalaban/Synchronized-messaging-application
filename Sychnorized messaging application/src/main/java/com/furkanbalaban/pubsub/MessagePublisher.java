package com.furkanbalaban.pubsub;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final StringRedisTemplate redisTemplate;

    public MessagePublisher(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publish(String message) {
        redisTemplate.convertAndSend("notifications", message);
    }
}
