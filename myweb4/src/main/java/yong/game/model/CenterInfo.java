package yong.game.model;

public class CenterInfo {
	private String centername;
	private String address;
	
	public CenterInfo() {
		super();
	}
	
	public CenterInfo(String centername, String address) {
		super();
		this.centername = centername;
		this.address = address;
	}
	
	public String getCentername() {
		return centername;
	}
	public void setCentername(String centername) {
		this.centername = centername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
