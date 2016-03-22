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
		EmpDTO e1 = new EmpDTO(1,"È«±æµ¿","hong@naver.com","±³À°°ú");
		EmpDTO e2 = new EmpDTO(2,"È«±æ","hong@naver.co","±³À°°ú");
		EmpDTO e3 = new EmpDTO(3,"È«","hong@naver.c","±³À°°ú");
		List<EmpDTO> emps=new ArrayList<EmpDTO>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		ModelAndView mav = new ModelAndView("yongJson","emp",emps);
		return mav;
		
	}
}
