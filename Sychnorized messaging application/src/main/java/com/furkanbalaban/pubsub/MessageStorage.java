package com.furkanbalaban.pubsub;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageStorage {

    private final List<String> messages = new ArrayList<>();

    public void add(String message) {
        messages.add(message);
    }

    public List<String> getAll() {
        return new ArrayList<>(messages);
    }
}
