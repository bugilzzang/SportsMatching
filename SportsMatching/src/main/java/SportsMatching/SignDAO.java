package SportsMatching;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class SignDAO {
	//test code
	public String SignUP(String name, String id, String pw, String address, String mmr) {
		String SQL = "insert into user values(?,?,?,?,?)";
		try (
		    //DB 연결 
			Connection conn = DBConnection.GetDB();
			PreparedStatement ptstm = conn.prepareStatement(SQL);
			){
			ptstm.setString(1, name);
			ptstm.setString(2, id);
			ptstm.setString(3, pw);
			ptstm.setString(4, address);
			ptstm.setInt(5, Integer.parseInt(mmr));
			
		    ptstm.executeUpdate();
						
		    ptstm.close();
		    conn.close();
		    
			return "성공";
		}catch (Exception e){
			return "실패";
		 }
	 }
}
