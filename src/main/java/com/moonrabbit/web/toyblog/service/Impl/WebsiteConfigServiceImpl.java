package com.moonrabbit.web.toyblog.service.Impl;

import com.moonrabbit.web.toyblog.entity.WebsiteConfig;
import com.moonrabbit.web.toyblog.repository.WebsiteConfigRepository;
import com.moonrabbit.web.toyblog.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebsiteConfigServiceImpl implements WebsiteConfigService {

    @Autowired
    private WebsiteConfigRepository websiteConfigRepository;

    @Override
    @Cacheable(value="websiteConfig", key="#page")
    public WebsiteConfig findWebsiteConfig() {
        Optional<WebsiteConfig> websiteConfigOptional = websiteConfigRepository.findById(1L);
        if(websiteConfigOptional.isPresent()){
            return websiteConfigOptional.get();
        }
        return null;
    }

    @Override
    public void saveWebsiteConfig(WebsiteConfig websiteConfig) {
        websiteConfigRepository.save(websiteConfig);
    }
}
