package SportsMatching;

import java.sql.*;

public class MatchingDAO {

	public String Matchinng(String owner, String kind, String date, String time1, String time2, String mmr1, String mmr2, String many1, String many2, String our)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "insert into matching values(0,'";
			query += owner + "','";
			query += kind + "','";
			query += date + "','";
			query += time1 + "','";
			query += time2 + "',";
			query += mmr1 + ",";
			query += mmr2 + ",";
			query += many1 + ",";
			query += many2 + ",";
			query += our + ");";
			
			state.executeUpdate(query);
			
			state.close();
			return "성공";
		}
		catch (Exception e)
		{
			return "실패";
		}
	}
}