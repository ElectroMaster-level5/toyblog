package com.moonrabbit.web.toyblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    private static final long serialVersionUID = -6775202020339261507L;
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
