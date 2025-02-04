package com.example.demo.repository.member;

import com.example.demo.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository {

    private final SpringDataJpaMemberRepository repository;
    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<Member> increaseCount(String email) {
        Optional<Member> member = findByEmail(email);
        if (member.isPresent()) {
            Member foundMember = member.get();
            foundMember.setCount(foundMember.getCount() + 1); // count 증가
            repository.save(foundMember); // 수정된 멤버 저장
            return Optional.of(foundMember); // 증가된 멤버 반환
        }
        return Optional.empty(); // 멤버가 존재하지 않으면 빈 Optional 반환
    }

    @Override
    public Optional<Member> input(String email, String input) {
        Optional<Member> member = findByEmail(email);
        if (member.isPresent()) {
            Member foundMember = member.get();
            foundMember.setProfile(input);
            repository.save(foundMember); // 수정된 멤버 저장
        }
        return member;
    }


}
