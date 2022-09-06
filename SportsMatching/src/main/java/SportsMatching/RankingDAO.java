package SportsMatching;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.List;
import SportsMatching.*;
import java.util.*;

public class RankingDAO {
	public RankingDTO selectOne(String id){
		String sql = "select * from Ranking where UserID = ?";
		RankingDTO dto = new RankingDTO();
		try {
		        Connection conn = DBConnection.GetDB();
				PreparedStatement pstat = conn.prepareStatement(sql);
			    pstat.setString(1, id);
			
			    ResultSet rs = pstat.executeQuery();
				
				if(rs.next()) {
					dto.setUserID(rs.getString(1));
					dto.setUserName(rs.getString(2));
					dto.setAdress(rs.getString(3));
					dto.setUserMmr(rs.getInt(4));
					dto.setIntroduction(rs.getString(5));
				}
				return dto;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return dto;
	}
 }
}
	




/*	
	public List<RankingDAO> selectAll() throws Exception {
		String sql = "select * from Raning where UserID=?";
		try(
				Connection conn = DBConnection.GetDB();
				PreparedStatement pstat = conn.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				){
			List<RankingDAO> dao = new ArrayList<>();
			while(rs.next()) {
				
				String UserID = rs.getString(1);
				String UserName = rs.getString(2);
				String Adress = rs.getString(3);
				int UserMmr = rs.getInt(4);
				String Introduction = rs.getString(5);
				
				
				RankingDAO d = new RankingDAO(UserID,UserName,Adress,new RankingDTO(UserMmr),Introduction);
				dao.add(d);
			}
			return dao;
		}
	}
*/

