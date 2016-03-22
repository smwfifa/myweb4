package yong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import yong.memo.model.MemoDAO;
import yong.memo.model.MemoDTO;

@Controller
//@RequestMapping("/memeoWrite.do")
//Ŭ���� ������ Cotroller�� ����θ� ����� ��ɾ�� ������ �����ϴ�.
public class MemoController {
	
	@Autowired					//
	private MemoDAO memoDao;	//dispatcer-servlet service�� id�� �̸��� ���ƾߵȴ�.
	
	public MemoDAO getMemoDao() {
		return memoDao;
	}

	public void setMemoDao(MemoDAO memoDao) {
		this.memoDao = memoDao;
	}

	//��ɾ ������ Ŭ���� ������ ���� ������ ���������� Spring������ �޼ҵ� ������ ������ �������� ���������.
	@RequestMapping(value="/memoWrite.do", method=RequestMethod.GET)		//RequestMapping�� ���� servlet�� ����� ���ص� �ȴ�
	public ModelAndView memoForm(){
		ModelAndView mav=new ModelAndView();								//ModelAndView ��ü ����
		mav.setViewName("memo/memoForm");									//view�� �̸��� �����Ѵ�.
		return mav;
	}
	
	//value="�ּ��̸�", method=�޴¹������ ���Թ���� ������ �����ϴ�.
	@RequestMapping(value="/memoWrite.do", method=RequestMethod.POST)
	public ModelAndView memoWrite(											//Form�� ������ �ִ� �̸��� DTO�� �̸��� ���ٸ� DTO�� �Ű������� ������ �ִ�.
			@ModelAttribute("cmd")MemoDTO command){							//ModelAttribute�� ��Ī�� �־��� �� �ִ�.
		System.out.println(command.toString());
		memoDao.memoWrite(command);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("memo/memoOk");
		return mav;
	}
	
	
	// 	DAO: DAO, Service
	//	DTO: Command, DTO
}
