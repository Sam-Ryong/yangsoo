package com.example.demo.repository.member;

import com.example.demo.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> {

}
