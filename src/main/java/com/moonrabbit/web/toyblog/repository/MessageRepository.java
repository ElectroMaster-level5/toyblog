package com.moonrabbit.web.toyblog.repository;

import com.moonrabbit.web.toyblog.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
