package LikeLion.example.LikeLion4.weeks1.service;

import LikeLion.example.LikeLion4.weeks1.model.MediaDescriptorDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface MediaService {
    MediaDescriptorDto saveFile(MultipartFile file);
    Collection<MediaDescriptorDto> saveFileBulk(MultipartFile[] files);
    byte[] getFileAsBytes(String resourcePath);
}
