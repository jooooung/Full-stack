package com.lec.ch14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch14.dao.DeptDao;
import com.lec.ch14.dao.EmpDao;
import com.lec.ch14.dto.Dept;
import com.lec.ch14.dto.Emp;

@Service
public class EmpServiceEmpl implements EmpService {
	@Autowired
	private EmpDao eDao; // service는 dao를 의존
	@Autowired
	private DeptDao dDao;
	
	@Override
	public List<Emp> empList(Emp schEmp) {
		// 검색 시 대소문자 상관없이 대문자로 만들기
		if(schEmp.getEname() != null) {
			schEmp.setEname(schEmp.getEname());
		}
		if(schEmp.getJob() != null) {
			schEmp.setJob(schEmp.getJob());
		}
		return eDao.empList(schEmp);
	}

	@Override
	public List<Dept> deptList() {
		return dDao.deptList();
	}

}
