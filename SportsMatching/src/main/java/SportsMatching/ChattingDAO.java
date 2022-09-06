package SportsMatching;

import java.sql.*;
import java.util.ArrayList;

import org.json.simple.JSONObject;

public class ChattingDAO {
	
	public String GetChatting(String no)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "select * from chat where _room=" + no + " order by _no;";
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json = new JSONObject();
			ArrayList owners = new ArrayList();
			ArrayList messages = new ArrayList();
			
			while (result.next())
			{
				owners.add(result.getString(2));
				messages.add(result.getString(4));
			}
			
			json.put("owner", owners);
			json.put("message", messages);
			
			state.close();
			result.close();
			return json.toJSONString();
		}
		catch (Exception e)
		{
			return "실패";
		}
	}
	
	public String SendMessage(String no, String owner, String message)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "insert into chat values(0,'";
			query += owner + "',";
			query += no + ",'";
			query += message + "');";
			
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