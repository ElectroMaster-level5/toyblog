package com.moonrabbit.web.toyblog.service;

import com.moonrabbit.web.toyblog.entity.WebsiteConfig;

public interface WebsiteConfigService {

    WebsiteConfig findWebsiteConfig();

    void saveWebsiteConfig(WebsiteConfig websiteConfig);
}
