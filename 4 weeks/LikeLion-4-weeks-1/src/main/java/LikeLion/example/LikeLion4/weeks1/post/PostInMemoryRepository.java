package LikeLion.example.LikeLion4.weeks1.post;

import ch.qos.logback.classic.turbo.TurboFilter;
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
    public boolean delete(int id) {     // delete
        this.postList.remove(id);
        return true;
    }
}
