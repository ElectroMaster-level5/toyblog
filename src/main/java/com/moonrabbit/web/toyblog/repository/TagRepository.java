package com.moonrabbit.web.toyblog.repository;

import com.moonrabbit.web.toyblog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);
}
