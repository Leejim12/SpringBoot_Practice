package edu.pnu;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			// 글 상세 조회
				// 트랜잭션 시작
				tx.begin();
				
				// 조회 쿼리
				String jpql = "select b from Board b order by b.seq desc";
				List<Board> boardList=
						em.createQuery(jpql,Board.class).getResultList();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				em.close();
				emf.close();
		}
	}
}
