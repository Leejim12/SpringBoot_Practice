package com.mysite.persistence;

import org.springframework.data.repository.CrudRepository;

import com.mysite.domain.Board;

public interface BoardRepository extends CrudRepository<Board,Long>{

}
