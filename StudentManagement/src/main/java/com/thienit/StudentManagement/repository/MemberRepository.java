package com.thienit.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thienit.StudentManagement.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
}
