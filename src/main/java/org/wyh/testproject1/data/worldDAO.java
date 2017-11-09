package org.wyh.testproject1.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class worldDAO {
	
	public worldDAO(){
		
	}
	
	public ArrayList<String> getAllCities(){
		
		ArrayList<String> cities = new ArrayList<String>();
		String sql = "select Name from city";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = connectionFactory.getInstance().getConnection(); 
			stmt = conn.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next())
			{
				cities.add(rs.getString("Name"));
			}
			
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		finally {
			try { 
				if(rs!=null)
					rs.close();
				if (stmt != null) 
					stmt.close();
				if (conn != null)
					conn.close();
			} 
			catch (SQLException se) 
			{ 
				se.printStackTrace(); 
			}		
		}
		return cities;
		
	}

}
