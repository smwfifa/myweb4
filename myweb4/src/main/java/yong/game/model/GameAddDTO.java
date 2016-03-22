package yong.game.model;

import java.util.List;

public class GameAddDTO {				//DTO를 관리하는 DTO인데 
	private List<GameItem> gameitem;			//GameItem같은경우 여러개를 사용해야 되므로 List(vector, Arraylist, list)로 관리를 한다.
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
