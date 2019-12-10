package com.moonrabbit.web.toyblog.repository;

import com.moonrabbit.web.toyblog.entity.WebsiteConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteConfigRepository extends JpaRepository<WebsiteConfig, Long> {
}
