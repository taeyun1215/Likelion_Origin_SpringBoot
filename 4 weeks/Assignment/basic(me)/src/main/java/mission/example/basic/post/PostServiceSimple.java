package mission.example.basic.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceSimple implements PostService{
    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final PostRepository postRepository;    // class가 아닌 interface를 초기화해줌

    public PostServiceSimple(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto dto) {
        // TODO
        if (!this.postRepository.save(dto)) {
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<PostDto> readPostAll() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto dto) {
        this.postRepository.update(id, dto);
    }

    @Override
    public void deletePost(int id, String password) {
        this.postRepository.delete(id, password);
    }
}
