package com.moonrabbit.web.toyblog.repository;

import com.moonrabbit.web.toyblog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
// JpaSpecificationExecutor用于完成多条件查询，并且支持分页与排序
// 该接口不能单独使用
public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
    Page<Article> findAllByIsTopAndIsEnable(Integer isTop, Integer isEnable, Pageable pageable);

    Article findByIsEnableAndArticleId(Integer isEnable, Long articleId);

    Page<Article> findAllByIsEnable(Integer isEnable, Pageable pageable);
}
