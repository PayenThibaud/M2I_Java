package org.example.exo_spring_forum.repository;

import org.example.exo_spring_forum.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByForum_Id(int id);
}
