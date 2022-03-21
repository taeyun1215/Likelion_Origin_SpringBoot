package LikeLion7.weeks2;

import LikeLion7.weeks2.entity.PostEntity;
import LikeLion7.weeks2.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class
)
@AutoConfigureMockMvc
@EnableAutoConfiguration
@AutoConfigureTestDatabase
public class PostControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Before
    public void setEntities() {
        createTestPost("first Post", "first post content", "test_writer");
        createTestPost("second Post", "second post content", "test_writer");
    }

    @Test
    void givenValidId_whenReadPost_then200() throws Exception {
        // given
        Long id = createTestPost("Read Post", "Created on readPost()", "read_test");

        // when
        final ResultActions actions = mockMvc.perform(get("/post/{id}", id))
                .andDo(print());

        // then
        actions.andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("$.title", is("Read Post")),
                jsonPath("$.content", is("Created on readPost()"))
        );
    }

    private Long createTestPost(String title, String content, String writer) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setTitle(content);
        postEntity.setTitle(writer);
        return postRepository.save(postEntity).getId();
    }
}
