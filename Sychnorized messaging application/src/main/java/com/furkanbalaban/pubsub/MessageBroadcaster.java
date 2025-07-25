package com.furkanbalaban.pubsub;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageBroadcaster {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageStorage messageStorage;

    public MessageBroadcaster(SimpMessagingTemplate messagingTemplate, MessageStorage messageStorage) {
        this.messagingTemplate = messagingTemplate;
        this.messageStorage = messageStorage;
    }

    public void broadcast(String message) {
        messageStorage.add(message);
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }

    public void sendHistoryToClient() {
        for (String msg : messageStorage.getAll()) {
            messagingTemplate.convertAndSend("/topic/notifications", msg);
        }
    }
}
