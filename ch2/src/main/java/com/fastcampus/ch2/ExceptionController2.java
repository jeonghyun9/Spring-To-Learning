package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;
import java.io.IOException;


@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 => 400
class MyException extends RuntimeException {
    MyException(String msg){
        super(msg);
    }
    MyException(){
        this("");
    }



}

@Controller
public class ExceptionController2 {



//    @ExceptionHandler(Exception.class)
//    public String catcher(Exception ex, Model m) {
//        m.addAttribute("ex",ex);
//        return "error";
//    }
//
//    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
//    public String catcher2(Exception ex, Model m) {
//        m.addAttribute("ex",ex);
//        return "error";
//    }

    @RequestMapping("ex3")
    public String main() throws Exception{
        throw new MyException("예외가 발생했습니다.");
    }


    @RequestMapping("ex4")
    public String main2() throws Exception{
        throw new FileNotFoundException("예외가 발생했습니다.");
    }


    @RequestMapping("ex5")
    public String main3() throws Exception{
        throw new IOException("입출력 예외가 발생했습니다.");
    }

}
