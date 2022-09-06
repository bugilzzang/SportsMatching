package SportsMatching;

import java.sql.*;

public class LoginDAO {
	
	public String enter_Member(String userID, String userPW)
	{
		
		String SQL1 = "SELECT USER_ID, USER_PASSWORD FROM USER WHERE USER_ID = ? AND USER_PASSWORD = ?";
		
		try {
			Connection conn = DBConnection.GetDB();
			
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ptstn.setString(1, userID);
			ptstn.setString(2, userPW);
			
			ResultSet rs = ptstn.executeQuery();
			
			if(rs.next()) {
				ptstn.close();
				return "로그인성공";
			}else {
				ptstn.close();
				return "로그인실패";
			}
			
			
					
		}catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());
			return "실패";
		}
		
		
	}
}