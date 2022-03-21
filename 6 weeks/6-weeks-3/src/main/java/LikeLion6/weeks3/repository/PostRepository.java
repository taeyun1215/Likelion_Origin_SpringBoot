package LikeLion6.weeks3.repository;

import LikeLion6.weeks3.entity.BoardEntity;
import LikeLion6.weeks3.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer);    // where writer = ?
    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity);
    List<PostEntity> findAllByWriterContaining(String writer);
}
