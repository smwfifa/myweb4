package yong.db;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class YongDB {
	static DataSource ds;
	static{
		//?”„ë¡œê·¸?¨?´ ?‹œ?‘?•˜ë©´ì„œ ë¶??„° ë°”ë¡œ ë§Œë“ ?‹¤.	static?„ ë²”ìœ„ë¡? ì§?? •?´ ê°??Š¥?•˜?‹¤.
		try{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static Connection getConn()
	throws Exception{
		return ds.getConnection();
		
		
	}
	
	
	
}
