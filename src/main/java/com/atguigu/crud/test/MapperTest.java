package com.atguigu.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.DepartmentExample;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;


/**
 * 测试dao层的工作
 *推荐spring的项目就可以使用spring的单元测试，可以自动注入我们需要的组件
 *1.maven导入springtest模板
 *2.@ContextConfiguration指定spring配置文件的位置
 *3.直接@Autowired 要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCURD(){
	/*	//1.创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从容器中获取mapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		System.out.println(departmentMapper);
		
		//1.插入几个部门
		//departmentMapper.insertSelective(new Department(1, "开部"));
		//departmentMapper.insertSelective(new Department(2, "测部"));
		//删除部门
		//departmentMapper.deleteByPrimaryKey(1);
		
		//2.生成员工数据，测试员工插入
		employeeMapper.insertSelective(new Employee(null, "halo", "M", "tom@qq.com", 1));
		//3.批量插入多个员工;批量，使用可以执行批量操作的sqlSession
		
		/*EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		
		for(int i =0;i<1000;i++){
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uid, "M",	uid + "@qq.com", 1));
		}
		System.out.println("批量完成");*/
	}
}
