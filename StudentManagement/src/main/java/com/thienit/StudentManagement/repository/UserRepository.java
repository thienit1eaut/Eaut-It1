package com.thienit.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thienit.StudentManagement.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
