package SportsMatching;

import java.sql.*;
import java.util.ArrayList;

import org.json.simple.*;

public class MatchingDAO {

	public String Matching(String owner, String kind, String date, String time1, String time2, String mmr1, String mmr2, String many1, String many2, String our, String location)
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
			query += our + ",'";
			query += location + "');";
			
			state.executeUpdate(query);
			
			state.close();
			
			/*
			PreparedStatement state = conn.prepareStatement("insert into matching values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			state.setString(1, owner);
			state.setString(2, kind);
			state.setString(3, date);
			state.setString(4, time1);
			state.setString(5, time2);
			
			state.setInt(6, Integer.parseInt(mmr1));
			state.setInt(7, Integer.parseInt(mmr2));
			state.setInt(8, Integer.parseInt(many1));
			state.setInt(9, Integer.parseInt(many2));
			state.setInt(10, Integer.parseInt(our));
			
			state.close();
			*/
			
			return "성공";
		}
		catch (Exception e)
		{
			return "실패";
		}
	}
	
	public String GetMatchingList(String owner)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "select * from matching where _owner!='" + owner + "';";
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json = new JSONObject();
			ArrayList nos = new ArrayList();
			ArrayList kinds = new ArrayList();
			ArrayList dates = new ArrayList();
			ArrayList times1 = new ArrayList();
			ArrayList times2 = new ArrayList();
			ArrayList mmrs1 = new ArrayList();
			ArrayList mmrs2 = new ArrayList();
			ArrayList manys1 = new ArrayList();
			ArrayList manys2 = new ArrayList();
			ArrayList ours = new ArrayList();
			ArrayList locations = new ArrayList();
			
			while (result.next())
			{
				nos.add(result.getInt(1));
				kinds.add(result.getString(3));
				dates.add(result.getString(4));
				times1.add(result.getString(5));
				times2.add(result.getString(6));
				
				mmrs1.add(result.getInt(7));
				mmrs2.add(result.getInt(8));
				manys1.add(result.getInt(9));
				manys2.add(result.getInt(10));
				ours.add(result.getInt(11));
				locations.add(result.getString(12));
			}
			
			json.put("no", nos);
			json.put("kind", kinds);
			json.put("date", dates);
			json.put("time1", times1);
			json.put("time2", times2);
			json.put("mmr1", mmrs1);
			json.put("mmr2", mmrs2);
			json.put("many1", manys1);
			json.put("many2", manys2);
			json.put("our", ours);
			json.put("location", locations);
			
			state.close();
			result.close();
			return json.toJSONString();
		}
		catch (Exception e)
		{
			return "실패";
		}
	}
	
	public String Join(String no, String owner)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			if (state.executeQuery("select _owner from matching_my where _origin=" + no + " and _owner='" + owner + "'").next())
			{
				state.close();
				
				return "이미";
			}
			if (state.executeQuery("select _owner from matching where _no=" + no + " and _owner='" + owner + "'").next())
			{
				state.close();
				
				return "이미";
			}
			
			state.close();
			
			state = conn.createStatement();
			
			String query = "insert into matching_my values(0,'";
			query += owner + "',";
			query += no + ");";
			
			state.executeUpdate(query);
			
			state.close();
			
			state = conn.createStatement();
			
			query = "update matching set _our=_our+1 where _no=" + no;
			
			state.executeUpdate(query);
			
			state.close();
			
			return "성공";
		}
		catch (Exception e)
		{
			return "실패";
		}
	}
	
	public String GetMatchingMy(String owner)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();			
			Statement state = conn.createStatement();
			
			String query = "select * from matching where _owner='" + owner + "';";
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json = new JSONObject();
			ArrayList nos = new ArrayList();
			ArrayList kinds = new ArrayList();
			ArrayList dates = new ArrayList();
			ArrayList times1 = new ArrayList();
			ArrayList times2 = new ArrayList();
			ArrayList mmrs1 = new ArrayList();
			ArrayList mmrs2 = new ArrayList();
			ArrayList manys1 = new ArrayList();
			ArrayList manys2 = new ArrayList();
			ArrayList ours = new ArrayList();
			ArrayList locations = new ArrayList();
			
			while (result.next())
			{
				nos.add(result.getInt(1));
				kinds.add(result.getString(3));
				dates.add(result.getString(4));
				times1.add(result.getString(5));
				times2.add(result.getString(6));
				
				mmrs1.add(result.getInt(7));
				mmrs2.add(result.getInt(8));
				manys1.add(result.getInt(9));
				manys2.add(result.getInt(10));
				ours.add(result.getInt(11));
				locations.add(result.getString(12));
			}
			
			json.put("no", nos);
			json.put("kind", kinds);
			json.put("date", dates);
			json.put("time1", times1);
			json.put("time2", times2);
			json.put("mmr1", mmrs1);
			json.put("mmr2", mmrs2);
			json.put("many1", manys1);
			json.put("many2", manys2);
			json.put("our", ours);
			json.put("location", locations);
			
			state.close();
			result.close();
			return json.toJSONString();
		}
		catch (Exception e)
		{
			return "실패";
		}
	}
	
	public String Cancel(String no, String owner)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			if (!state.executeQuery("select _owner from matching where _no=" + no + " and _owner='" + owner + "'").next())
			{
				state.close();
				
				return "실패";
			}
			
			state.close();
			
			state = conn.createStatement();
			
			String query = "delete from matching where _no=" + no + " and _owner='" + owner + "'";
			
			state.executeUpdate(query);
			
			state.close();
			
			return "성공";
		}
		catch (Exception e)
		{
			return "실패";
		}
	}
	
	public String Complete(String no, String owner)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			if (!state.executeQuery("select _owner from matching where _no=" + no + " and _owner='" + owner + "'").next())
			{
				state.close();
				
				return "실패";
			}
			
			String query = "select * from matching_my where _origin=" + no + ";";
			
			ResultSet result = state.executeQuery(query);
			
			while (result.next())
			{
				Statement state2 = conn.createStatement();
				query = "select * from matching_my where _origin=" + no + " and _owner!='" + result.getString(2) + "';";
				ResultSet result2 = state2.executeQuery(query);
				
				Statement state3 = conn.createStatement();
				
				while (result2.next())
				{
					query = "insert into matching_rating values(0, '" + result.getString(2) + "', '" + result2.getString(2) + "');";
					state3.executeUpdate(query);
				}
				
				query = "insert into matching_rating values(0, '" + result.getString(2) + "', '" + owner + "');";
				state3.executeUpdate(query);
				
				query = "insert into matching_rating values(0, '" + owner + "', '" + result.getString(2) + "');";
				state3.executeUpdate(query);
				
				result2.close();
				state2.close();
				state3.close();
			}
			
			result.close();
			
			query = "delete from matching where _no=" + no + " and _owner='" + owner + "'";
			state.executeUpdate(query);
			
			state.close();
			
			return "성공";
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return "실패";
		}
	}
	
	public String GetMatchingMyJoin(String owner)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			String query = "select * from matching_my where _owner='" + owner + "';";
			
			ResultSet result = state.executeQuery(query);
			
			JSONObject json = new JSONObject();
			ArrayList nos = new ArrayList();
			ArrayList kinds = new ArrayList();
			ArrayList dates = new ArrayList();
			ArrayList times1 = new ArrayList();
			ArrayList times2 = new ArrayList();
			ArrayList mmrs1 = new ArrayList();
			ArrayList mmrs2 = new ArrayList();
			ArrayList manys1 = new ArrayList();
			ArrayList manys2 = new ArrayList();
			ArrayList ours = new ArrayList();
			ArrayList locations = new ArrayList();
			
			while (result.next())
			{
				Statement state2 = conn.createStatement();
				ResultSet result2 = state2.executeQuery("select * from matching where _no=" + result.getInt(3));
				
				if (result2.next())
				{
					nos.add(result2.getInt(1));
					kinds.add(result2.getString(3));
					dates.add(result2.getString(4));
					times1.add(result2.getString(5));
					times2.add(result2.getString(6));
					
					mmrs1.add(result2.getInt(7));
					mmrs2.add(result2.getInt(8));
					manys1.add(result2.getInt(9));
					manys2.add(result2.getInt(10));
					ours.add(result2.getInt(11));
					locations.add(result2.getString(12));
				}
				
				state2.close();
				result2.close();
			}
			
			json.put("no", nos);
			json.put("kind", kinds);
			json.put("date", dates);
			json.put("time1", times1);
			json.put("time2", times2);
			json.put("mmr1", mmrs1);
			json.put("mmr2", mmrs2);
			json.put("many1", manys1);
			json.put("many2", manys2);
			json.put("our", ours);
			json.put("location", locations);
			
			state.close();
			result.close();
			return json.toJSONString();
		}
		catch (Exception e)
		{
			return "실패";
		}
	}
	
	public String Leave(String no, String owner)
	{
		try 
		{
			Connection conn = DBConnection.GetDB();
			
			Statement state = conn.createStatement();
			
			if (!state.executeQuery("select _owner from matching_my where _origin=" + no + " and _owner='" + owner + "'").next())
			{
				state.close();
				
				return "실패";
			}
			
			state.close();
			
			state = conn.createStatement();
			
			String query = "delete from matching_my where _origin=" + no + " and _owner='" + owner + "'";
			
			state.executeUpdate(query);
			
			state.close();
			
			state = conn.createStatement();
			
			query = "update matching set _our=_our-1 where _no=" + no;
			
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