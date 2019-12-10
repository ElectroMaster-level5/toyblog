package com.moonrabbit.web.toyblog.repository;

import com.moonrabbit.web.toyblog.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
