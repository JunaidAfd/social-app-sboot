package com.social.app.socialapp.controller;

import com.social.app.socialapp.models.Message;
import com.social.app.socialapp.models.User;
import com.social.app.socialapp.service.MessageService;
import com.social.app.socialapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreateMessage {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/messages/chat/{chatId}")
    public Message createMessage(@RequestBody Message req, @RequestHeader("Authorizatiooon") String jwt, @PathVariable Integer chatId) throws Exception {
        User user=userService.findUserByJwt(jwt);
        Message message=messageService.createMessage(user,chatId,req);
        return message;
    }

    @GetMapping("/api/messages/chat/{chatId}")
    public List<Message> findChatsMessage(@RequestHeader("Authorizatiooon") String jwt, @PathVariable Integer chatId) throws Exception {
        User user=userService.findUserByJwt(jwt);
        List<Message> messages=messageService.findChatsMessages(chatId);
        return messages;
    }

}
