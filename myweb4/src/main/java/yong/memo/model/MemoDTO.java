package yong.memo.model;

public class MemoDTO {

	private int idx;
	private String title;
	private String content;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public MemoDTO() {
		super();
	}
	
	public MemoDTO(int idx, String title, String content) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
	}
	
	@Override
	public String toString() {
		String msg="[idx:"+idx+"\ntitle:"+title+"\ncontent:"+content+"]";
		return msg;
	}
	
	
}
