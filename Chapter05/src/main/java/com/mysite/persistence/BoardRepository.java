package com.mysite.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByTitle(String searchKeyword);
}
