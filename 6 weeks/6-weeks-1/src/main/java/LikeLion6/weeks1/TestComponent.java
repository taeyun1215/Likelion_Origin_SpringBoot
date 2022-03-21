package LikeLion6.weeks1;

import LikeLion6.weeks1.entity.BoardEntity;
import LikeLion6.weeks1.entity.PostEntity;
import LikeLion6.weeks1.repository.BoardRepository;
import LikeLion6.weeks1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    public TestComponent(@Autowired BoardRepository boardRepository, @Autowired PostRepository postRepository) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("new Board");
        BoardEntity newBoardEntity = boardRepository.save(boardEntity);
        System.out.println(newBoardEntity.getName());

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("Hello ORM");
        postEntity.setContent("taeyun Loves jina");
        postEntity.setWriter("taeyun");
        postEntity.setBoardEntity(newBoardEntity);
        PostEntity newPostEntity = postRepository.save(postEntity);

        System.out.println(postRepository.findAllByWriter("taeyun").size());
    }
}
