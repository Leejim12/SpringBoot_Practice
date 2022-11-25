package com.mysite.dao.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mysite.domain.MemberVO;

@Repository
public class MemberDaoList implements MemberInterface {
	private List<MemberVO> memberlist;
	
	public MemberDaoList() {
		memberlist = new ArrayList<>();
		for(int i = 1;i<=20;i++) {
			memberlist.add(new MemberVO(i,"1234","이름"+i,new Date()));
		}
	}

	@Override
	public Map<String, Object> getMembers() {
		Map<String,Object> map = new HashMap<>();
		map.put("sql", "from list getMembers()");
		map.put("data", memberlist);
		return map;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
		for(MemberVO m : memberlist) {
			if(m.getId() == id) {
				Map<String,Object> map = new HashMap<>();
				map.put("sql", "from list getMember()");
				map.put("data", m);
				return map;
			}
		}
		return null;
	}
	
	private int getNextID() {
		return memberlist.size()+1;
	}

	@Override
	public Map<String, Object> addMember(MemberVO member) {
		member.setId(getNextID());
		member.setRegidate(new Date());
		memberlist.add(member);
		
		Map<String,Object> map = new HashMap<>();
		map.put("sql", "from list addMember");
		map.put("data", member);
		return map;
	}
	
	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		for(MemberVO m : memberlist) {
			if(m.getId() == member.getId()) {
				m.setName(member.getName());
				m.setPass(member.getPass());
				
				Map<String,Object> map = new HashMap<>();
				map.put("sql", "from list updateMember");
				map.put("data", m);
				return map;
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		for(MemberVO m : memberlist) {
			if(m.getId() == id) {
				memberlist.remove(m);
				
				Map<String,Object> map = new HashMap<>();
				map.put("sql", "from list deleteMember");
				map.put("data", m);
				
				return map;
			}
		}
		return null;
	}
}
