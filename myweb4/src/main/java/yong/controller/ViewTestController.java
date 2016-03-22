package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewTestController {
	@RequestMapping("/viewTest.do")
	public ModelAndView viewTest1(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("viewTest/viewTest");			//����� �� ����
		return mav;
	}
	
	@RequestMapping("/viewTest/viewTest.do")			//������ or �Ͻ��� �� �������
	public void viewTest2(){
		
	}
	
	@RequestMapping("/viewTest2.do")
	public String viewTest3(){
		return "redirect:/hello.do";					//viewTest2.do�� �����ϰ� ���� hello.do�� �����Ѵ�.
	}
	
	/*
	 * ��Ʈ�ѷ� ��ȯŸ�� ����
	 @RequestMapping �޼����� ���� Ÿ��

		-ModelAndView
		 �� ���� �� �� ������ ��� �ִ� ModelAndView��ü.
		
		-Model
		 �信 ������ ��ü ������ ��� �ִ� Model�� �����Ѵ�.
		 �̶�, �� �̸��� ��û URL�κ��� �����ȴ�.
		 (RequestToViewNameTranslator�� ���� �� ����)
		
		-Map
		 �信 ������ ��ü ������ ��� �ִ� Map�� �����Ѵ�.
		 �̶� �� �̸��� ��û URL�� ���� �����ȴ�.
		 (RequestToViewNameTranslator�� ���� �� ����)
		
		-String 
		 �� �̸��� �����Ѵ�.
		
		-View ��ü
		 View��ü�� ��������.
		 �ش� View��ü�� �̿��ؼ� �並 �����Ѵ�.
		
		-void
		 �޼��尡 ServletResponse�� HttpServletResponse Ÿ���� 
		 �Ķ���͸� ���� ��� �޼��尡 ���� ������ ó���Ѵٰ� �����Ѵ�.
		 �׷��� ���� ��� ��û URL�� ���� ������ �並 �����ش�.
		 (RequestToViewNameTranslator�� ���� �� ����)
		
		-@ResponseBody������̼� ����
		 �޼��忡�� @ResponseBody ������̼��� ����� ���,
		 ���� ��ü�� HTTP �������� �����Ѵ�.
		 HttpMessageConverter�� �̿��ؼ� ��ü�� HTTP���� ��Ʈ������ ��ȯ�Ѵ�.
 */
}
