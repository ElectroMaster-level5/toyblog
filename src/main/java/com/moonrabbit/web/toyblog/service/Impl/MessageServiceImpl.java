package com.moonrabbit.web.toyblog.service.Impl;

import com.moonrabbit.web.toyblog.entity.Message;
import com.moonrabbit.web.toyblog.repository.MessageRepository;
import com.moonrabbit.web.toyblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
