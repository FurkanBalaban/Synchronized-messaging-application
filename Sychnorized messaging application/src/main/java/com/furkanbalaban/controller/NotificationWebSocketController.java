package com.furkanbalaban.controller;

import com.furkanbalaban.pubsub.MessageBroadcaster;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationWebSocketController {

    private final MessageBroadcaster broadcaster;

    public NotificationWebSocketController(MessageBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    @MessageMapping("/history")
    public void sendHistory() {
        broadcaster.sendHistoryToClient();
    }
}
