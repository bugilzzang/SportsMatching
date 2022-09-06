package SportsMatching;

import java.sql.*;

import SportsMatching.*;
import java.util.*;
import org.json.simple.JSONObject;



/**
하나씩 데이터를 출력 받는 방

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
*/

public class RankingDAO {
	
	public String GetRankingList(String UserID) {
		try {
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "select * from Ranking order by UserID desc limit 5";
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json = new JSONObject();
			ArrayList UserNames = new ArrayList();
			ArrayList Adresss = new ArrayList();
			ArrayList UserMmrs = new ArrayList();
			ArrayList Introductions = new ArrayList();
			
			
			while (result.next())
			{
				UserNames.add(result.getString(2));
				Adresss.add(result.getString(3));
				UserMmrs.add(result.getInt(4));
				Introductions.add(result.getString(5));
			}
			json.put("UserName", UserNames);
			json.put("Adress", Adresss);
			json.put("UserMmr", UserMmrs);
			json.put("Introduction", Introductions);
			
			state.close();
			result.close();
			return json.toJSONString();
			
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return "실패";
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

