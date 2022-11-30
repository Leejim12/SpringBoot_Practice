package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;
// 235page : 삭제
public class JPAClient3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			for(int i = 0;i<10;i++) {
				tx.begin();
				// 삭제할거 조회
				Board board1 = em.find(Board.class, 1L); 
				// 게시글 삭제
				board1.setSeq(1L);
				em.remove(board1);
				// 트랜잭션 커밋
				tx.commit();
				System.out.println("--> Commit");
			}
		}catch(Exception e) {
			tx.rollback();
			System.out.println("--> Rollback");
		}finally {
//			test(emf);
			em.close();
			emf.close();
			System.out.println("Done!");
		}
	}
//	public static void test(EntityManagerFactory emf) {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		try {
//			for(int i = 0;i<10;i++) {
//				tx.begin();
//				Board board = new Board();
//				board.setSeq(4L);
//				board.setTitle("JPA 제목" + i);
//				board.setWriter("관리자" + i);
//				board.setContent("JPA 글 등록 잘 되네요.");
//				board.setCreateDate(new Date());
//				board.setCnt(0L);
//			// 글 등록
//			em.persist(board);
//			
//			// 트랜잭션 커밋
//			tx.commit();
//			System.out.println("--> Commit");
//			}
//		}catch(Exception e) {
//			tx.rollback();
//			System.out.println("--> Rollback");
//		}finally {
//			em.close();
//			emf.close();
//			System.out.println("Done!");
//		}
//	}
}
