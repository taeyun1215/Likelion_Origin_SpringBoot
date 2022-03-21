package LikeLion.example.LikeLion3.weeks1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController // Controller + ResponseBody
@RequestMapping("/rest")
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    @GetMapping("/sample-payload")
    public SamplePayload samplePayloadGet() {
        return new SamplePayload("taeyun", 27, "developer");
    }

    @PostMapping("/sample-payload")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void samplePayloadPost(@RequestBody SamplePayload samplePayload) {
        logger.info(samplePayload.toString());
    }

    @PostMapping(value = "/sample-multipart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sampleMultipartPost(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("occupation") String occupation,
            @RequestParam("file") MultipartFile multipartFile
    ){
        logger.info("name: " + name);
        logger.info("age: " + age);
        logger.info("occupation: " + occupation);
        logger.info("file original name: " + multipartFile.getOriginalFilename());
    }

    @GetMapping(value = "sample-image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] sampleImage() throws IOException {    // 이미지, 영상은 byte[] 로 해줌
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");
//        inputStream = new FileInputStream(new File(""));
        return inputStream.readAllBytes();
    }
}
