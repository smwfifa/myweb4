package yong.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import yong.file.model.FileDTO;

@Controller
public class FileController {
	
	//JSP 진입 메소드
	@RequestMapping("/fileUploadForm.do")
	public String fileUploadForm(){
		return "file/fileUploadForm";
	}
	
	//@RequestParam 방식
	@RequestMapping("/fileupload1.do")
	public String fileUpload1(@RequestParam("writer")String writer, @RequestParam("upload")MultipartFile upload ){	//Spring에서만 지원해주는 클래스
		System.out.println(writer);
		copyInto(writer, upload);
		return "file/fileOk";
	}
	
	//MultipartHttpServletRequest 방식
	@RequestMapping("/fileupload2.do")
	public String fileUpload2(MultipartHttpServletRequest req){
		String writer=req.getParameter("writer");
		MultipartFile upload=req.getFile("upload");
		copyInto(writer, upload);
		return "file/fileOk";
	}
	
	//DTO를 이용한 업로드 방식
	@RequestMapping("/fileupload3.do")
	public String fileUpload3(FileDTO dto){
		copyInto(dto.getWriter(), dto.getUpload());
		return "file/fileOk";
	}
	
	/**다운로드 기능 여러개 구현하기*/
	//강사님이 만든거
	@RequestMapping("/fileupload4.do")
	public String fileUpload5(
			@RequestParam("writer") String writer,
			@RequestParam("upload") java.util.List<MultipartFile> uploads ){
		for(int i=0;i<uploads.size();i++){
			copyInto(writer, uploads.get(i));
		}
		
		return "file/fileOk";
	}
	
	//개인적으로 만든거	
	@RequestMapping("fileupload5.do")
	public String fileUpload4(FileDTO dto){
		for(int i=0;i<dto.getUploads().length;i++){
		copyInto(dto.getWriter(), dto.getUploads()[i]);
		}
		return "file/fileOk";
	}
	
	/**파일 목록 관련 메소드*/
	@RequestMapping("/fileDownList.do")
	public ModelAndView fileList(){
		
		File f=new File("C:/Programing/jsp_mysql/upload/");
		File files[]=f.listFiles();
		ModelAndView mav=new ModelAndView();
		mav.addObject("files", files);
		mav.setViewName("file/fileList");
		return mav;
	}
	
	@RequestMapping("/down.do")
	public ModelAndView download(
			@RequestParam("filename")String filename){
		File f=new File("C:/Programing/jsp_mysql/upload/"+filename);
		ModelAndView mav=new ModelAndView("download", "downloadFile", f);	//download는 Bean에서 등록한 id값
		return mav;
	}
	
	/**파일 복사 기능*/
	/*
	 *	File 다운로드는 명령어체계로 다운을 받아야 하기 때문에 경로로 다운로드를 받을 수가 없기 때문에.
	 *	Download View를 이용해서 다운로드를 받게 되는데
	 *	직접 만들어도 상관없지만 같은 코드이기때문에 받아서 사용해도된다.
	 *	http://cafe.naver.com/seokstudy/1363
	 */
	//다른 클래스에서 file기능을 사용하기 힘들기 때문에 private를 사용한다.
	private void copyInto(String writer, MultipartFile upload){			
		System.out.println("작성자: "+writer);
		System.out.println("올릴파일명: "+upload.getOriginalFilename());	//getName()을 사용하면 난수값이 포함되어있는 임시폴더의 파일명이 불러와진다. 
		
		try {
			//Java에서 파일 복사하기 기능을 지원해주는 방법 (알고리즘이라 다른방법으로도 가능하다.) 
			byte bytes[]=upload.getBytes();			//예외상황 발생
			File newFile = new File("C:/Programing/jsp_mysql/upload/"+upload.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(newFile);
			fos.write(bytes);						//copy 행위
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
	
	http://cafe.naver.com/seokstudy/1362
	
	MultipartFile 인터페이스
	
	org.springframework.web.multipart.MultipartFile 인터페이스는
	업로드한 파일정보 및 파일 데이터를 표현하기 위한 용도로 사용된다.
	
	MultipartFile인터페이스의 주요 메소드 
	
	-String getName()
	 파라미터 이름을 구한다.
	
	-String getOriginalFilename()
	 업로드한 파일의 이름을 구한다.
	
	-boolean isEmpty()
	 업로드 한 파일이 존재하지 않는 경우 true를 리턴한다.
	
	-long getSize()
	 업로드한 파일의 크기를 구한다.
	
	-byte[] getBytes() throws IOException
	 업로드한 파일의 데이터를 구한다.
	
	-InputStream getInputStream() throws IOException 
	 업로드 한 파일 데이터를 읽어오는 InputStream을 구한다.
	 InputStream의 사용이 끝나면 알맞게 종료해 주어야한다.
	
	-void transferTo(File dest) throws IOException
	 업로드 한 파일 데이터를 지정한 파일에 저장한다.
	
	
	[참고]
	업로드한 파일 데이터를 구하는 가장 단순한 방법
	MultipartFile.getBytes()메서드를 이용하는 것이다.


*/