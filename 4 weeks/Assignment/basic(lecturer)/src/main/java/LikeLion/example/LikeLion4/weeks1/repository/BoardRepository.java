package LikeLion.example.LikeLion4.weeks1.repository;

import LikeLion.example.LikeLion4.weeks1.model.BoardDto;

import java.util.Collection;

public interface BoardRepository {
    BoardDto create(BoardDto dto);
    BoardDto read(Long id);
    Collection<BoardDto> readAll();
    boolean update(Long id, BoardDto dto);
    boolean delete(Long id);
}
