package com.moonrabbit.web.toyblog.repository;

import com.moonrabbit.web.toyblog.entity.WebsiteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface WebsiteAccessRepository extends JpaRepository<WebsiteAccess, Long> {
    WebsiteAccess getByAccessDateIs(Date accessDate);
}
