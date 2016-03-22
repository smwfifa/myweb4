package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamTestController {

	@RequestMapping("/paramTest.do")
	public ModelAndView paramTest(
			@RequestParam(value="str", required=false, defaultValue="1") String str, //@RequestParam �� ���� �Ķ���� ���� �޾ƿü� �ְ� ������������ �ڵ� �Ľ��� ���ֱ� ������ parseint�� �Ƚᵵ �ȴ�.
			@RequestParam(value="idx", defaultValue="1") int idx){   //value�� required�� �Է��ؼ� ����ϸ� �Ķ���Ͱ� ��� �ȹް� �����Ҽ� �ִ�. ���⼭ idx�� �Ķ���Ͱ��� ������ null�� �־��ټ� ���� ������ ���.
																					//defalutvalue�� ���� �⺻���� �����Ҽ� ������ �̶� required�Ӽ� ������ �����ϴ�.
		System.out.println("str: "+str+" / idx: "+idx);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("param/paramOk");
		return mav;
	}
}
