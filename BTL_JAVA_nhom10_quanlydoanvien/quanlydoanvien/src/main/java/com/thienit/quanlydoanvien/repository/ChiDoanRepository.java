package com.thienit.quanlydoanvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thienit.quanlydoanvien.entity.ChiDoan;
import com.thienit.quanlydoanvien.entity.DoanVien;

@Repository
public interface ChiDoanRepository extends JpaRepository<ChiDoan, Long> {
	List<ChiDoan> findByDonviContainingIgnoreCaseOrMacdContainingIgnoreCase(String donvi, String macd);
}
