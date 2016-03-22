package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
		// ModelAndView ������Ʈ ��ü
		public ModelAndView hello(){
			ModelAndView mav=new ModelAndView();
			mav.addObject("msg","Spring FrameWork MVC");
			mav.setViewName("hello");
			return mav;
		}
}
