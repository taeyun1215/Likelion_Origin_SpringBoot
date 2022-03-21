package mission.example.basic.Board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepositorySimple implements BoardRepository{
    private static final Logger logger = LoggerFactory.getLogger(BoardRepositorySimple.class);
    private final List<BoardDto> boardList;

    public BoardRepositorySimple() {
        this.boardList = new ArrayList<>();
    }

    @Override
    public boolean save(BoardDto boardDto) {
        return this.boardList.add(boardDto);
    }
}
