package yong.file.model;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {

	private String writer;
	private MultipartFile upload;
	private MultipartFile uploads[];
	
	public FileDTO() {
		super();
	}

	public FileDTO(String writer, MultipartFile upload, MultipartFile[] uploads) {
		super();
		this.writer = writer;
		this.upload = upload;
		this.uploads = uploads;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	public MultipartFile[] getUploads() {
		return uploads;
	}

	public void setUploads(MultipartFile[] uploads) {
		this.uploads = uploads;
	}
	
	
}
