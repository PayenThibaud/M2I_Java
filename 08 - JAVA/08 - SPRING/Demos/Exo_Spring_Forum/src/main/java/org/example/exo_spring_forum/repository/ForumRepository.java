package org.example.exo_spring_forum.repository;

import org.example.exo_spring_forum.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Integer> {
}
