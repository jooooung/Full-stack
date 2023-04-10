package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.dto.Emp;

@Repository
public class EmpDaoEmpl implements EmpDao {
	@Autowired
	private SqlSession sessionTemplate; // sqlSessionFactory를 참조하므로 Autowired

	@Override
	public List<Emp> empList(Emp schEmp) {
		return sessionTemplate.selectList("empList", schEmp);
	}
}
