package com.mysite.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class MemberDaoList implements MemberDAO{
	private List<MemberVO> memberList;
	
	public MemberDaoList() {
		memberList = new ArrayList<MemberVO>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		try {
			BufferedReader br = new BufferedReader(new FileReader("list.txt"));
			
			String str;
			while((str = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(str,",");
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				String s3 = st.nextToken();
				
				memberList.add(new MemberVO(s1,s2,s3,format.format(new Date())));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		for(int i = 1;i<=20;i++) {
//			MemberVO member = new MemberVO();
//			member.setId(Integer.toString(i));
//			member.setName("이름"+i);
//			member.setPass("pass"+i);
//			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			member.setRegidate(transFormat.format(new Date()));
//			memberList.add(member);	
//		}
	}

	@Override
	public List<MemberVO> getMemberVO() {
		return memberList;
	}

	@Override
	public MemberVO getMemberVO(String uid) {
		for(MemberVO m : memberList) {
			if(m.getId().equals(uid))return m;
		}
		return null;
	}

	@Override
	public int insertWrite(MemberVO vo) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		vo.setRegidate(transFormat.format(new Date()));
		vo.setId(Integer.toString(memberList.size()+1));		
		memberList.add(vo);
		return 1;
	}

	@Override
	public int updateMember(MemberVO vo) {
		for(int i = 1;i<=memberList.size()-1;i++) {
			if(memberList.get(i).getId() == vo.getId()) {
				memberList.set(i, vo);return 1;
			}
		}
		return 0;
	}

	@Override
	public int DeleteMember(MemberVO vo) {
		for(MemberVO m : memberList) {
			if(m.getId() == vo.getId()) {
				memberList.remove(m);
				return 1;
			}
		}
		return 0;
	}

}
