package LikeLion.LikeLion5.weeks1.mapper;

import LikeLion.LikeLion5.weeks1.dto.PostDto;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto);
    int createPostAll(List<PostDto> dtoList);
    PostDto readPost(int id);
    List<PostDto> realPostAll();
    PostDto readPostQuery(PostDto dto);
    int updatePost(PostDto dto);
    int deletePost(int id);
}
