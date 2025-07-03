package com.thienit.quanlydoanvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thienit.quanlydoanvien.entity.Khoa;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Long> {
	// User findByUsername(String username);
}
