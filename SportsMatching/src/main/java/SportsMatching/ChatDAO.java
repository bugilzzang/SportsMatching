package SportsMatching;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ChatDAO {
	DataSource dataSource;
	
	public ChatDAO() {
		try {
			//웹 어플리케이션이 처음으로 배치될때 생성 
			InitialContext initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/UserChat");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// test code
	public int dbtest(int a, String b, String c, String d, int date) {
		String SQL = "insert into chat values(?,?,?,?,?)";
		try (
		    //DB 연
			Connection conn = dataSource.getConnection();
			PreparedStatement ptstm = conn.prepareStatement(SQL);
			){
			ptstm.setInt(1, a);
			ptstm.setString(2, b);
			ptstm.setString(1, c);
			ptstm.setString(1, d);
			ptstm.setInt(1, date);
			
			int result = ptstm.executeUpdate();
			return result;	
		}catch(Exception e) {
			return -1;
		}
	}

	int result1 = dbtest(2, "부", "연", "장추", 12);
	
}
