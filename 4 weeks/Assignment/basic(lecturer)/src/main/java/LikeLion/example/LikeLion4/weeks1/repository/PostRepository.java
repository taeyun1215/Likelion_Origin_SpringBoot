package LikeLion.example.LikeLion4.weeks1.repository;

import LikeLion.example.LikeLion4.weeks1.model.PostDto;

import java.util.Collection;

public interface PostRepository {
    PostDto create(Long boardId, PostDto dto);
    PostDto read(Long boardId, Long postId);
    Collection<PostDto> readAll(Long boardId);
    boolean update(Long boardId, Long postId, PostDto dto);
    boolean delete(Long boardId, Long postId, String password);
}
