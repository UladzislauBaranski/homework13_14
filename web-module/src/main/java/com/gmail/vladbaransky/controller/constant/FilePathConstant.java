package com.gmail.vladbaransky.controller.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository(value = "filePath")
public class FilePathConstant {

    @Value("${file}")
    private String filePath;

    public String getFilePath() {
        return filePath;
    }
}
