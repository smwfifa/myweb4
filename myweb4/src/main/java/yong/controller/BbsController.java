package yong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;

@Controller
public class BbsController {

	@Autowired
	private BbsDAO bbsDao;
	
	public BbsDAO getBbsDao() {
		return bbsDao;
	}

	public void setBbsDao(BbsDAO bbsDao) {
		this.bbsDao = bbsDao;
	}

	@RequestMapping("/bbsList.do")
	public ModelAndView bbsList(@RequestParam(value="cp", defaultValue="1")int cp){
		ModelAndView mav = new ModelAndView();
		int total_cnt=bbsDao.getTotalCnt();			//전체 게시물 갯수 구하기
		total_cnt=total_cnt==0?1:total_cnt;
		int listSize=10; //보여줄 리스트수
		int pageSize=5;	//보여줄 페이지수
		String pagename="bbsList.do";
		String pageStr=yong.page.PageMaker.goPage(pagename, total_cnt, listSize, pageSize, cp);
		List<BbsDTO> list = bbsDao.bbsAllList(listSize, cp);		//List 모든 저장
	
		mav.addObject("list", list);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("bbs/bbsList");
		return mav;
	}
	
	@RequestMapping("/bbsWriteForm.do")
	public String bbsWriteForm(){
		
		return "bbs/bbsWriteForm";
	}
	
	@RequestMapping("/bbsWrite.do")
	public ModelAndView bbsWrite(BbsDTO dto){
		
		ModelAndView mav = new ModelAndView();
		int result=bbsDao.bbsWrite(dto);
		String msg=result>0?"등록에 성공하였습니다.":"등록에 실패했습니다.";
		mav.addObject("msg", msg);
		mav.setViewName("bbs/bbsMsg");
		return mav;
	}
	
	@RequestMapping("/bbsContent.do")
	public ModelAndView bbsContent(@RequestParam("idx")int idx){
		ModelAndView mav=new ModelAndView();
		List<BbsDTO> content=bbsDao.bbsContent(idx);
		mav.addObject("content", content);
		mav.setViewName("bbs/bbsContent");
		return mav;
	}
}
