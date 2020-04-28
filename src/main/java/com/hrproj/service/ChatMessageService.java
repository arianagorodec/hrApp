package com.hrproj.service;

import com.hrproj.entity.Anketa;
import com.hrproj.entity.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    ChatMessage addChatMessage(ChatMessage chatMessage);
    void deleteById(long id);
    List<ChatMessage> getByFrom(long from);
    List<ChatMessage> getByTo(long to);
    List<ChatMessage> getByToAndFrom(long to, long from);
    List<ChatMessage> getByToTwice(long to, long from);
    ChatMessage editChatMessage(ChatMessage chatMessage);
    List<ChatMessage> getAll();
}
