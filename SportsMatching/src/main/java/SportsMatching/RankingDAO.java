package SportsMatching;

import java.sql.*;
import java.util.*;

public class RankingDAO {

	private Connection conn;
	
	public RankingDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int insertData(RankingDTO dto) {
		int result = 0;
	
	
		PreparedStatement pstmt = null;
		String query;
	
		query = "INSERT INTO Rank(UserID,UserName,Adress,UserMmr)";
		query += "VALUES (?,?,?,?)";
	
		try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1,dto.getUserID());
		pstmt.setString(2,dto.getUserName());
		pstmt.setString(3,dto.getAdress());
		pstmt.setInt(4,dto.getUserMmr());
		pstmt.setInt(5,dto.getRank());
		result = pstmt.executeUpdate();
		pstmt.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	public List<RankingDTO> getLists() {
		List<RankingDTO> lists = new ArrayList<RankingDTO>();
		Statement stmt = null;
		ResultSet rs = null;
		
		String qurey;
		
		qurey = "SELECT UserName, Adress, UserMmr";
		qurey += ",(UserName)";
		qurey += ",(Adress)";
		qurey += ",(UserMmr)";
		qurey += ",rank() over(order by (UserMmr) desc)rank";
		qurey += "FROM Ranking";
		qurey += "ORDER BY UserMmr";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qurey);
			
			while (rs.next()) {
				RankingDTO dto = new RankingDTO();
				dto.setUserID(rs.getString(1));
				dto.setUserName(rs.getString(2));
				dto.setAdress(rs.getString(3));
				dto.setUserMmr(rs.getInt(4));
				dto.setRank(rs.getInt(5));
				lists.add(dto);
				
			}
			stmt.close();
			rs.close();
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}
	
	public int deleteData(String UserId) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String qurey;
		
		try {
			qurey = "DELETE FORM Rank WHERE UserID=?";
			pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, UserId);
			result = pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return result;
		
	}
	
	public RankingDTO getReadData(String UserId) {
		
		RankingDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qurey;
	
		try {
			qurey = "SELECT UserId, UserName. UserName, Adress, UserMmr";
			qurey += "WHERE UserId=?";
			pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, UserId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new RankingDTO();
				dto.setUserID(rs.getString(1));
				dto.setUserName(rs.getString(2));
				dto.setAdress(rs.getString(3));
				dto.setUserMmr(rs.getInt(4));
			}
			rs.close();
			pstmt.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return dto;
		
	}
	
	public int uddataData(RankingDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt =null;
		String qurey;
		
		try {
			qurey = "UPDATA RankingDTO SET UserName=?, UserMmr=? WHERE UserId=?";
			pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1,dto.getUserName());
			pstmt.setInt(2,dto.getUserMmr());
			pstmt.setString(3,dto.getUserID());
			result = pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return result;
		
	}
	
}
	
	
