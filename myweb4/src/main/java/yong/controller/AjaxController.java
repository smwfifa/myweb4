package yong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yong.emp.model.EmpDTO;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxTest.do")
	public String ajaxTest1(){
		return "ajax/ajaxTest";
	}
	
	@RequestMapping("/ajaxList.do")
	public ModelAndView ajaxTest02(){
		EmpDTO e1 = new EmpDTO(1,"ȫ�浿","hong@naver.com","������");
		EmpDTO e2 = new EmpDTO(2,"ȫ��","hong@naver.co","������");
		EmpDTO e3 = new EmpDTO(3,"ȫ","hong@naver.c","������");
		List<EmpDTO> emps=new ArrayList<EmpDTO>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		ModelAndView mav = new ModelAndView("yongJson","emp",emps);
		return mav;
		
	}
}
