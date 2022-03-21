package LikeLion.example.LikeLion3.weeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);   // log 기록 남기기

    @GetMapping(value = "/hello")   // http://localhost:8080/hello
    public String hello(@RequestParam(name = "id", required = false, defaultValue = "") String id) {
        // http://localhost:8080/hello?id=taeyun ? <- 이걸로 받음, required = false 를 입력하면 앞에 링크에서 ?id=taeyun 을 입력하지 않아도 오류가 발생하지 않는다
        logger.info("Path Hello");  // Path Hello
        logger.info("Query Param id: " + id);   // Query Param id: taeyun
        return "/hello.html";   // resources/static/hello.html 경로로 감
    }

    @GetMapping(value = "/hello/{id}")   // http://localhost:8080/hello/taeyun
    public String helloPath(@PathVariable("id") String id) {
//        logger.info(id);    // http://localhost:8080/hello/taeyun 입력하면 taeyun이 콘솔창에 뜸
        logger.info("Path Variable is: " + id);
        return "/hello.html";
    }

    @GetMapping("/get-profile")  // http://localhost:8080/get-profile
    public @ResponseBody SamplePayload getProfile() {   // @ResponseBody 이거를 붙이면 {"name":"taeyun","age":27,"occupation":"Developer"} 이렇게 웹 페이지가 나옴
        return new SamplePayload("taeyun", 27, "Developer");
    }
}
