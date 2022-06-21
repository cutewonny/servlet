package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    //무조건 이걸로 조회함
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();;
    }

    @Test
    void getInstance() {
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello",20);

        //when
        Member savedMember = memberRepository.save(member);
        
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        
        //찾은 객체와 저장한 객체는 같다
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        //given : 회원 2명을 저장한다
        Member member1 = new Member("mem1",20);
        Member member2 = new Member("mem2",30);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when: 모든 회원을 조회한다
        List<Member> all = memberRepository.findAll();//store에 저장된 값들을 리턴한다

        //then : 회원은 총 2명이다
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(member1,member2);
    }

    @Test
    void clearStore() {
    }
}