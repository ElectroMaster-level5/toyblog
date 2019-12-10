package com.moonrabbit.web.toyblog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    // 私信发送方email
    private String email;
    // 私信发送方name
    private String name;
    // 私信主题
    private String subject;
    // 私信内容
    @Lob
    @Column(columnDefinition = "TEXT")
    private String messageContent;
    // 私信日期
    private Date messageInputDate;
    // 私信是否已读
    private Integer isRead;
}
