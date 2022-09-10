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

//mmr 4별로 정렬
//html에서 정렬을 하면 java가 좀더 간단해진다 


public class RankingDAO {
	
	public String Gets_mmrList(String ID) {
		try {
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "select USER_NAME , s_mmr from user as u , Mmr as m where u.USER_ID = m.ID order by s_mmr desc limit 5"; //조인했
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json = new JSONObject();
			ArrayList USER_NAMEs = new ArrayList();
			ArrayList s_Mmrs = new ArrayList();
			
			while (result.next())
			{
				USER_NAMEs.add(result.getString(1));
				s_Mmrs.add(result.getInt(2));
			}
			json.put("USER_NAME", USER_NAMEs);
			json.put("s_Mmr", s_Mmrs);
			
			state.close();
			result.close();
			return json.toJSONString();
			
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return "실패";
			}
	}
	
	public String Getb_mmrList(String ID) {
		try {
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "select USER_NAME , b_mmr from user as u , Mmr as m where u.USER_ID = m.ID order by b_mmr desc limit 5"; //조인했
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json2 = new JSONObject();
			ArrayList USER_NAMEs = new ArrayList();
			ArrayList b_Mmrs = new ArrayList();
			
			while (result.next())
			{
				USER_NAMEs.add(result.getString(1));
				b_Mmrs.add(result.getInt(2));
			}
			json2.put("USER_NAME", USER_NAMEs);
			json2.put("b_Mmr", b_Mmrs);
			
			state.close();
			result.close();
			return json2.toJSONString();
			
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return "실패";
			}
	}
	
	public String Gett_mmrList(String ID) {
		try {
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "select USER_NAME , t_mmr from user as u , Mmr as m where u.USER_ID = m.ID order by t_mmr desc limit 5"; //조인했
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json3 = new JSONObject();
			ArrayList USER_NAMEs = new ArrayList();
			ArrayList t_Mmrs = new ArrayList();
			
			while (result.next())
			{
				USER_NAMEs.add(result.getString(1));
				t_Mmrs.add(result.getInt(2));
			}
			json3.put("USER_NAME", USER_NAMEs);
			json3.put("t_Mmr", t_Mmrs);
			
			state.close();
			result.close();
			return json3.toJSONString();
			
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return "실패";
			}
	}
	
	public String Geth_mmrList(String ID) {
		try {
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "select USER_NAME , h_mmr from user as u , Mmr as m where u.USER_ID = m.ID order by h_mmr desc limit 5"; //조인했
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json4 = new JSONObject();
			ArrayList USER_NAMEs = new ArrayList();
			ArrayList h_Mmrs = new ArrayList();
			
			while (result.next())
			{
				USER_NAMEs.add(result.getString(1));
				h_Mmrs.add(result.getInt(2));
			}
			json4.put("USER_NAME", USER_NAMEs);
			json4.put("h_Mmr", h_Mmrs);
			
			state.close();
			result.close();
			return json4.toJSONString();
			
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

