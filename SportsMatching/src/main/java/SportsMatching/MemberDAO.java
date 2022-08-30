package SportsMatching;

import java.sql.*;

public class MemberDAO {

	public void Matchinng(String id, String name, String password, String address, int mmr)
	{
		try {
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			
			System.out.println(conn == null ? "실패" : "성공");
		}catch (Exception e) {
		}
		
		
	}
}