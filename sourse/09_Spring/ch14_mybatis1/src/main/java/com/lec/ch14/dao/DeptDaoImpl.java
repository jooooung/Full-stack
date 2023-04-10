package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.dto.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSession sessionTemplate;	// sqlSessionFactory를 참조하므로 Autowired

	@Override
	public List<Dept> deptList() {
		// Dept.xml에서 sql을 수행한 결과를 return
		return sessionTemplate.selectList("deptList");
	}
}
