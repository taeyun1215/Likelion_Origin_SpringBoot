package mission.example.basic.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostInMemoryRepository implements PostRepository{
    private static final Logger logger = LoggerFactory.getLogger(PostInMemoryRepository.class);
    private final List<PostDto> postList;

    public PostInMemoryRepository() {
        this.postList = new ArrayList<>();
    }

    @Override
    public boolean save(PostDto dto) {  // create
        return this.postList.add(dto);
    }

    @Override
    public List<PostDto> findAll() {    // read-all
        return this.postList;
    }

    @Override
    public PostDto findById(int id) {    // read-one
        return this.postList.get(id);
    }

    @Override
    public boolean update(int id, PostDto postDto) {    // update
        PostDto targetPost = this.postList.get(id);

        if (postDto.getTitle() != null) {
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());
        }

        this.postList.set(id, targetPost);
        return true;
    }

    @Override
    public boolean delete(int id, String password) {     // delete
        logger.info("기존 비밀번호: " + this.postList.get(id).getPassword());
        logger.info("입력한 비밀번호: " + password);
        logger.info(this.postList.get(id).getPassword().getClass().getName());
        logger.info(password.getClass().getName());
        if (this.postList.get(id).getPassword() == password) {
            this.postList.remove(id);
        }
        return true;
    }
}
