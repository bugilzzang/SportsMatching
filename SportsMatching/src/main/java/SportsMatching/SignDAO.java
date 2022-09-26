package SportsMatching;

import java.sql.*;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class SignDAO {
	//test code
	public String SignUP(String name, String id, String pw, String address, String mmr) {
		String SQL1 = "select * from user where USER_ID = ?";
		String SQL2 = "insert into user values(?,?,?,?,?)";
		
		try {
		    //DB 연결 
			Connection conn = DBConnection.GetDB();
			PreparedStatement ptstn = conn.prepareStatement(SQL1);
			ptstn.setString(1, name);
			ResultSet rs = ptstn.executeQuery();
			
			if(rs.next()) {
				ptstn.close();
				return "중복";
			}
			else {
			    try {
			    	ptstn.close();
			    	PreparedStatement ptstm = conn.prepareStatement(SQL2);
					
					ptstm.setString(1, name);
					ptstm.setString(2, id);
					ptstm.setString(3, pw);
					ptstm.setString(4, address);
					ptstm.setInt(5, Integer.parseInt(mmr));
				    ptstm.executeUpdate();
				    
				    Statement state = conn.createStatement();
					
					String query = "insert into Mmr values('";
					query += name + "', 500, 500, 500, 500);";
					
					state.executeUpdate(query);
					state.close();
				    
				    ptstm.close();
					return "성공";
			    }catch (Exception e){
					System.out.println(e.getMessage());
					return "실패";
			     }		    
	         }
		 }catch(Exception e) {
			System.out.println(e.getMessage());
			return "실패";
		  }
	 }
 }
