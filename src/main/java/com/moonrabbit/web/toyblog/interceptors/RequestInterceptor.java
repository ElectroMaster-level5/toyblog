package com.moonrabbit.web.toyblog.interceptors;

import com.moonrabbit.web.toyblog.entity.WebsiteAccess;
import com.moonrabbit.web.toyblog.service.LinkService;
import com.moonrabbit.web.toyblog.service.TagService;
import com.moonrabbit.web.toyblog.service.WebsiteAccessService;
import com.moonrabbit.web.toyblog.service.WebsiteConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Autowired
    private WebsiteAccessService websiteAccessService;

    @Autowired
    private TagService tagService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @Autowired
    private LinkService linkService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){
            ModelMap modelMap = modelAndView.getModelMap();

            logger.info("正在更新网页访问次数。");
            WebsiteAccess websiteAccess = websiteAccessService.getByAccessDateIs(new Date());
            websiteAccess.setAccessCount(websiteAccess.getAccessCount()+1);
            websiteAccessService.save(websiteAccess);

            logger.info("加入底部数据。");
            //标签列表
            modelMap.addAttribute("tagList", tagService.findAll());

        }
    }
}
