package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewTestController {
	@RequestMapping("/viewTest.do")
	public ModelAndView viewTest1(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("viewTest/viewTest");			//명시적 뷰 지정
		return mav;
	}
	
	@RequestMapping("/viewTest/viewTest.do")			//묵시적 or 암시적 뷰 지정방법
	public void viewTest2(){
		
	}
	
	@RequestMapping("/viewTest2.do")
	public String viewTest3(){
		return "redirect:/hello.do";					//viewTest2.do를 실행하고 나서 hello.do를 실행한다.
	}
	
	/*
	 * 컨트롤러 반환타입 종류
	 @RequestMapping 메서드의 리턴 타입

		-ModelAndView
		 뷰 정보 및 모델 정보를 담고 있는 ModelAndView객체.
		
		-Model
		 뷰에 전달할 객체 정보를 담고 있는 Model을 리턴한다.
		 이때, 뷰 이름은 요청 URL로부터 결정된다.
		 (RequestToViewNameTranslator를 통해 뷰 결정)
		
		-Map
		 뷰에 전달할 객체 정보를 담고 있는 Map을 리턴한다.
		 이때 뷰 이름은 요청 URL로 부터 결정된다.
		 (RequestToViewNameTranslator를 통해 뷰 결정)
		
		-String 
		 뷰 이름을 리턴한다.
		
		-View 객체
		 View객체를 직접리턴.
		 해당 View객체를 이용해서 뷰를 생성한다.
		
		-void
		 메서드가 ServletResponse나 HttpServletResponse 타입의 
		 파라미터를 갖는 경우 메서드가 직접 응답을 처리한다고 가정한다.
		 그렇지 않을 경우 요청 URL로 부터 결정된 뷰를 보여준다.
		 (RequestToViewNameTranslator를 통해 뷰 결정)
		
		-@ResponseBody어노테이션 적용
		 메서드에서 @ResponseBody 어노테이션이 적용된 경우,
		 리턴 객체를 HTTP 응답으로 전송한다.
		 HttpMessageConverter를 이용해서 객체를 HTTP응답 스트림으로 변환한다.
 */
}
