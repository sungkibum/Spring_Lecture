package inhatc.spring.shop.service;

import inhatc.spring.shop.dto.MemberFormDto;
import inhatc.spring.shop.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member createMember() {
        MemberFormDto memberFormDto = MemberFormDto.builder()
                .address("인천시 미추홀구")
                .email("test@test.com")
                .name("홍길동")
                .password("1111")
                .build();

        System.out.println("memberFormDto = " + memberFormDto);

        Member member = Member.createMember(memberFormDto, passwordEncoder);
        System.out.println("member = " + member);
        return member;
    }


    @Test
    @Transactional
    void saveMemberTest() {
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);
        System.out.println("savedMember = " + savedMember);

        assertEquals(member.getName(), savedMember.getName());

    }

    @Test
    @DisplayName("중복 가입 테스트")
    @Transactional
    void saveMemberTest2() {
        Member member1 = createMember();
        Member savedMember1 = memberService.saveMember(member1);
        Member member2 = createMember();
        Throwable e = assertThrows(IllegalStateException.class, () -> {
            memberService.saveMember(member2);
        });

        assertEquals("이미 존재하는 회원입니다.", e.getMessage());


    }
}