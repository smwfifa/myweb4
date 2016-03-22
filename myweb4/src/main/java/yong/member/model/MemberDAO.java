package yong.member.model;

public interface MemberDAO {
	public static final int NOT_ID=1;
	public static final int NOT_PWD=2;
	public static final int LOGIN_OK=3;
	public static final int ERROR=-1;
	
	public int memberJoin(MemberDTO dto);
	public boolean idCheck(String userid);
	public int loginCheck(String id, String pwd);
	public String getUserInfo(String id);
}
