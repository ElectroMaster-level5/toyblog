package com.moonrabbit.web.toyblog.timer;


import com.moonrabbit.web.toyblog.entity.WebsiteAccess;
import com.moonrabbit.web.toyblog.service.WebsiteAccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WebSiteTimer {
    @Autowired
    private WebsiteAccessService websiteAccessService;

    // 每月的第一天的00:00:00出发
    // cron表达式用法 https://www.cnblogs.com/linjiqin/p/3178452.html
    @Scheduled(cron = "0 0 0 1/1 * ?")
    private void updateTodyWebsiteVisits(){
        WebsiteAccess websiteAccess = new WebsiteAccess();
        websiteAccess.setAccessCount(1);
        websiteAccess.setAccessDate(new Date());
        websiteAccessService.save(websiteAccess);
    }
}
