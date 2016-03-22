package yong.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yong.member.model.MemberDAO;
import yong.member.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO memberDao;
	
	public MemberDAO getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String joinForm(){
		
		return "member/join";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView joinsubmit(MemberDTO dto){
		int result=memberDao.memberJoin(dto);
		String msg=result>0?"회원 가입 축하합니다.":"회원 가입에 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("url", "index.do");
		mav.setViewName("member/memberMsg");
		return mav;
	}
	
	@RequestMapping("/idCheckForm.do")
	public String idCheckForm(){
		return "member/idCheck";
	}
	
	@RequestMapping("/idCheck.do")
	public ModelAndView idCheck(@RequestParam(value="userid", required=false, defaultValue="xxx")String userid){
		System.out.println(userid);
		boolean result=memberDao.idCheck(userid);
		ModelAndView mav=new ModelAndView();
		String msg=result?"이미 등록되어 있는 아이디입니다.":"사용 가능한 아이디입니다.";
		System.out.println(msg);
		mav.addObject("msg", msg);
		mav.setViewName("member/idCheck_ok2");
//		mav.addObject("result", result);
//		mav.addObject("userid", userid);
//		mav.setViewName("member/idCheck_ok");
		return mav;
	}
	
	@RequestMapping("/loginForm.do")
	public String loginForm(){
		return "member/login";
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(@RequestParam("id")String id, @RequestParam("pwd")String pwd, HttpSession session){
		int result=memberDao.loginCheck(id,  pwd);
		
		String msg="";
		String url="";
		ModelAndView mav=new ModelAndView();
		if(result==memberDao.NOT_ID){
			msg="등록되어있는 아이디가 아닙니다.";
			url="loginForm.do";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("member/memberMsg");
		}else if(result==memberDao.NOT_PWD){
			msg="잘못된 비밀번호입니다.";
			url="loginForm.do";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("member/memberMsg");
		}else if(result==memberDao.LOGIN_OK){
			String name=memberDao.getUserInfo(id);
			mav.addObject("name", name);
			mav.setViewName("member/login_ok");
			session.setAttribute("sname", name);
			session.setAttribute("sid", id);
		}
		return mav;
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.do";
		
	}
}
