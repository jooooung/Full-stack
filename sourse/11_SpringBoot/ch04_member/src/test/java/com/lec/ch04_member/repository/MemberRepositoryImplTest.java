package com.lec.ch04_member.repository;

import com.lec.ch04_member.model.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryImplTest {
    MemberRepositoryImpl repository = new MemberRepositoryImpl();   // 객체 생성
    @AfterEach  // test 하나 수행 후 save 된 거 clear
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void save와findByNo() {
        Member member = new Member("홍길동", "010-9999-9999");
        repository.save(member);
        Member result = repository.findByNo(member.getNo()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void 멤버리스트() {
        Member member1 = new Member("홍길동", "010-1231-2222");
        Member member2 = new Member("신길동", "010-1231-5555");
        repository.save(member1);
        repository.save(member2);
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}