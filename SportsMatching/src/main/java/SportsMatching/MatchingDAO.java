package SportsMatching;

import java.sql.*;

public class MatchingDAO {

	public void Matchinng()
	{
		Connection conn = DBConnection.GetDB();
		System.out.println(conn == null ? "실패" : "성공");
	}
}