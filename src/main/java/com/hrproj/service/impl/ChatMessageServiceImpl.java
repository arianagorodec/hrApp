package com.hrproj.service.impl;

import com.hrproj.entity.Anketa;
import com.hrproj.entity.ChatMessage;
import com.hrproj.entity.Log;
import com.hrproj.entity.User;
import com.hrproj.repository.AnketaRepository;
import com.hrproj.repository.ChatMessageRepository;
import com.hrproj.service.AnketaService;
import com.hrproj.service.ChatMessageService;
import com.hrproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    LogServiceImpl logService;

    @Override
    public ChatMessage addChatMessage(ChatMessage chatMessage) {
        Log log = new Log();
        log.setInfo("Сообщение отправлено к "+chatMessage.getTo());
        log.setUser(userService.getByUsername(chatMessage.getFrom()));
        log.setTime(new Date());
        logService.addLog(log);
        return chatMessageRepository.saveAndFlush(chatMessage);
    }

    @Override
    public void deleteById(long id) {
        chatMessageRepository.deleteById(id);
    }

    @Override
    public List<ChatMessage> getByFrom(long from) {
        return chatMessageRepository.getByFrom(from);
    }
    @Override
    public List<ChatMessage> getByTo(long to) {
        return chatMessageRepository.getByTo(to);
    }

    @Override
    public List<ChatMessage> getByToTwice(long to, long from) {
        return chatMessageRepository.getByToTwice(to, from);
    }

    @Override
    public List<ChatMessage> getByToAndFrom(long to, long from) {
        return chatMessageRepository.getByToAndFrom(to, from);
    }

    @Override
    public ChatMessage editChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.saveAndFlush(chatMessage);
    }

    @Override
    public List<ChatMessage> getAll() {
        return chatMessageRepository.findAll();
    }


    public ChatMessage updateChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }
}
