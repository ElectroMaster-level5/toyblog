package com.moonrabbit.web.toyblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="websiteConfig")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteConfig implements Serializable {

    private static final long serialVersionUID = 7934053649990825994L;
    @Id
    private Long Id;

    // 博客名称
    private String blogName;

    // 作者名字
    private String authorName;

    // about页的文章id，用于about页的展示
    private Long aboutPageArticleId;

    // 备案号
    private String recordNumber;

    // 域名
    private String domainName;

    // 邮箱用户名，例如: caipengfei_ecpkn@outlook.com
    private String emailUsername;
}
