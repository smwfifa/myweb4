package yong.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {
	
	@ModelAttribute("str")											//현재 페이지에서 전달되는 모든페이지들에 전달된다.
	public String[] getStr(){
		return new String[]{"짱구", "새우깡", "허니버터칩", "프링글스"};
		
	}
	
	@ModelAttribute("cate")											//현재 페이지에서 전달되는 모든페이지들에 전달된다.
	public String[] getCate(){
		return new String[]{"음료수","과자","라면","유제품","아이스크림"};	
			
	}
	
	@RequestMapping("/food/foodFind1.do")
	public String foodFind1(Map model){
	
		
		//String str1[]={"짱구","뻥이요","허니버터칩","프링글스"};
		//String cate[]={"과자","라면","유제품","아이스크림"};
		//model.put("str", getStr());
		//model.put("cate", getCate());
		return "food/foodFind1";
	}
	
	@RequestMapping("/food/foodFind2.do")
	public String foodFind2(Map model){
		//String str1[]={"짱구","뻥이요","허니버터칩","프링글스"};
		//String cate[]={"과자","라면","유제품","아이스크림"};
		//model.put("str", getStr());
		//model.put("cate", getCate());
		return "food/foodFind2";
	}
}
