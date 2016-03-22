package yong.db;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class YongDB {
	static DataSource ds;
	static{
		//?��로그?��?�� ?��?��?��면서 �??�� 바로 만든?��.	static?�� 범위�? �??��?�� �??��?��?��.
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
