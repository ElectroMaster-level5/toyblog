package com.moonrabbit.web.toyblog.controller;

import com.moonrabbit.web.toyblog.entity.Article;
import com.moonrabbit.web.toyblog.entity.WebsiteConfig;
import com.moonrabbit.web.toyblog.service.ArticleService;
import com.moonrabbit.web.toyblog.service.WebsiteConfigService;
import com.moonrabbit.web.toyblog.util.MarkdownToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private WebsiteConfigService websiteConfigService;

    @GetMapping("/about")
    public String about(Model model){
        WebsiteConfig websiteConfig = websiteConfigService.findWebsiteConfig();
        Long aboutArticleId = websiteConfig.getAboutPageArticleId();
        Article article = articleService.findArticleByArticleId(aboutArticleId);
        article.setArticleShowContent(MarkdownToHtml.markDownToHtml(article.getArticleContent()));
        model.addAttribute("article", article);
        return "about";
    }
}
