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
//클래스 위에다 Cotroller를 적어두면 공통된 명령어로 접근이 가능하다.
public class MemoController {
	
	@Autowired					//
	private MemoDAO memoDao;	//dispatcer-servlet service의 id와 이름이 같아야된다.
	
	public MemoDAO getMemoDao() {
		return memoDao;
	}

	public void setMemoDao(MemoDAO memoDao) {
		this.memoDao = memoDao;
	}

	//명령어를 전에는 클래스 단위로 만들어서 파일이 많아졌지만 Spring에서는 메소드 단위로 관리가 가능해져 편안해진다.
	@RequestMapping(value="/memoWrite.do", method=RequestMethod.GET)		//RequestMapping을 통해 servlet에 등록을 안해도 된다
	public ModelAndView memoForm(){
		ModelAndView mav=new ModelAndView();								//ModelAndView 객체 생성
		mav.setViewName("memo/memoForm");									//view에 이름을 셋팅한다.
		return mav;
	}
	
	//value="주소이름", method=받는방식으로 진입방식의 변경이 가능하다.
	@RequestMapping(value="/memoWrite.do", method=RequestMethod.POST)
	public ModelAndView memoWrite(											//Form이 가지고 있는 이름과 DTO의 이름이 같다면 DTO를 매개변수로 넣을수 있다.
			@ModelAttribute("cmd")MemoDTO command){							//ModelAttribute로 별칭을 넣어줄 수 있다.
		System.out.println(command.toString());
		memoDao.memoWrite(command);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("memo/memoOk");
		return mav;
	}
	
	
	// 	DAO: DAO, Service
	//	DTO: Command, DTO
}
