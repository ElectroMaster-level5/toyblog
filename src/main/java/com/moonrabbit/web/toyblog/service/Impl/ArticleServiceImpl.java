package com.moonrabbit.web.toyblog.service.Impl;

import com.moonrabbit.web.toyblog.constants.Constants;
import com.moonrabbit.web.toyblog.entity.Article;
import com.moonrabbit.web.toyblog.repository.ArticleRepository;
import com.moonrabbit.web.toyblog.service.ArticleService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    /**
     * 获取首页博客文章列表，置顶(IsTop=1)且可展示(IsEnable=1)
     * @return
     */
    @Override
    @Cacheable(value="indexPageArticleList")
    public List<Article> findIsTopArticleList() {
        Pageable pageable = PageRequest.of(0, 6, Sort.Direction.DESC, "articleId");
        Page<Article> page = articleRepository.findAllByIsTopAndIsEnable(Constants.YES, Constants.YES, pageable);
        List<Article> articleList = page.getContent();
        for(int i=0; i<articleList.size(); i++){
            Article article = articleList.get(i);
            article.setImageNo(i+1);
        }
        return articleList;
    }

    /**
     * 获取文章列表，要求可展示(IsEnable=1)
     * @param page
     * @param size
     * @return
     */
    @Override
    @Cacheable(value="blogArticle", key="#page")
    public Page<Article> findBlogArticleList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "articleId");
        return articleRepository.findAllByIsEnable(Constants.YES, pageable);
    }

    /**
     * 获取包含关键词的文章列表
     * @param page
     * @param size
     * @param keyword
     * @return
     */
    @Override
    public Page<Article> findSearchArticleList(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "articleId");
        return articleRepository.findAll(this.getWhereClause(keyword), pageable);
    }

    /**
     * 根据articleId获取相应的文章，如果没有输出null
     * @param articleId
     * @return
     */
    @Override
    public Article findArticleByArticleId(Long articleId) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        if(optionalArticle.isPresent()){
            return optionalArticle.get();
        }
        return null;
    }

    /**
     * 根据articleId获取可展示的文章
     * @param articleId
     * @return
     */
    @Override
    public Article findIsEnableArticleByArticleId(Long articleId) {
        return articleRepository.findByIsEnableAndArticleId(Constants.YES, articleId);
    }

    /**
     * 存储一个Article对象到数据库
     * @param article
     */
    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    /**
     * 动态地生成where语句
     * @param keyword
     * @return
     */
    private Specification<Article> getWhereClause(String keyword){
        return new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(keyword)){
                    predicates.add(
                            cb.and(
                                    cb.or(
                                            cb.like(root.get("articleName"), "%"+keyword+"%"),
                                            cb.like(root.get("articleContent"), "%"+keyword+"%")
                                    )
                            )
                    );
                }
                predicates.add(cb.equal(root.get("isEnable"), Constants.YES));
                Predicate[] pre = new Predicate[predicates.size()];
                return query.where(predicates.toArray(pre)).getRestriction();
            }
        };
    }
}
