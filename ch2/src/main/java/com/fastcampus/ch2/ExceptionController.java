package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

@Controller
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) {
        System.out.println("m = " +m);
//        m.addAttribute("ex",ex);
        return "error";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   // 에러코드 200 => 500 변경
    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception ex, Model m) {
        m.addAttribute("ex",ex);
        return "error";
    }

    @RequestMapping("ex")
    public String main(Model m) throws Exception{
        m.addAttribute("msg", "message from ExceptionController.main()");
        throw new Exception("예외가 발생했습니다.");
    }


    @RequestMapping("ex2")
    public String main2() throws Exception{
        throw new FileNotFoundException("예외가 발생했습니다.");
    }

}
