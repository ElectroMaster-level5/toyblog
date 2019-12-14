package com.moonrabbit.web.toyblog.controller;

import com.moonrabbit.web.toyblog.constants.Constants;
import com.moonrabbit.web.toyblog.entity.Article;
import com.moonrabbit.web.toyblog.entity.Tag;
import com.moonrabbit.web.toyblog.service.TagService;
import com.moonrabbit.web.toyblog.util.HtmlSpirit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public String tag(Model model){
        model.addAttribute("tagList", tagService.findAll());
        return "tag";
    }

    @GetMapping("/tag/{tagName}")
    public String tag(Model model, @PathVariable String tagName){
        Tag tag = tagService.findByTagName(tagName);
        List<Article> articleList = tag.getArticleList();

        for (Article article : articleList) {
            String articleIntroduction = HtmlSpirit.delHtmlTag(article.getArticleContent());
            article.setArticleIntroduction(articleIntroduction.length()> Constants.blogIntroLen?
                    articleIntroduction.substring(0, Constants.blogIntroLen-4>0?Constants.blogIntroLen-4:0)+" ...":articleIntroduction);
        }

        model.addAttribute("tag", tag);
        model.addAttribute("articleList", articleList);
        return "tagArticle";
    }
}
