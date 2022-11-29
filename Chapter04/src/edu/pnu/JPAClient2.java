package edu.pnu;
// 데이터 검색.
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		try {
			// 글 상세 조회
				Board searchBoard = em.find(Board.class, 1L); // 조회 메소드
				System.out.println(searchBoard);
				System.out.println("---->" + searchBoard.toString());
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				em.close();
				emf.close();
		}
	}
}
