package com.moonrabbit.web.toyblog.controller;

import com.moonrabbit.web.toyblog.entity.Message;
import com.moonrabbit.web.toyblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class ContactController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/contact/sendMail")
    @ResponseBody
    // 事务，若失败全部回滚
    @Transactional(rollbackFor = Throwable.class)
    public String sendMail(@RequestBody Message message){
        message.setMessageInputDate(new Date());
        messageService.saveMessage(message);
        return "success";
    }
}
