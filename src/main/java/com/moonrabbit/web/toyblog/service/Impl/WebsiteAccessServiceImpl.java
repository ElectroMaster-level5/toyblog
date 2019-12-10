package com.moonrabbit.web.toyblog.service.Impl;

import com.moonrabbit.web.toyblog.entity.WebsiteAccess;
import com.moonrabbit.web.toyblog.repository.WebsiteAccessRepository;
import com.moonrabbit.web.toyblog.service.WebsiteAccessService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class WebsiteAccessServiceImpl implements WebsiteAccessService {
    @Autowired
    private WebsiteAccessRepository websiteAccessRepository;

    @Override
    public WebsiteAccess getByAccessDateIs(Date accessDate) {
        return websiteAccessRepository.getByAccessDateIs(accessDate);
    }

    @Override
    public void save(WebsiteAccess websiteAccess) {
        websiteAccessRepository.save(websiteAccess);
    }
}
