package com.social.app.socialapp.service;

import com.social.app.socialapp.models.Chat;
import com.social.app.socialapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChatService {
    public Chat createChat(User reqUser, User user2);
    public Chat findChatById(Integer chatId) throws Exception;
    public List<Chat> findUsersChat(Integer userId);
}
