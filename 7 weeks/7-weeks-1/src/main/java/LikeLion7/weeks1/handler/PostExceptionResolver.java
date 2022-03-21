package LikeLion7.weeks1.handler;

import LikeLion7.weeks1.exception.BaseException;
import LikeLion7.weeks1.exception.ErrorResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostExceptionResolver extends AbstractHandlerExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.warn(ex.getClass());
//        if (ex instanceof BaseException) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            try {
//                response.getOutputStream().print(new ObjectMapper().writeValueAsString(
//                        new ErrorResponseDto("in resolver, message" + ex.getMessage())));
//                response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//                return new ModelAndView();
//            } catch (IOException e) {
//                logger.warn("Handling exception caused exception : {}", e);
//            }
//        }
        return null;
    }
}
