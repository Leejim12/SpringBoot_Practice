package com.mysite.dao.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysite.domain.MemberVO;

@Repository
public class MemberDaoH2 implements MemberInterface {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDaoH2(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Map<String, Object> getMembers() {
		String sqlString = "select * from member order by id asc";
		Map<String,Object> ret = new HashMap<>();
		ret.put("sql",sqlString);
		try {
			List<MemberVO> list = jdbcTemplate.query(sqlString, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		}catch(Exception e) {
			ret.put("data", null);
		}
		return ret;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
		Map<String,Object> ret = new HashMap<>();
		String sqlString = String.format("select * from member where id = %d", id);
		ret.put("sql", sqlString);
		try {
			MemberVO member = jdbcTemplate.queryForObject(sqlString, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
			ret.put("data", member);
		}catch(Exception e) {
			ret.put("data", null);
		}
		return ret;
	}

	@Override
	public Map<String, Object> addMember(MemberVO member) {
		Map<String,Object> ret = new HashMap<>();
		String sqlString = "insert into member(id,pass,name) values (?,?,?)";
		ret.put("sql", sqlString);
		int id;
		try {
			id = jdbcTemplate.queryForObject("select max(id) from member",Integer.class) + 1;
			ret.put("data", member);
		}catch(Exception e) {
			ret.put("data", null);
		}
		return ret;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
