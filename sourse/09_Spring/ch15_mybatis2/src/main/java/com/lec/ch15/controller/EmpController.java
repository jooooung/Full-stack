package com.lec.ch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.model.Emp;
import com.lec.ch15.serivce.EmpService;
import com.lec.ch15.utill.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value = "empList", method = RequestMethod.GET)  // emp
	public String empList(String pageNum, Model model) {
		model.addAttribute("empList", empService.empList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empList";
	}
	
	@RequestMapping(value = "empDeptList", method = {RequestMethod.GET, RequestMethod.POST})	// empDept
	public String empDeptList(String pageNum, Model model) {
		model.addAttribute("empDeptList", empService.empDeptList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 10));
		return "empList";
	}
	
	@RequestMapping(value = "dummyInsert", method = RequestMethod.GET)	// 더미데이터
	public String dummyInsert() {
		empService.dummyDataInsert50();
		return "redirect:empList.do";
	}
	
	@RequestMapping(value = "detail", method = {RequestMethod.GET, RequestMethod.POST})	// 상세보기
	public String detail(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "detail";
	}
	
	@RequestMapping(value = "updateView", method = {RequestMethod.GET, RequestMethod.POST})	// 수정 페이지
	public String updateView(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		model.addAttribute("deptList", empService.deptList());	// 부서코드 select 용
		return "update";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)	// 수정 정보 저장
	public String update(Emp emp, Model model) {
		try {
			model.addAttribute("modifyResult", empService.update(emp));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("modifyResult", "필드 값이 너무 길어요");
			return "forward:updateView.do";
		}	// 압력값 길게 칠 시 에러 처리
		return "forward:detail.do";		// 수정 후 상세보기 페이지
		//return "forward:empDeptList.do";	// 수정 후 리스트 페이지
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)	// 직원 삭제
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empService.delete(empno));
		return "forward:empDeptList.do";	// 삭제 후 리스트 페이지
	}
}
