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
	
	//JSP ���� �޼ҵ�
	@RequestMapping("/fileUploadForm.do")
	public String fileUploadForm(){
		return "file/fileUploadForm";
	}
	
	//@RequestParam ���
	@RequestMapping("/fileupload1.do")
	public String fileUpload1(@RequestParam("writer")String writer, @RequestParam("upload")MultipartFile upload ){	//Spring������ �������ִ� Ŭ����
		System.out.println(writer);
		copyInto(writer, upload);
		return "file/fileOk";
	}
	
	//MultipartHttpServletRequest ���
	@RequestMapping("/fileupload2.do")
	public String fileUpload2(MultipartHttpServletRequest req){
		String writer=req.getParameter("writer");
		MultipartFile upload=req.getFile("upload");
		copyInto(writer, upload);
		return "file/fileOk";
	}
	
	//DTO�� �̿��� ���ε� ���
	@RequestMapping("/fileupload3.do")
	public String fileUpload3(FileDTO dto){
		copyInto(dto.getWriter(), dto.getUpload());
		return "file/fileOk";
	}
	
	/**�ٿ�ε� ��� ������ �����ϱ�*/
	//������� �����
	@RequestMapping("/fileupload4.do")
	public String fileUpload5(
			@RequestParam("writer") String writer,
			@RequestParam("upload") java.util.List<MultipartFile> uploads ){
		for(int i=0;i<uploads.size();i++){
			copyInto(writer, uploads.get(i));
		}
		
		return "file/fileOk";
	}
	
	//���������� �����	
	@RequestMapping("fileupload5.do")
	public String fileUpload4(FileDTO dto){
		for(int i=0;i<dto.getUploads().length;i++){
		copyInto(dto.getWriter(), dto.getUploads()[i]);
		}
		return "file/fileOk";
	}
	
	/**���� ��� ���� �޼ҵ�*/
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
		ModelAndView mav=new ModelAndView("download", "downloadFile", f);	//download�� Bean���� ����� id��
		return mav;
	}
	
	/**���� ���� ���*/
	/*
	 *	File �ٿ�ε�� ��ɾ�ü��� �ٿ��� �޾ƾ� �ϱ� ������ ��η� �ٿ�ε带 ���� ���� ���� ������.
	 *	Download View�� �̿��ؼ� �ٿ�ε带 �ް� �Ǵµ�
	 *	���� ���� ��������� ���� �ڵ��̱⶧���� �޾Ƽ� ����ص��ȴ�.
	 *	http://cafe.naver.com/seokstudy/1363
	 */
	//�ٸ� Ŭ�������� file����� ����ϱ� ����� ������ private�� ����Ѵ�.
	private void copyInto(String writer, MultipartFile upload){			
		System.out.println("�ۼ���: "+writer);
		System.out.println("�ø����ϸ�: "+upload.getOriginalFilename());	//getName()�� ����ϸ� �������� ���ԵǾ��ִ� �ӽ������� ���ϸ��� �ҷ�������. 
		
		try {
			//Java���� ���� �����ϱ� ����� �������ִ� ��� (�˰����̶� �ٸ�������ε� �����ϴ�.) 
			byte bytes[]=upload.getBytes();			//���ܻ�Ȳ �߻�
			File newFile = new File("C:/Programing/jsp_mysql/upload/"+upload.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(newFile);
			fos.write(bytes);						//copy ����
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
	
	http://cafe.naver.com/seokstudy/1362
	
	MultipartFile �������̽�
	
	org.springframework.web.multipart.MultipartFile �������̽���
	���ε��� �������� �� ���� �����͸� ǥ���ϱ� ���� �뵵�� ���ȴ�.
	
	MultipartFile�������̽��� �ֿ� �޼ҵ� 
	
	-String getName()
	 �Ķ���� �̸��� ���Ѵ�.
	
	-String getOriginalFilename()
	 ���ε��� ������ �̸��� ���Ѵ�.
	
	-boolean isEmpty()
	 ���ε� �� ������ �������� �ʴ� ��� true�� �����Ѵ�.
	
	-long getSize()
	 ���ε��� ������ ũ�⸦ ���Ѵ�.
	
	-byte[] getBytes() throws IOException
	 ���ε��� ������ �����͸� ���Ѵ�.
	
	-InputStream getInputStream() throws IOException 
	 ���ε� �� ���� �����͸� �о���� InputStream�� ���Ѵ�.
	 InputStream�� ����� ������ �˸°� ������ �־���Ѵ�.
	
	-void transferTo(File dest) throws IOException
	 ���ε� �� ���� �����͸� ������ ���Ͽ� �����Ѵ�.
	
	
	[����]
	���ε��� ���� �����͸� ���ϴ� ���� �ܼ��� ���
	MultipartFile.getBytes()�޼��带 �̿��ϴ� ���̴�.


*/