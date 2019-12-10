package com.moonrabbit.web.toyblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "link")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link implements Serializable {
    // serialVersionUID 用于反序列化时，即使类发生了改变也能正常进行。
    // Id 表示是主键
    @Id
    // GenerationType.IDENTITY 表明此字段自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // linkId 在数据库中 会变成 link_id 字样
    private Long linkId;
    private  String linkName;
    private String linkUrl;
    private String remark;
}
