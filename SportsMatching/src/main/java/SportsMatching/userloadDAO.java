package SportsMatching;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;




public class userloadDAO {
	public Map<String, String> userloadingDAO(String id) throws Exception {
		String SQL = "select * from user where USER_ID = ?";
		
		try {
			Connection conn = DBConnection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL);
			ptstn.setString(1, id);

			ResultSet result = ptstn.executeQuery();
			
			result.next();
			
			String UserId = result.getString(1);
			String UserName = result.getString(2);
			String UserAddress = result.getString(4);
			
			Map<String, String> userinformation = new HashMap<>();
			userinformation.put("UserId", UserId);
			userinformation.put("UserName", UserName);
			userinformation.put("UserAddress", UserAddress);
			
			return userinformation;
			
				
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
