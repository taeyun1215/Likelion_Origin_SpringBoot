package mission.example.basic.post;

import mission.example.basic.Board.BoardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{boardName}")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@PathVariable("boardName") BoardDto boardName, @RequestBody PostDto postDto) {
        logger.info(boardName.toString());
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
        return this.postService.readPostAll();
    }

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post one");
        return this.postService.readPost(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") int id, @RequestBody PostDto postDto) {
        logger.info("target id" + id);
        logger.info("update content" + postDto);
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id, @RequestBody String password) {
        logger.info("delete password: " + password);
        this.postService.deletePost(id, password);
    }
}
