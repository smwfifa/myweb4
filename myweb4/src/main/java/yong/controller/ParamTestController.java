package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamTestController {

	@RequestMapping("/paramTest.do")
	public ModelAndView paramTest(
			@RequestParam(value="str", required=false, defaultValue="1") String str, //@RequestParam 을 통해 파라미터 값을 받아올수 있고 스프링에서는 자동 파싱을 해주기 때문에 parseint를 안써도 된다.
			@RequestParam(value="idx", defaultValue="1") int idx){   //value와 required를 입력해서 사용하면 파라미터가 없어도 안받게 셋팅할수 있다. 여기서 idx에 파라미터값이 없으면 null을 넣어줄수 없어 에러가 뜬다.
																					//defalutvalue를 통해 기본값을 셋팅할수 있으며 이땐 required속성 생략이 가능하다.
		System.out.println("str: "+str+" / idx: "+idx);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("param/paramOk");
		return mav;
	}
}
