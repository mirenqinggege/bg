package com.fumei.bg.controller;

import com.fumei.bg.util.MD5Util;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 *
 * @author zkh
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@RestController
@RequestMapping("/api")
public class APIController {

    @PostMapping("/upload")
    public String uploadFile(MultipartFile file){

        return null;
    }
}
