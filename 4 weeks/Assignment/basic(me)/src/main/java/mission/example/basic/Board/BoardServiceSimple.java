package mission.example.basic.Board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceSimple implements BoardService{
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceSimple.class);
    private final BoardRepository boardRepository;

    public BoardServiceSimple(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void createBoard(BoardDto boardDto) {
        this.boardRepository.save(boardDto);
    }
}
