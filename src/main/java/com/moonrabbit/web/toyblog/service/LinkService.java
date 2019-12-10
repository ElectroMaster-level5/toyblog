package com.moonrabbit.web.toyblog.service;

import com.moonrabbit.web.toyblog.entity.Link;

import java.util.List;

public interface LinkService {
    List<Link> findAllByIsEnable();
}
