package com.kosmo.jsonrestapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.IAndroidDAO;
import mybatis.MemberVO;

@Controller
public class AndroidController {
	// Mybatis 사용을 위한 자동주입
	@Autowired
	private SqlSession sqlSession;
	
	// 회원리스트 가져오기 (객체형태)
	@RequestMapping("/android/memberObject.do")
	@ResponseBody
	public Map<String, Object> memberObject(HttpServletRequest req) {
		ArrayList<MemberVO> lists =
			sqlSession.getMapper(IAndroidDAO.class).memberList();
		System.out.println("lists : "+ lists);
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("map : "+ map);
		map.put("memberList", lists);
		
		return map;
	}
	
	// 회원리스트 가져오기 (배열형태)
	@RequestMapping("/android/memberList.do")
	@ResponseBody
	public ArrayList<MemberVO> memberList(HttpServletRequest req) {
		ArrayList<MemberVO> lists =
			sqlSession.getMapper(IAndroidDAO.class).memberList();
		System.out.println("lists : "+ lists);
		
		return lists;
	}
	
	// 회원로그인하기 (객체형태)
	@RequestMapping("/android/memberLogin.do")
	@ResponseBody
	public Map<String, Object> memberLogin(HttpServletRequest req, MemberVO memberVO) {
		MemberVO vo =
				sqlSession.getMapper(IAndroidDAO.class).memberLogin(memberVO);
		Map<String, Object> map = new HashMap<String, Object>();
		int isLogin = 0;
		if(req.getParameter("id").equals("musthave") && req.getParameter("pass").equals("1234")) {
			isLogin = 1;
			map.put("memberInfo", vo);
		}
		map.put("isLogin", isLogin);
		
		return map;
	}
}
