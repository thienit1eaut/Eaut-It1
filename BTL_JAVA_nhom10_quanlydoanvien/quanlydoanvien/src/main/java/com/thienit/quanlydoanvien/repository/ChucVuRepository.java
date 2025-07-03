package com.thienit.quanlydoanvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thienit.quanlydoanvien.entity.ChucVu;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Long> {
	// User findByUsername(String username);
}
