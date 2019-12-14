package com.moonrabbit.web.toyblog.controller;

import com.moonrabbit.web.toyblog.constants.Constants;
import com.moonrabbit.web.toyblog.entity.Article;
import com.moonrabbit.web.toyblog.service.ArticleService;
import com.moonrabbit.web.toyblog.util.HtmlSpirit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/blog")
    public String blogs(Model model){
        return this.blogsAtPage(model, 1);
    }
    @GetMapping("/blog/{pageNumber}")
    public String blogsAtPage(Model model, @PathVariable Integer pageNumber){

        if(pageNumber == null){
            pageNumber = 1;
        }
        Page<Article> articlePage = articleService.findBlogArticleList(pageNumber -1, Constants.defaultPageSize);
        List<Article> articleList = articlePage.getContent();

        for (Article article : articleList) {
            String articleIntroduction = HtmlSpirit.delHtmlTag(article.getArticleContent());
            article.setArticleIntroduction(articleIntroduction.length()>Constants.blogIntroLen?
                    articleIntroduction.substring(0, Constants.blogIntroLen-4>0?Constants.blogIntroLen-4:0)+" ...":articleIntroduction);
        }
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", articlePage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageListCount",Constants.defaultPageSize);
        model.addAttribute("maxShowPageItem", Constants.maxShowPageItem);
        return "blog";
    }
}
