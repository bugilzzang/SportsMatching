package SportsMatching;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ChatDAO {
	//test code
	public int dbtest(int a, String b, String c, String d, int date) {
		String SQL = "insert into chat values(?,?,?,?,?)";
		try (
		    //DB 연
			Connection conn = DBConnection.GetDB();
			PreparedStatement ptstm = conn.prepareStatement(SQL);
			){
			ptstm.setInt(1, a);
			ptstm.setString(2, b);
			ptstm.setString(1, c);
			ptstm.setString(1, d);
			ptstm.setInt(1, date);
			
			int result = ptstm.executeUpdate();
			return result;	
		} catch(Exception e) {
			return -1;
		}
	}
}
