package LikeLion.example.LikeLion4.weeks1.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
//    private final List<PostDto> postList;
    private final PostService postService;  // class가 아닌 interface를 초기화해줌

    public PostRestController(@Autowired PostService postService) {
//        this.postList = new ArrayList<>();
        this.postService = postService;
    }

    // http://localhost:8080/post
    @PostMapping()  // create는 PostMapping으로 많이 함
    @ResponseStatus(HttpStatus.CREATED) // postman 앱에서 201 Created 뜸 그럼 성공적임, 원래는 200 ok만 뜸
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
//        this.postList.add(postDto);
        this.postService.createPost(postDto);
    }

    // http://localhost:8080/post
    @GetMapping()   // read는 GetMapping으로 많이 함
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
//        return this.postList;
        return this.postService.readPostAll();
    }

    // http://localhost:8080/post/0
    @GetMapping("{id}") // read는 GetMapping으로 많이 함
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post one");
//        return this.postList.get(id);
        return this.postService.readPost(id);
    }

    // http://localhost:8080/post/0
    @PutMapping("{id}") // update는 PutMapping으로 많이 함
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") int id, @RequestBody PostDto postDto) {
/*        PostDto targetPost = this.postList.get(id);

        if (postDto.getTitle() != null) {
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());
        }

        this.postList.set(id, targetPost);*/
        logger.info("target id" + id);
        logger.info("update content" + postDto);
        this.postService.updatePost(id, postDto);
    }

    // http://localhost:8080/post/0
    @DeleteMapping("{id}")  // delete는 DeleteMapping으로 많이 함
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
//        this.postList.remove(id);
        this.postService.deletePost(id);
    }

    // Post /post   -> create
    // Get /post/0  -> read
    // Get /post    -> read
    // Put /post/0  -> update
    // Delete /post/0   -> delete

}
