package yong.db;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class YongDB {
	static DataSource ds;
	static{
		//?λ‘κ·Έ?¨?΄ ???λ©΄μ λΆ??° λ°λ‘ λ§λ ?€.	static? λ²μλ‘? μ§?? ?΄ κ°??₯??€.
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
