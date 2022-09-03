package SportsMatching;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ChatDAO {
	//test code
	public int INSERT(int chatID, String fromID, String toID, String chatContent, int chatTime) {
		String SQL = "insert into chat values(?,?,?,?,?)";
		try (
		    //DB 연결 
			Connection conn = DBConnection.GetDB();
			PreparedStatement ptstm = conn.prepareStatement(SQL);
			){
			ptstm.setInt(1, chatID);
			ptstm.setString(2, fromID);
			ptstm.setString(3, toID);
			ptstm.setString(4, chatContent);
			ptstm.setInt(5, chatTime);
			
			int result = ptstm.executeUpdate();
			return result;	
		} catch(Exception e) {
			return -1;
		}
	}
}
