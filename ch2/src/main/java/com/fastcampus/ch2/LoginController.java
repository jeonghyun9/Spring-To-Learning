package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping("/login")
    public String loginForm(){

        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. ���� ����
        session.invalidate();
        // 2. Ȩ���� �̵�
        return "redirect:/";
    }


    @PostMapping("/login")
    public String login(@CookieValue("id") String cookieId, String id, String pwd, boolean rememberId, String toURL,
                        HttpServletResponse response, HttpServletRequest request)
            throws Exception {
//        System.out.println("id = "+id);
//        System.out.println("pwd = "+pwd);
//        System.out.println("rememberId = "+rememberId);
        // 1. id�� pwd�� Ȯ��
        if (!loginCheck(id, pwd)){
        // 2-1. id�� pwd�� ��ġ�ϸ�, Ȩ���� �̵�
            String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
            return "redirect:/login/login?msg"+msg;
        }
        // 2-2. id�� pwd�� ��ġ�ϸ�,
        // ���� ��ü�� ������
        HttpSession session = request.getSession();
        // ���� ��ü�� id�� ����
        session.setAttribute("id", id);

        if (rememberId) {
            // ��Ű�� ����
            //  1. ��Ű�� ����
            Cookie cookie = new Cookie("id", id);
            //  2. ���信 ����
            response.addCookie(cookie);
        } else {
            // ��Ű�� ����
            //  1. ��Ű�� ����
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0); // ��Ű ����
            //  2. ���信 ����
            response.addCookie(cookie);

        }
//        //  1. ��Ű�� ����
//        Cookie cookie = new Cookie("id", id);
//        //  2. ���信 ����
//        response.addCookie(cookie);
//        //  3. Ȩ���� �̵�

        toURL = toURL == null || toURL.equals("") ? "/" : toURL;


        return "redirect:"+toURL;
    }

    private boolean loginCheck(String id, String pwd) {

        return "asdf".equals(id) && "1234".equals(pwd);
    }

}
