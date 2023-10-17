package com.example.userservice.repository;

import com.example.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUuid(String uuid);
}
