package com.sist.dao;
import java.util.*;
import java.sql.*;
public class HotelDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String url,username,password;
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
	public HotelDAO(String driverName)
	{
		try
		{
			Class.forName(driverName);
		}catch(Exception ex) {}
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	
	public List<HotelVO> hotelListData(String address)
	{
		List<HotelVO> list=new ArrayList<HotelVO>();
		try
		{
			getConnection();
			String sql="SELECT no,name,address,score "
					+ "FROM seoul_hotel "
					+ "WHERE address LIKE '%'||?||'%' "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ps.setString(1, address);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				HotelVO vo=new HotelVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setAddress(rs.getString(3));
				vo.setScore(rs.getDouble(4));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	
	
}
