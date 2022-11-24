package com.mysite.domain;

import java.util.ArrayList;
import java.util.List;

import com.mysite.connector.ConnectH2;

public class LogDaoH2 extends ConnectH2 implements LogDAO {
	String drv = "org.h2.Driver";
	String url = "jdbc:h2:tcp://localhost/~/test";  
	String id = "sa";
	String pwd = "";
	
	public LogDaoH2(String drv, String url, String id, String pwd) {
		super(drv,url,id,pwd);
	}
	
	public List<LogVO> getLogVO() {
		List<LogVO> ls = new ArrayList<LogVO>();
		String query = "SELECT * FROM Log";
		
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				LogVO dto = new LogVO();
				dto.setidx(rs.getString("idx"));
				dto.setTime(rs.getString("Time"));
				dto.setContent(rs.getString("Content"));
				ls.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	public LogVO getLogVO(String idx) {
		LogVO dto = new LogVO();
        String query = "SELECT * FROM Log where idx=?";
        
        try {
        	psmt = con.prepareStatement(query);
        	psmt.setString(1, idx);
        	rs = psmt.executeQuery();
        	
        	if(rs.next()) {
        		dto.setidx(rs.getString("idx"));
        		dto.setContent(rs.getString("Content"));
        		dto.setTime(rs.getString("Time"));
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return dto;
	}


	public int InsertLog(LogVO vo) {
		int result = 0;
		try {
			String query = "INSERT INTO LOG("
					+ "Content) "
					+ "values( "
					+ "?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, vo.getContent());
			result = psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public int UpdateLog(LogVO vo) {
		int result = 0;
		try {
			String query = "UPDATE LOG SET "
					+ "Content = ? "
					+ "WHERE idx = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(2, String.valueOf(vo.getidx()));
			psmt.setString(1, vo.getContent());
			result = psmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("Update 오류");
			e.printStackTrace();
		}
		return result;
	}


	public int DeleteLog(LogVO vo) {
		int result = 0;
		try {
			String query = "DELETE FROM LOG WHERE"
					+	" idx = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, String.valueOf(vo.getidx()));
			result = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("Delete오류");
			e.printStackTrace();
		}
		return result;
	}
}
