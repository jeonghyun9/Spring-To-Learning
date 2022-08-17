package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;
import java.io.IOException;
// ���� ����ó�� Ŭ����

//@ResponseStatus
//
//1. ����ó�� �޼��� �տ� ���δ�.
// 1-1. �����ڵ带 �ٲ� �� �ִ�.
//
//
//2. ����ó�� Ŭ���� �տ� ����.
// 2-1. ��������� ����Ŭ���� -> ���ϴ� ���� �����ڵ�� ����
@ControllerAdvice("com.fastcampus.ch3") // => ������ ��Ű������ �߻��ϴ� ���� ó��
//@ControllerAdvice // => ��� ��Ű�� ó��
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
