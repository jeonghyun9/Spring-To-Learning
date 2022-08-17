package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;
import java.io.IOException;
// 전역 예외처리 클래스

//@ResponseStatus
//
//1. 예외처리 메서드 앞에 붙인다.
// 1-1. 응답코드를 바꿀 수 있다.
//
//
//2. 예외처리 클래스 앞에 쓴다.
// 2-1. 사용자정의 예외클래스 -> 원하는 오류 상태코드로 변경
@ControllerAdvice("com.fastcampus.ch3") // => 지정된 패키지에서 발생하는 예외 처리
//@ControllerAdvice // => 모든 패키지 처리
public class GlobalCatcher {

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) {
        m.addAttribute("ex",ex);
        return "error";
    }

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception ex, Model m) {
        m.addAttribute("ex",ex);
        return "error";
    }

    @ExceptionHandler(IOException.class)
    public String catcher3() throws Exception {
        throw new IOException();
    }
}
