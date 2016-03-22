package yong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import yong.game.model.GameAddDTO;

@Controller			//Controller로 등록하기
@RequestMapping("/gameAdd.do")
public class GameController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView gameAddForm(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("game/gameAddForm");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gameAddSubmit(GameAddDTO dto){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("game/gameAddResult");
		return mav;
	}
		
	
}
