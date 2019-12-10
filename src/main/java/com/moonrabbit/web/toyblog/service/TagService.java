package com.moonrabbit.web.toyblog.service;


import com.moonrabbit.web.toyblog.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();
    Tag findByTagName(String tagName);
}
