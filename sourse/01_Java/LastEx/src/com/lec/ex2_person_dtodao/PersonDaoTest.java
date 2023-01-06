package com.lec.ex2_person_dtodao;

import java.util.ArrayList;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		System.out.println("---------------1번 테스트--------------");
		PersonDto dto = new PersonDto("홍길동", "배우", 60, 50, 70);
		dao.insertPerson(dto);
		System.out.println("---------------2번 직업명 출력 테스트--------------");
		ArrayList<PersonDto> dtos = dao.selectJname("가수");
		if (dtos.isEmpty()) {
			System.out.println("해당 직업을 가진 사람이 없습니다");
		} else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
		}
		System.out.println("배우 검색결과");
		dtos = dao.selectJname("배우");
		if (dtos.size() != 0) {
			for (int idx = 0; idx < dtos.size(); idx++) {
				System.out.println(dtos.get(idx));
			}
		} else {
			System.out.println("해당 직업을 가진 사람이 없습니다");
		}
		System.out.println("---------- 3번 ----------------");
		dtos = dao.selectAll();
		if(dtos.isEmpty()) {
			System.out.println("등록된 사람이 없습니다.");
		}else {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}//for
		}//if
		System.out.println("직업명 : " + dao.jnamelist());
	}//main
}
