package yong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

@Controller
public class EmpController {

	@Autowired					//생성자 주입방식을 활용하려면 @AutoWired를 부착해야된다.
	private EmpDAO empDao;
	
	public EmpDAO getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDAO empDao) {
		this.empDao = empDao;
	}

	@RequestMapping("/emp.do")
	public String empMain(){
		return "emp/emp";
	}
	
	@RequestMapping("/empAdd.do")
	public ModelAndView empAdd(EmpDTO dto){
		int result=empDao.empAdd(dto);
		String msg=result>0?"사원 등록 성공!":"사원 등록 실패";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("emp/empMsg");
		return mav;
	}
	
	@RequestMapping("/empDel.do")
	public ModelAndView empDel(EmpDTO dto){
		int result=empDao.empDel(dto);
		String msg=result>0?"사원 삭제 성공":"사원 삭제 실패";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("emp/empMsg");
		return mav;
	}
	
	@RequestMapping("/empList.do")
	public ModelAndView empList(){
		List<EmpDTO> list=empDao.empAllList();
		ModelAndView mav=new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("emp/empList");
		return mav;
	}
	
	@RequestMapping("/empSearch.do")
	public ModelAndView empSearch(@RequestParam(value="name", required=false, defaultValue="하이요") String name){
		System.out.println(name);
		List<EmpDTO> list=empDao.empSearch(name);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("emp/empList");
		return mav;
	}
	
	@RequestMapping("/empUpdate.do")
	public ModelAndView empUpdate(@RequestParam(value="idx", defaultValue="1") int idx){
		System.out.println(idx);
		List<EmpDTO> list=empDao.empUpdate(idx);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("emp/empUpdate");
		return mav;
	}
	@RequestMapping("/empUpdate_ok.do")
	public ModelAndView empUpdate_ok(EmpDTO dto){
		int result=empDao.empUpdate_ok(dto);
		String msg=result>0?"사원 수정 성공":"사원 수정 실패";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("emp/empMsg");
		return mav;
	}
}
