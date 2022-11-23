package com.mysite.domain;

import java.util.ArrayList;
import java.util.List;

import com.mysite.connector.ConnectH2;

public class MemberDAO extends ConnectH2 {
	String driver = "org.h2.Driver";
	String url = "jdbc:h2:tcp://localhost/~/test";  
	String id = "sa";
	String pwd = "";
    // 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.
    public MemberDAO(String drv, String url, String id, String pw) {
        super(drv, url, id, pw);
    }

    public List<MemberVO> getMemberVO() {
    	List<MemberVO> ms = new ArrayList<MemberVO>();
    	String query = "SELECT * FROM member";
    	
        try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비 // con : 부모로부터 상속받은것.
            rs = psmt.executeQuery();  // 쿼리문 실행
            System.out.println(rs);
            while (rs.next()) {  // 결과를 순화하며...
                // 한 행(게시물 하나)의 내용을 DTO에 저장
            	MemberVO dto = new MemberVO();
            	dto.setId(rs.getString("id"));
            	dto.setPass(rs.getString("pass"));
            	dto.setName(rs.getString("name"));
            	dto.setRegidate(rs.getString("regidate"));
                ms.add(dto);  // 결과 목록에 저장
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }
    
    // 명시한 아이디/패스워드와 일치하는 회원 정보를 반환합니다.
    public MemberVO getMemberVO(String uid, String upass) {
        MemberVO dto = new MemberVO();  // 회원 정보 DTO 객체 생성
        System.out.println(uid + "," + upass);
        String query = "SELECT * FROM member WHERE id=? AND pass=?";  // 쿼리문 템플릿
        
        try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비 // con : 부모로부터 상속받은것.
            psmt.setString(1, uid);    // 쿼리문의 첫 번째 인파라미터에 값 설정
            psmt.setString(2, upass);  // 쿼리문의 두 번째 인파라미터에 값 설정
            rs = psmt.executeQuery();  // 쿼리문 실행

            // 결과 처리
            if (rs.next()) {
                // 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
                dto.setId(rs.getString("id"));
                dto.setPass(rs.getString("pass"));
                dto.setName(rs.getString(3));
                dto.setRegidate(rs.getString(4));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dto;  // DTO 객체 반환
    }
    
    
    public int insertWrite(MemberVO vo) {
    	int result = 0;
    	try {
    		String query="INSERT INTO MEMBER("
    				+ "id,pass,name)"
    				+ " values("
    				+ "?,?,?)";
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, String.valueOf(vo.getId()));
    		psmt.setString(2, vo.getPass());
    		psmt.setString(3, vo.getName());
    		result = psmt.executeUpdate();
    		
    	}catch(Exception e) {
    		System.out.println("insert 오류");
    		
    		e.printStackTrace();
    	}
    	return result;
    }
    public int updateMember(MemberVO vo) {
    	int result = 0;
    	try {
    		String query="UPDATE MEMBER SET "
    				+ "NAME = ?,"
    				+ "PASS = ?"
    				+ "WHERE ID = ?";
    		psmt = con.prepareStatement(query);
    		psmt.setString(3, String.valueOf(vo.getId()));
    		psmt.setString(2, vo.getPass());
    		psmt.setString(1, vo.getName());
    		result = psmt.executeUpdate();
    		
    	}catch(Exception e) {
    		System.out.println("UPDATE 오류");
    		
    		e.printStackTrace();
    	}
    	return result;
    }
    public int DeleteMember(MemberVO vo) {
    	int result = 0;
    	try {
    		String query="DELETE FROM MEMBER WHERE"
    				+ " ID = ?";
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, String.valueOf(vo.getId()));
    		result = psmt.executeUpdate();
    		
    	}catch(Exception e) {
    		System.out.println("DELETE 오류");
    		e.printStackTrace();
    	}
    	return result;
    }
}
