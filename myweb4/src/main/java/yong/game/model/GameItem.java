package yong.game.model;

public class GameItem {
	private String title;
	private int number;
	private String bigo;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBigo() {
		return bigo;
	}

	public void setBigo(String bigo) {
		this.bigo = bigo;
	}

	public GameItem() {
		super();
	}

	public GameItem(String title, int number, String bigo) {
		super();
		this.title = title;
		this.number = number;
		this.bigo = bigo;
	}
	
	
}
