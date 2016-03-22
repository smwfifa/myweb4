package yong.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CookieController {
	
	@RequestMapping("/cookieView.do")
	public ModelAndView cookieView(@CookieValue(value="saveId", required = false, defaultValue="No ID")String saveId){
		System.out.println("saveId쿠키정보: "+saveId);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cookie/cookieOk");
		return mav;
	}
	
	@RequestMapping("/cookieMake.do")
	public ModelAndView cookieMake(HttpServletResponse resp){ 
		//1. 객체생성
		Cookie ck=new Cookie("saveId", "hong");
		//2. 나이지정
		ck.setMaxAge(60*5); //5분
		//3. 사용자에게 심기
		resp.addCookie(ck);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cookie/cookieOk");
		return mav;
	}
	
	@RequestMapping("/sessionMake.do")
	public ModelAndView sessionMake(HttpServletRequest req){
		HttpSession session=req.getSession();
		session.setAttribute("sname", "홍길동");
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cookie/cookieOk");
		return mav;
	}
	
	@RequestMapping("/sessionView.do")
	public ModelAndView sessionView(HttpSession session){			//HttepSession을 넣으면 null이 될 수 없다.
		String name=(String)session.getAttribute("sname");
		System.out.println("name: "+name);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cookie/cookieOk");
		return mav;
		
	}
}
