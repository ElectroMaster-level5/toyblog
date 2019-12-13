package com.moonrabbit.web.toyblog.controller;

import com.moonrabbit.web.toyblog.entity.Article;
import com.moonrabbit.web.toyblog.service.ArticleService;
import com.moonrabbit.web.toyblog.util.MarkdownToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/article/{id}")
    public String showArticle(Model model, @PathVariable Long id){
        Article article = articleService.findIsEnableArticleByArticleId(id);
        article.setArticleReadingTime((article.getArticleReadingTime()+1));
        articleService.saveArticle(article);

        // raw content -> show content
        article.setArticleShowContent(MarkdownToHtml.markDownToHtml(article.getArticleContent()));

        model.addAttribute("article", article);
        return "article";
    }
}
