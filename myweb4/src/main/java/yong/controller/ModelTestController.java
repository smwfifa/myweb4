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
		model.put("msg", "map�� �̿��� ������ ����");
		return "model/modelTest";
	}
	
	@RequestMapping("/modelTest02.do")
	public String modelTest2(Model model){
		model.addAttribute("msg", "Model�� �̿��� ������ ����!");
		return "model/modelTest";
	}
	
	@RequestMapping("/modelTest03.do")
	public String modelmapTest(ModelMap model){					//ModelMap�� Model�� ��ӹ޾� ����ϴ°Ŵ�
		model.addAttribute("msg", "ModelMap�� �̿��� ������ ����!");
		return "model/modelTest";
	}
	
//	@RequestMapping("/model/modelTest.do")
//	public Map<String, String> modelTest3(){
//		HashMap<String, String> model =
//				new HashMap<String, String>();
//		model.put("msg", "HashMap�� ��ȯ�ؼ� �ѱ� ������");
//		return model;
//	}
	
//	@RequestMapping("/model/modelTest.do")
//	public Model modelTest4(){
//		Model model=new ExtendedModelMap();						//�Ű������� ������ ���� ������ �Ѵ�.
//		model.addAttribute("msg", "Model�� ��ȯ�� ������ ������");
//		return model;
//	}
	
	@RequestMapping("/model/modelTest.do")
	public ModelMap modelmapTest2(){
		ModelMap model=new ExtendedModelMap();
		model.addAttribute("msg", "ModelMap�� ��ȯ�� ������ ������");
		return model;
	}
	
	@RequestMapping("/modelTest05.do")
	public ModelAndView modelTest5(){
		ModelAndView mav = new ModelAndView("model/modelTest", "msg", "ModelAndView��ü�� �̿��� ������ ����");
		return mav;
	}
}


/*
		Model �������̽��� �ֿ� �޼���
		
		Model
		[org.springframework.ui.Model �������̽�]
		
		-Model addAttribute(String name,Object value)
		 value��ü�� name�̸����� �߰��Ѵ�.
		 �� �ڵ忡���� name���� ������ �̸��� ���ؼ� value�� ����Ѵ�.
		
		-Model addAttribute(Object value)
		 value�� �߰��Ѵ�.
		 value�� ��Ű�� �̸��� ������ �ܼ� Ŭ���� �̸��� �� �̸����� ����Ѵ�.
		 �̶� ù ���ڴ� �ҹ��ڷ� ó���Ѵ�.
		 value�� �迭�̰ų� �ݷ����� ��� ù��° ������ Ŭ���� �̸� �ڿ�[List]��
		 ���� �� �� �̸����� ����Ѵ�.
		 �� ��쿡�� Ŭ���� �̸��� ù�ڴ� �ҹ��ڷ� ó���Ѵ�.
		
		-Model addAllAttributes(Collection<?> values)
		 addAttribute(Object value)�޼��带 �̿��ؼ�
		 �ݷ��ǿ� ���Ե� ��ü���� ���ʴ�� �߰��Ѵ�.
		
		-Model addAllAttributes(Map<String,?> attributes)
		 Map�� ���Ե� <Ű,��>�� ���� Ű�� �� �̸����� ����ؼ� ���� �𵨷� �߰��Ѵ�.
		
		-Model mergeAttributes(Map<String,?> attributes)
		 Map�� ���Ե� <Ű,��>�� ���� �𵨿� �߰��Ѵ�.
		 ��, Ű�� ������ �̸��� ���� �� ��ü�� �������� �ʴ� ��쿡�� �߰��ȴ�.
		
		-boolean containsAttribute(String name)
		 ������ �̸��� �� ��ü�� �����ϰ� �ִ� ��� true�� �����Ѵ�.
		
		����:ModelMapŬ������ �����ϴ� �𵨼������� �޼��嵵
		�� Model�������̽��� �����ϴ�.


*/