package LikeLion7.weeks1;

import LikeLion7.weeks1.exception.BaseException;
import LikeLion7.weeks1.exception.ErrorResponseDto;
import LikeLion7.weeks1.exception.PostNotInBoardException;
import LikeLion7.weeks1.exception.PostNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("except")
public class ExceptTestController {
    @GetMapping("{id}")
    public void throwException(@PathVariable int id) {
        switch (id) {
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponseDto handleBaseException(BaseException exception) {  // HttpServletResponse response이거를 매개변수로 쓰던가 ResponseStatus 사용하면 됨
//        return new ErrorResponseDto(exception.getMessage());
//    }
}
