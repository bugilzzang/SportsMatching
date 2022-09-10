package SportsMatching;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class userloadDAO {
	public String userloadDAO(String id){
		String SQL = "select * from user where USER_ID = ?";
		
		try {
			Connection conn = DBConnection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL);
			ptstn.setString(1, id);

			ResultSet result = ptstn.executeQuery();
			
			JSONObject json = new JSONObject();
			
			Map<String, String> userload = new HashMap<>();
			
		    userload.put("userName",result.getString(1));
			userload.put("userId",result.getString(2));
			userload.put("userAddress",result.getString(3));
			
			System.out.println(userload.get("userName"));
			System.out.println(userload.get("userId"));
			System.out.println(userload.get("userAddress"));
			
			
			return json.toJSONString();
						
				
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "실패";
		}
		
	}

}
