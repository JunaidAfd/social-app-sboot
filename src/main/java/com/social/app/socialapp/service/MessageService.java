package com.social.app.socialapp.service;

import com.social.app.socialapp.models.Chat;
import com.social.app.socialapp.models.Message;
import com.social.app.socialapp.models.User;

import java.util.List;

public interface MessageService {
    public Message createMessage(User user, Integer chatId, Message req) throws Exception;
    public List<Message> findChatsMessages(Integer chatId) throws Exception;
}
