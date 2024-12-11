package org.example.sb_test.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/tickets/update")
    @SendTo("/topic/tickets")
    public String sendUpdate(String message) {
        return message;
    }
}
