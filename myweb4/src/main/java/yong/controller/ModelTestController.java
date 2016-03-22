package yong.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelTestController {
	
	@RequestMapping("/modelTest01.do")
	public String modelTest1(Map model){
		model.put("msg", "map을 이용한 데이터 전달");
		return "model/modelTest";
	}
	
	@RequestMapping("/modelTest02.do")
	public String modelTest2(Model model){
		model.addAttribute("msg", "Model을 이용한 데이터 전달!");
		return "model/modelTest";
	}
	
	@RequestMapping("/modelTest03.do")
	public String modelmapTest(ModelMap model){					//ModelMap은 Model을 상속받아 사용하는거다
		model.addAttribute("msg", "ModelMap을 이용한 데이터 전달!");
		return "model/modelTest";
	}
	
//	@RequestMapping("/model/modelTest.do")
//	public Map<String, String> modelTest3(){
//		HashMap<String, String> model =
//				new HashMap<String, String>();
//		model.put("msg", "HashMap을 반환해서 넘긴 데이터");
//		return model;
//	}
	
//	@RequestMapping("/model/modelTest.do")
//	public Model modelTest4(){
//		Model model=new ExtendedModelMap();						//매개변수가 없을땐 직접 만들어야 한다.
//		model.addAttribute("msg", "Model을 반환해 전달한 데이터");
//		return model;
//	}
	
	@RequestMapping("/model/modelTest.do")
	public ModelMap modelmapTest2(){
		ModelMap model=new ExtendedModelMap();
		model.addAttribute("msg", "ModelMap을 반환해 전달한 데이터");
		return model;
	}
	
	@RequestMapping("/modelTest05.do")
	public ModelAndView modelTest5(){
		ModelAndView mav = new ModelAndView("model/modelTest", "msg", "ModelAndView객체를 이용한 데이터 전달");
		return mav;
	}
}


/*
		Model 인터페이스의 주요 메서드
		
		Model
		[org.springframework.ui.Model 인터페이스]
		
		-Model addAttribute(String name,Object value)
		 value객체를 name이름으로 추가한다.
		 뷰 코드에서는 name으로 지정한 이름을 통해서 value를 사용한다.
		
		-Model addAttribute(Object value)
		 value를 추가한다.
		 value의 패키지 이름을 제외한 단순 클래스 이름을 모델 이름으로 사용한다.
		 이때 첫 글자는 소문자로 처리한다.
		 value가 배열이거나 콜렉션인 경우 첫번째 원소의 클래스 이름 뒤에[List]를
		 붙인 걸 모델 이름으로 사용한다.
		 이 경우에도 클래스 이름의 첫자는 소문자로 처리한다.
		
		-Model addAllAttributes(Collection<?> values)
		 addAttribute(Object value)메서드를 이용해서
		 콜렉션에 포함된 객체들을 차례대로 추가한다.
		
		-Model addAllAttributes(Map<String,?> attributes)
		 Map에 포함된 <키,값>에 대해 키를 모델 이름으로 사용해서 값을 모델로 추가한다.
		
		-Model mergeAttributes(Map<String,?> attributes)
		 Map에 포함된 <키,값>을 현재 모델에 추가한다.
		 단, 키와 동일한 이름을 갖는 모델 객체가 존재하지 않는 경우에만 추가된다.
		
		-boolean containsAttribute(String name)
		 지정한 이름의 모델 객체를 포함하고 있는 경우 true를 리턴한다.
		
		참고:ModelMap클래스가 제공하는 모델설정관련 메서드도
		위 Model인터페이스와 동일하다.


*/