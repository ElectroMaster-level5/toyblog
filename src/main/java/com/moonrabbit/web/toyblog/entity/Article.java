package com.moonrabbit.web.toyblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

// @Table当实体类名称与数据库表明不同时使用
// 注意@Table要和@Entity一起使用

@Entity
@Table(name="article")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    private String articleName;

    // @Lob 表示该列用于存储大对象，由于articleContent是String类型的
    // 所以在数据库中是使用CLOB类型用于保存大字符序列
    // 如果是byte[]类型或是Serializable类型，那么在数据库中则使用BLOB存储
    @Lob
    @Column(columnDefinition = "TEXT")
    private String articleContent;

    private String articleAuthors;

    // @Temporal(TemporalType.DATE)，如果在数据库中该列使用Date类型存储
    // 那么在查询时就会得到"yyyy-MM-dd"格式的日期

    // @Temporal(TemporalType.TIME)，如果在数据库中该列使用Date类型存储
    // 那么在查询时就会得到"HH:MM:SS"格式的日期

    // @Temporal(TemporalType.TIMESTAMP)，如果在数据库中该列使用Date类型存储
    // 那么在查询时就会得到"yyyy-MM-dd hh:MM:ss"格式的日期
    @Temporal(TemporalType.DATE)
    private Date articleInputDate;

    private Integer articleReadingTime;
    private Integer isTop;
    private Integer isEnable;

    // 外键信息
    @ManyToMany
    @JoinTable(name = "articleTag", joinColumns = {@JoinColumn(name = "articleId")}, inverseJoinColumns = {@JoinColumn(name = "tagId")})
    private List<Tag> tagList;

    // 项目内使用的字段，非数据库字段
    @Transient
    private int imageNo;

    @Transient
    private String articleIntroduction;

    @Transient
    private String articleShowContent;
}
