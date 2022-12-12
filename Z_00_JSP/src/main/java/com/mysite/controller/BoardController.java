package com.mysite.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.domain.Board;

@Controller
public class BoardController {

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
		// boardList 생성 (만든 데이터를 넣어 둘 리스트)
		List<Board> boardList = new ArrayList<Board>();
		
		for(int i = 1;i<=10;i++) {
			Board board = new Board(i,"게시판 프로그램 테스트","도우너","테스트 입니다.",new Date(),i);
			boardList.add(board);
		}
		// 모델의 역할 :: 컨트롤러에서 생성한 데이터를 View(JSP)로 전달하는 역할
			// 형태 : 해시맵 --> 키,밸류 가짐.
			// Servlet의 request.setAttribute()와 같은 역할
		model.addAttribute("boardList",boardList);
		//					키		   value	
		return "getBoardList";
	}
}
