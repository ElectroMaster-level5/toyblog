package com.moonrabbit.web.toyblog.init;

import com.moonrabbit.web.toyblog.entity.WebsiteAccess;
import com.moonrabbit.web.toyblog.entity.WebsiteConfig;
import com.moonrabbit.web.toyblog.service.WebsiteAccessService;
import com.moonrabbit.web.toyblog.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class InitWebsiteData {
    @Autowired
    private WebsiteAccessService websiteAccessService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    // beans初始化时使用，常用于常规数据加载
    // 顺序： 构造函数->@Autowired->@PostConstruct
    @PostConstruct
    public void initWebsiteVisists(){
        // 查询当日是否存在博客访问表记录，不存在则插入
        if(websiteAccessService.getByAccessDateIs(new Date()) == null){
            WebsiteAccess websiteAccess = new WebsiteAccess();
            websiteAccess.setAccessDate(new Date());
            websiteAccess.setAccessCount(1);
            websiteAccessService.save(websiteAccess);
        }
        // 查询当日是否存在博客配置表记录，不存在则插入
        if(websiteConfigService.findWebsiteConfig() == null){
            WebsiteConfig websiteConfig = new WebsiteConfig();
            websiteConfig.setId(1L);
            websiteConfig.setAboutPageArticleId(7L);
            websiteConfig.setBlogName("TOY BLOG");
            websiteConfig.setAuthorName("CAI Pengfei");
            websiteConfig.setDomainName("MoonRabbit.com");
            websiteConfig.setRecordNumber("xxxxxxxxxx");
            websiteConfig.setEmailUsername("caipengfei_ecpkn@outlook.com");
            websiteConfigService.saveWebsiteConfig(websiteConfig);
        }
    }
}
