package LikeLion7.weeks2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createBoard() throws Exception {
        // given
        BoardDto boardDto = new BoardDto();
        boardDto.setName("notice");

        // when
        final ResultActions actions = mockMvc.perform(post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(boardDto)))
                .andDo(print());

        // then
        actions.andExpectAll(
                status().is2xxSuccessful(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("&.name", is("notice"))
        );
    }

    private byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
