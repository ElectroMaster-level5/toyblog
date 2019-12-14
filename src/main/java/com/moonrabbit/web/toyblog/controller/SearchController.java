package com.moonrabbit.web.toyblog.controller;

import com.moonrabbit.web.toyblog.constants.Constants;
import com.moonrabbit.web.toyblog.entity.Article;
import com.moonrabbit.web.toyblog.service.ArticleService;
import com.moonrabbit.web.toyblog.util.HtmlSpirit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/search")
    public String search(Model model, Integer pageNumber, String keyword){
        if(StringUtils.isEmpty(keyword)){
            return "search";
        }else if(pageNumber == null){
            pageNumber = 1;
        }

        Page<Article> articlePage = articleService.findSearchArticleList(pageNumber-1, Constants.defaultPageSize, keyword );
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
        model.addAttribute("keyword", keyword);
        return "search";
    }
}
