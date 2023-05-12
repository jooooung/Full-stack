package com.lec.ch04_member.repository;

import com.lec.ch04_member.model.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
    // DB 없이 작업하기 위한 것들
    private static Map<Integer, Member> store = new HashMap<>();
    private static int sequence;

    @Override
    public void save(Member member) {
        member.setNo(++sequence);
        store.put(member.getNo(), member);
    }

    @Override
    public Optional<Member> findByNo(int no) {
        return Optional.ofNullable(store.get(no));  // Optional.ofNullable : null 에러 처리
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){ // 메소드 하나 테스트 할 때 지우는 로직
        store.clear();
    }
}
