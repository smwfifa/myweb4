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
		int total_cnt=bbsDao.getTotalCnt();			//��ü �Խù� ���� ���ϱ�
		total_cnt=total_cnt==0?1:total_cnt;
		int listSize=10; //������ ����Ʈ��
		int pageSize=5;	//������ ��������
		String pagename="bbsList.do";
		String pageStr=yong.page.PageMaker.goPage(pagename, total_cnt, listSize, pageSize, cp);
		List<BbsDTO> list = bbsDao.bbsAllList(listSize, cp);		//List ��� ����
	
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
		String msg=result>0?"��Ͽ� �����Ͽ����ϴ�.":"��Ͽ� �����߽��ϴ�.";
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
