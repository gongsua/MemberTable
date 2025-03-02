package service;

import domain.Member;
import repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class Memberservice {
    private final MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    // 회원 가입
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 체크
        Member savedMember = memoryMemberRepository.save(member); // 저장 후 ID 가져오기
        return savedMember.getId();
    }

    // 중복 회원 검증 메서드
    private void validateDuplicateMember(Member member) {
        memoryMemberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalArgumentException("Member already exists");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memoryMemberRepository.findAll(); // ✅ 회원 목록 반환
    }

    // ID로 회원 조회
    public Optional<Member> findMemberById(Long id) {
        return memoryMemberRepository.findById(id);
    }
}
