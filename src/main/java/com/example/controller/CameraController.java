package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 2016-06-21.
 */
@Controller
public class CameraController {
    /*
        app에서 바로 사진을 보이게 만듬
        따로 만들 필요없음.
     */
//    @RequestMapping(value = "/photo/save", method = RequestMethod.POST)
//    public void savePhoto(HttpServletRequest request, @RequestParam("photo") MultipartFile photo){
//        //받은 사진을 저장한다. 어디로?
//    }
}
