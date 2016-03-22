package yong.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {
	
	@ModelAttribute("str")											//���� ���������� ���޵Ǵ� ����������鿡 ���޵ȴ�.
	public String[] getStr(){
		return new String[]{"¯��", "�����", "��Ϲ���Ĩ", "�����۽�"};
		
	}
	
	@ModelAttribute("cate")											//���� ���������� ���޵Ǵ� ����������鿡 ���޵ȴ�.
	public String[] getCate(){
		return new String[]{"�����","����","���","����ǰ","���̽�ũ��"};	
			
	}
	
	@RequestMapping("/food/foodFind1.do")
	public String foodFind1(Map model){
	
		
		//String str1[]={"¯��","���̿�","��Ϲ���Ĩ","�����۽�"};
		//String cate[]={"����","���","����ǰ","���̽�ũ��"};
		//model.put("str", getStr());
		//model.put("cate", getCate());
		return "food/foodFind1";
	}
	
	@RequestMapping("/food/foodFind2.do")
	public String foodFind2(Map model){
		//String str1[]={"¯��","���̿�","��Ϲ���Ĩ","�����۽�"};
		//String cate[]={"����","���","����ǰ","���̽�ũ��"};
		//model.put("str", getStr());
		//model.put("cate", getCate());
		return "food/foodFind2";
	}
}
