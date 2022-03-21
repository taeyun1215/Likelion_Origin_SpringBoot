package LikeLion7.weeks1;

import LikeLion7.weeks1.aspect.LogExecutionTime;
import LikeLion7.weeks1.aspect.LogArguments;
import LikeLion7.weeks1.aspect.LogReturn;
import LikeLion7.weeks1.exception.PostNotExistException;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
//    private final Gson gson;

//    public PostController(@Autowired PostService postService, @Autowired GsonComponent gson) {
//        this.postService = postService;
//        this.gson = gson.getGson();
//    }
    public PostController(@Autowired PostService postService, @Autowired Gson gson) {
        this.postService = postService;
        logger.info(gson.toString());
    }

    @LogArguments
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody PostDto dto) {
        this.postService.createPost(dto);
    }

    @LogReturn
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        return this.postService.readPost(id);
    }

    @LogExecutionTime
    @GetMapping("")
    public List<PostDto> readPostAll() {
        return this.postService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto dto) {
        this.postService.updatePost(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }

    @GetMapping("test-log")
    public void testLog() {
        logger.trace("TRACE Log Message");
        logger.debug("DEBUG Log Message");
        logger.info("INFO Log Message");
        logger.warn("WARN Log Message");
        logger.error("ERROR Log Message");
    }

    @PostMapping("test-valid")
    public void testValid(@Valid @RequestBody ValidTestDto dto) {
        logger.warn(dto.toString());
    }

    @GetMapping("test-exception")
    public void throwException() {
        throw new PostNotExistException();
    }
}