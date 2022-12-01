package com.mysite;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysite.domain.Board;
import com.mysite.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
	
	//  Before로 사전 데이터 입력
//	@Test
//	@Before
//	public void dataPrepate() {
//		Random random = new Random();
//		for(int i = 1;i<=200;i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목"+i);
//			board.setWriter("테스터"+i);
//			board.setContent("테스트 내용" + i);
//			board.setCreateDate(new Date());
//			board.setCnt(random.nextLong(100));
//			boardRepo.save(board);
//		}
//	}
	
	// Title 조회
//	@Test
//	public void testFindbyTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목10");
//		System.out.println("Search Result ::");
//		for(Board board:boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
	// Like 연산자를 통한 조회
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		System.out.println("검색결과");
//		for (Board board : boardList) {
//			System.out.println("---->" + board.toString());
//		}
//	}
	
	// 데이터 정렬 검색
//	@Test
//	public void findByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색 결과");
//		for (Board board:boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
	// 페이징:: 한 화면에 5개 데이터만 조회
	// 정렬 처리 :: 데이터를 정렬해서 처리 -> Sort 클래스 사용
//	@Test // (1)페이징
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5);
//		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
//		
//		System.out.println("검색 결과");
//		for(Board board:boardList) {
//			System.out.println("==========>" + board.toString());
//		}
//	}
//	@Test // (2)정렬처리
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5,Sort.Direction.DESC,"seq");
//		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
//		
//		System.out.println("검색 결과");
//		for(Board board:boardList) {
//			System.out.println("==========>" + board.toString());
//		}
//	}
///////////////////////////////////// 쿼리 메소드 활용 실습 ////////////////////////////////////
	// 1. title 1 포함
//	@Test
	void t1() {
		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqAsc("1");
		System.out.println("======================== 실습 1검색 결과 ======================");
		for (Board board : boardList) {
			System.out.println("---->" + board.toString());
		}
	}
	// 2. title 1 포함 and cnt 50보다 큰
//	@Test
	void t2() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);
		System.out.println("======================== 실습 2검색 결과 ======================");
		for (Board board : boardList) {
			System.out.println("---->" + board.toString());
		}
	}
	// 3. cnt 10 ~ 50 seq 오름차순
//	@Test
	void t3() {
		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeqAsc(10L, 50L);
		System.out.println("======================== 실습 3검색 결과 ======================");
		for (Board board : boardList) {
			System.out.println("---->" + board.toString());
		}
	}
	// 4. title 10 포함 or content 2 포함 데이터 seq 내림차순 
//	@Test
	void t4() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		System.out.println("======================== 실습 4검색 결과 ======================");		for (Board board : boardList) {
			System.out.println("---->" + board.toString());
		}
	}
	////////////////////////////////////// @ Query ////////////////////////////////////////
//	@Test // ???
	void qt() {
		List<Board> boardList = boardRepo.queryTE("테스트 제목1");
		System.out.println("======================== @Query Ppt 예제 ======================");
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}

//	@Test
	void bt() {
		List<Board> boardList = boardRepo.qt("테스트 제목1");
		System.out.println("========================276p @Query 책예제1 ======================");
		for(Board board:boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
//	@Test
	void bt1() {
		List<Board> boardList = boardRepo.qt1("테스트 제목10");
		System.out.println("========================277p @Query 책예제2 ======================");
		for(Board board:boardList) {
			System.out.println("--->" + board.toString());
		}
	}
//	@Test
	void bt2() {
		List<Object[]> boardList = boardRepo.qt2("테스트 제목10");
		System.out.println("========================278p @Query 책예제3 ======================");
		for(Object[] board:boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
//	@Test
	void bt3() {
		List<Object[]> boardList = boardRepo.qt3("테스트 제목10");
		System.out.println("========================280p 네이티브쿼리 사용 책예제4 ======================");
		for(Object[] board:boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	@Test
	void bt4() {
		Pageable paging = PageRequest.of(0, 3,Sort.Direction.DESC,"seq");
		List<Board> boardList = boardRepo.qt4(paging);
		System.out.println("========================282p 페이징 및 정렬 책예제5 ======================");
		for(Board board:boardList) {
			System.out.println("--->" + board.toString());
		}
	}
}
