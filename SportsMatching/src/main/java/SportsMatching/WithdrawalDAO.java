package SportsMatching;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WithdrawalDAO {
	public String Withdrawal(String id){
		String SQL = "delete from user where USER_ID = ?";
		
		try {
			Connection conn = DBConnection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL);
			
			ptstn.setString(1, id);
			ptstn.executeUpdate();
			
			ptstn.close();
			
			return "성공";
		}catch(Exception e) {
			e.getMessage();
			return "실패";
		}
		
	}
}
