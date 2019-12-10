package com.moonrabbit.web.toyblog.controller;

import com.moonrabbit.web.toyblog.entity.Article;
import com.moonrabbit.web.toyblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleService;
    @GetMapping(value={"/", "index"})
    public String index(Model model){
        model.addAttribute("articleList", articleService.findIsTopArticleList());
        return "index";
    }
}
