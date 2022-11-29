package com.mysite.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.dao.log.LogDao;
import com.mysite.dao.member.MemberInterface;
import com.mysite.domain.MemberVO;

@Service
public class MemberService {

		@Autowired
		private MemberInterface memberDao;
		
		@Autowired
		private LogDao logDao;
		
		@SuppressWarnings("unchecked")
		public List<MemberVO> getMembers(){
			Map<String,Object> map = memberDao.getMembers();
			List<MemberVO> list = (List<MemberVO>)map.get("data");
			if(list != null) logDao.addLog("get", (String)map.get("sql"), true);
			else logDao.addLog("get", (String)map.get("sql"), false);
			return list;
		}
		
		public MemberVO getMember(Integer id) {
			Map<String,Object> map = memberDao.getMember(id);
			MemberVO member = (MemberVO) map.get("data");
			if(member!=null)logDao.addLog("get", (String)map.get("sql"), true);
			else logDao.addLog("get", (String)map.get("sql"), false);
			return member;
		}
		
		public MemberVO addMember(MemberVO member) {
			Map<String,Object> map = memberDao.addMember(member);
			MemberVO m = (MemberVO)map.get("data");
			if(m!=null)logDao.addLog("post", (String)map.get("sql"), true);
			else logDao.addLog("post", (String)map.get("sql"), false);
			return m;
		}
		
		public MemberVO delelteMember(Integer id) {
			Map<String,Object> map = memberDao.deleteMember(id);
			MemberVO m = (MemberVO)map.get("data");
			if(m!=null)logDao.addLog("delete", (String)map.get("sql"), true);
			else logDao.addLog("delete", (String)map.get("sql"), false);
			return m;
		}

}
