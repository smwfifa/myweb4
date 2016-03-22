package yong.game.model;

import java.util.List;

public class GameAddDTO {				//DTO�� �����ϴ� DTO�ε� 
	private List<GameItem> gameitem;			//GameItem������� �������� ����ؾ� �ǹǷ� List(vector, Arraylist, list)�� ������ �Ѵ�.
	private CenterInfo centerinfo;
	
	public GameAddDTO(List<GameItem> gameitem, CenterInfo centerinfo) {
		super();
		this.gameitem = gameitem;
		this.centerinfo = centerinfo;
	}
	
	public GameAddDTO() {
		super();
	}
	
	public List<GameItem> getGameitem() {
		return gameitem;
	}
	public void setGameitem(List<GameItem> gameitem) {
		this.gameitem = gameitem;
	}
	public CenterInfo getCenterinfo() {
		return centerinfo;
	}
	public void setCenterinfo(CenterInfo centerinfo) {
		this.centerinfo = centerinfo;
	}
	
	
	
	
}
