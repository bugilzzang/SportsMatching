package SportsMatching;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RatingDAO {
	
	public String search_Member(String userID)
	{
		
		String SQL = "SELECT USER_ID FROM USER WHERE USER_ID = ?";
		
		try {
			Connection conn = DBConnection.GetDB();
			
			PreparedStatement ptstn = conn.prepareStatement(SQL);
			ptstn.setString(1, userID);
			
			ResultSet rs = ptstn.executeQuery();
			
			if(rs.next()) {
				ptstn.close();
				return "서칭성공";
			}else {
				ptstn.close();
				return "서칭실패";
			}
			
			
					
		}catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());
			return "실패";
		}
		
		
	}
	
	public String MVP_MMR(String userID)
	{
		
		String SQL = "UPDATE Mmr SET S_MMR = S_MMR + 5 WHERE ID = ?";
		
		try {
			Connection conn = DBConnection.GetDB();
			
			PreparedStatement ptstn = conn.prepareStatement(SQL);
			ptstn.setString(1, userID);
			
			ptstn.executeUpdate();
			
			return "성공";
			
			
					
		}catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());
			return "실패";
		}
		
		
	}
	
	public String WINNER_MMR(String userID)
	{
		
		String SQL = "UPDATE Mmr SET S_MMR = S_MMR + 10 WHERE ID = ?";
		
		try {
			Connection conn = DBConnection.GetDB();
			
			PreparedStatement ptstn = conn.prepareStatement(SQL);
			ptstn.setString(1, userID);
			
			ptstn.executeUpdate();
			
			return "성공";
			
			
					
		}catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());
			return "실패";
		}
		
		
	}
	
	public String doubleCheck_MMR(String userID)
	{
		
		String SQL = "UPDATE Mmr SET S_MMR = S_MMR + 15 WHERE ID = ?";
		
		try {
			Connection conn = DBConnection.GetDB();
			
			PreparedStatement ptstn = conn.prepareStatement(SQL);
			ptstn.setString(1, userID);
			
			ptstn.executeUpdate();
			
			return "성공";
			
			
					
		}catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());
			return "실패";
		}
		
		
	}
}