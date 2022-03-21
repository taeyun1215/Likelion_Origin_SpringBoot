package LikeLion.example.LikeLion4.weeks1.post;

import java.util.List;

public interface PostRepository {
    boolean save(PostDto dto);
    List<PostDto> findAll();
    PostDto findById(int id);
    boolean update(int id, PostDto dto);
    boolean delete(int id);
}