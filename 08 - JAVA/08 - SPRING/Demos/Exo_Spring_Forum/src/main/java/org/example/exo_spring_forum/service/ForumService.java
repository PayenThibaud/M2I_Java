package org.example.exo_spring_forum.service;

import org.example.exo_spring_forum.entity.Forum;
import org.example.exo_spring_forum.entity.Utilisateur;
import org.example.exo_spring_forum.repository.ForumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {
    private ForumRepository forumRepository;

    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    public Forum getForumById(int id) {
        return forumRepository.findById(id).orElse(null);
    }

    public Forum save(Forum forum) {
        return forumRepository.save(forum);
    }

    public void delete(int id) {
        forumRepository.deleteById(id);
    }
}
