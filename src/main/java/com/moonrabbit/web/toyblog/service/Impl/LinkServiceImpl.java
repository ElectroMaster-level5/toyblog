package com.moonrabbit.web.toyblog.service.Impl;

import com.moonrabbit.web.toyblog.entity.Link;
import com.moonrabbit.web.toyblog.repository.LinkRepository;
import com.moonrabbit.web.toyblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Override
    @Cacheable(value="link")
    public List<Link> findAllByIsEnable() {
        return linkRepository.findAll();
    }
}
