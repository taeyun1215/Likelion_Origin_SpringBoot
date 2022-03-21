package LikeLion.LikeLion5.weeks1.dao;

import LikeLion.LikeLion5.weeks1.dto.PostDto;
import LikeLion.LikeLion5.weeks1.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {
    private final SqlSessionFactory sessionFactory;

    public PostDao(@Autowired SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int createPost(PostDto dto) {
        try (SqlSession session = sessionFactory.openSession()){    // openSession메소드에 매계변수를 비워두면 false로 반환됨
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
        }
    }

    public PostDto readPost(int id) {
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }

    public List<PostDto> readPostAll() {
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.realPostAll();
        }
    }

    public int updatePost(PostDto dto) {
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
        }
    }

    public int deletePost(int id) {
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
        }
    }
}
