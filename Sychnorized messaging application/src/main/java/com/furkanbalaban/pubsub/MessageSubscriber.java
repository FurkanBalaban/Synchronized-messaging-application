package com.furkanbalaban.pubsub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber implements MessageListener {
    private final MessageBroadcaster broadcaster;
    public MessageSubscriber(MessageBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String msg = message.toString();
        System.out.println("📩 Yeni mesaj alındı: " + msg);
        // Buradan WebSocket’e iletim yapılacak (sonraki adımda)
        broadcaster.broadcast(msg); // WebSocket üzerinden yay

    }
}
