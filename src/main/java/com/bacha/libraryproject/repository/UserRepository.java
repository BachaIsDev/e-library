package com.bacha.libraryproject.repository;

import com.bacha.libraryproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
