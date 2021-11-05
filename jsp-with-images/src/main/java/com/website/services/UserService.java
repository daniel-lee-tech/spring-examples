package com.website.services;

import com.website.entities.User;
import com.website.mockDatabase.MockDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UserService {
    @Autowired
    MockDatabase mockDatabase;

    public void handleImageUpload(String imageName, MultipartFile imageFile) throws IOException {
        Path uploadPath = Paths.get("src/main/webapp/WEB-INF/images/");
        InputStream inputStream = imageFile.getInputStream();
        Path filePath = uploadPath.resolve(imageName);
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    }

    public String validateImageNameUniqueness(MultipartFile imageFile) {
        for (User loopedUser : mockDatabase.findAllUsers()) {
            if (loopedUser.getImageUrl().equals("/images/" + imageFile.getOriginalFilename())) {
                String originalName = imageFile.getOriginalFilename();
                String imageName = imageFile.getName();
                assert originalName != null;
                String extension = originalName.substring(originalName.lastIndexOf(".") + 1);
                return imageName + (int) Math.ceil(Math.random() * 100000) + "." + extension;
            }
        }

        return imageFile.getOriginalFilename();
    }
}
