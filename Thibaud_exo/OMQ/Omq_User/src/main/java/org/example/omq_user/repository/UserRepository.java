package org.example.omq_user.repository;

import org.apache.catalina.User;
import org.example.omq_user.entity.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository<UserApp, Integer> {
    UserApp findByEmail (String email);
}
