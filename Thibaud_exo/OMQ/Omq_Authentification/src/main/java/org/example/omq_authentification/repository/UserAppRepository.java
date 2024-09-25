package org.example.omq_authentification.repository;

import org.example.omq_authentification.entity.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends CrudRepository<UserApp, Integer> {
    Optional<UserApp> findByEmail (String email);
}
