package LikeLion.example.LikeLion3.weeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController // Controller + ResponseBody
@RequestMapping("/rest")    // 이 클래스에 모든 url은 http://localhost:8080/rest로 시작함
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    @GetMapping("/sample-payload")  // http://localhost:8080/rest/sample-payload
    public SamplePayload samplePayload() {
        return new SamplePayload("taeyun", 27, "developer");
    }

    @GetMapping(value = "sample-image", produces = MediaType.IMAGE_PNG_VALUE)   // http://localhost:8080/rest/sample-image
    public byte[] sampleImage() throws IOException {    // 이미지, 영상은 byte[] 로 해줌
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");
//        inputStream = new FileInputStream(new File(""));
        return inputStream.readAllBytes();
    }
}
