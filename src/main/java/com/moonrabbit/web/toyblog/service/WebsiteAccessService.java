package com.moonrabbit.web.toyblog.service;

import com.moonrabbit.web.toyblog.entity.WebsiteAccess;

import java.util.Date;

public interface WebsiteAccessService {

    WebsiteAccess getByAccessDateIs(Date accessDate);

    void save(WebsiteAccess websiteAccess);
}
