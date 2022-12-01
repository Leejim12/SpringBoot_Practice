package com.mysite.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mysite.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
//// 제일 처음 연습한거.
//	List<Board> findByTitle(String searchKeyword); // 키워드 검색
//	List<Board> findByContentContaining(String searchKeyword); // Like 검색
//	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
//	List<Board> findByTitleContaining(String searchKeyword,Pageable paging); // 
//	Page<Board> findByTitleContaining(String searchKeyword,Pageable paging); // 

	////////////////////// 쿼리 메소드 활용 실습 /////////////////////////
	
	// 1. title 포함 + seq 오름차순 검색
	List<Board> findByTitleContainingOrderBySeqAsc(String searchKeyword);
	
	// 2. cnt 50 이상 데이터 
	List<Board> findByTitleContainingAndCntGreaterThan(String searchKeyword,Long cnt);
		
	// 3. cnt 10~50 사이 데이터 seq 오름차순
	List<Board> findByCntBetweenOrderBySeqAsc(Long cnt1,Long cnt2);
	
	// 4. title 10 포함 or content 2 포함 데이터 seq 내림차순  
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String s1,String s2);

	////////////////////////////// @Query ////////////////////////////
	// 예제
	@Query(value = "select * from board b where b.title like %?1% order by b.seq desc",nativeQuery=true)
	List<Board> queryTE(String searchKeyword);
	
	// P275
	@Query(value="select * from board b where b.title like %?1% order by b.seq Desc",nativeQuery=true)
	List<Board> qt(String searchKeyword);
	
	// P277 : 이름 기반 파라미터 사용 + .
	@Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
	List<Board> qt1(@Param("searchKeyword") String searchKeyword);

	// P278 : 특정 변수만 조회
	@Query("select b from Board b where b.title like %?1% order by b.seq desc")
	List<Object[]> qt2(@Param("searchKeyword") String searchKeyword);
	//// * 어떤 변수가 조회될지 모르기 때문에, return Type은 <Object가 되어야 함.>
	
	// P280 : 네이티브 쿼리 사용
	@Query(value="select seq, title, writer, createdate "
			+ "from board where title like '%'||?1||'%' "
			+ "order by seq desc",nativeQuery=true)
	List<Object[]> qt3(String searchKeyword);
	
	// P282 : 페이징 & 정렬기능
	@Query("select b from Board b order by b.seq DESC")
	List<Board> qt4(Pageable paging);
}