package com.moonrabbit.web.toyblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="websiteAccess")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteAccess implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //最新访问时间
    @Temporal(TemporalType.DATE)
    private Date accessDate;

    // 当日访问量
    private Integer accessCount;
}
