package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.domain.Board;
import com.mysite.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
	// requestMapping : CRUD 다 받음.
	// RestController : RestAPI를 위한 Controller
	// 그냥 Controller : 
	
	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}
//	@GetMapping("/test2")
//	public String test2() {
//		return "test2"; ===> /WEB-INF/board/test2.jsp
//	}                                      !!![이거 두개는 같다]!!!
//	@GetMapping("/test2")
//	public void test2() {
//	}
	
//	@RequestMapping("/getBoardList")
//	public String getBoardList(Model model) {
//		// model : Spring의 MVC 객체 
//		List<Board> boardList = new ArrayList<Board>();
//		Random rd = new Random();
//		
//		for(int i = 1;i<=10;i++) {
//			Board board= new Board();
//			board.setSeq(Long.valueOf(i));
//			board.setTitle("게시판 테스트 ver 0");
//			board.setWriter("Lee chan");
//			board.setCreateDate(new Date());
//			board.setCnt(rd.nextLong(100));
//			boardList.add(board);
//		}
//		model.addAttribute("boardList",boardList); // 페이지 영역에 자동으로 저장 됨.
//		// 앞에꺼 이름으로 뒤에꺼를 저장해줌. 
//		return "getBoardList";
//	}
//	
//	@RequestMapping("/getBoardList1")
//	public ModelAndView getBoardList1(Model model) {
//		ModelAndView mv = new ModelAndView();
//		
//		// model : Spring의 MVC 객체 
//		List<Board> boardList = new ArrayList<Board>();
//		
//		for(int i = 1;i<=10;i++) {
//			Board board= new Board();
//			board.setSeq((long)i);
//			board.setTitle("게시판 프로그램 테스트");
//			board.setWriter("도우너");
//			board.setCreateDate(new Date());
//			board.setCnt(100L);
//			boardList.add(board);
//		}
//		
//		mv.addObject("boardList",boardList);
//		mv.setViewName("getBoardList");
//		
//		return mv;
//		
//	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model,Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board,Model model) {
		System.out.println("seq::"+board.getSeq());
		model.addAttribute("board",boardService.getBoard(board));
		return "getBoard";		
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	

	
}
