package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ����Ա��crud����
 *
 */

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	
	/**
	 * ��ѯԱ������(��ҳ��ѯ)
	 *
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1") Integer pn,
			Model model){
		
		//�ⲻ��һ����ҳ��ѯ
		//����PageHelper��ҳ���
		//�ڲ�ѯ֮ǰֻ��Ҫ����,����ҳ���Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		//startPage���������һ����ѯ����һ����ҳ
		List<Employee> emps = employeeservice.getAll();
		//ʹ��pageinfo��װ��ѯ��Ľ����ֻ��Ҫ��pageinfo����ҳ�������
		//��װ��ϸ�ķ�ҳ��Ϣ���������ǲ�ѯ����������,����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo",page);
		return "list";
	}
}