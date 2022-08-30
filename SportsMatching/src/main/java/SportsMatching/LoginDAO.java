package SportsMatching;

import java.sql.*;

public class LoginDAO {

	public String Matchinng(String id, String name, String password, String address, int mmr)
	{
		try {
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query ="insert into member values(";
			query += id + ",";
			query += name + ",";
			query += password + ",";
			query += address + ",";
			query += 0;
			
			state.executeUpdate(query);
			
			state.close();
					
			return "성공";
		}catch (Exception e) {
			return "실패";
		}
		
		
	}
}