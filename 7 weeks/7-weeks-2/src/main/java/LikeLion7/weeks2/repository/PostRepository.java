package LikeLion7.weeks2.repository;

import LikeLion7.weeks2.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer);    // where writer = ?
    List<PostEntity> findAllByWriterAndBoardEntity(String writer);
    List<PostEntity> findAllByWriterContaining(String writer);
}
