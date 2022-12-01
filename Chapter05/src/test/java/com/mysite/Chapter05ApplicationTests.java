package com.mysite;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.domain.Board;
import com.mysite.persistence.BoardRepository;

@SpringBootTest
class Chapter05ApplicationTests {
	
	@Autowired
	private BoardRepository boardRepo;

	void contextLoads() {
		boardRepo.save(new Board(
				20L,
//				Long.valueOf(10+i),
				"1",
				"1",
				"1",
				new Date(),
				0L
				));
	}
	
//	void mission() {
//		for(int i=1;i<=20;i++) {
//		boardRepo.save(new Board(
//				10L+Long.valueOf(i-1),
////				Long.valueOf(ai),
//				"title2",
//				"writer2",
//				"content2",
//				new Date(),
//				0L
//				));
//		System.out.println("생성 완료");
//		}	
//	}
//	
/////////////// 2. 조회 기능 /////////////
//	public void testGetBoard() {
//		Board board = boardRepo.findById(1L).get();
//		System.out.println(board.toString());
//		System.out.println("TestGetBoard 실행");
//	}
//	
/////////////// 3. 수정 기능 /////////////	
//	public void testUpdateBoard() {
//		System.out.println("=== 1번 게시글 조회 ===");
//		Board board = boardRepo.findById(1L).get();
//		
//		System.out.println("=== 1번 게시글 수정 ===");
//		board.setTitle("수정 되는지 확인용");
//		boardRepo.save(board);
//	}
/////////////// 4. 삭제 기능 /////////////	
//	public void testDeleteBoard() {
//		boardRepo.deleteById(1L);
//	}
	
}
