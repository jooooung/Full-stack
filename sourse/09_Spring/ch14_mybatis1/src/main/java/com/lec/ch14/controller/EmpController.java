package com.lec.ch14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch14.dto.Dept;
import com.lec.ch14.dto.Emp;
import com.lec.ch14.service.EmpService;

@Controller
public class EmpController {
	@Autowired 					// service / controller 둘 다 bean이 만들어졌기에 Autowired 가능
	private EmpService service; // controller는 service를 의존

	@ModelAttribute("deptList")
	public List<Dept> deptList() {
		return service.deptList();
	}
	
	@RequestMapping(value = "emp", method = RequestMethod.GET)
	public String emp(@ModelAttribute("schEmp") Emp schEmp, Model model) {
		model.addAttribute("empList", service.empList(schEmp));
		return "emp";
	}
}
