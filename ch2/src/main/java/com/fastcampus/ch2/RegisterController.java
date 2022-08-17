package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add") // �ű�ȸ�� ���� ȭ��
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User	user,Model m) throws Exception {
		//1. ��ȿ�� �˻�
		if (!isVaild(user)) {
			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add";
//			return "redirect:/register/add?msg="+msg;  // URL���ۼ�(rewriting)
			// redirect(�����̷�Ʈ) = ���û�� �ǹ�
		}
		//2. �ű�ȸ�� ���� ����
		return "registerInfo"; // WEB-INF/views/registerInfo.jsp
	}

private boolean isVaild(User user) {
	// TODO Auto-generated method stub
	return false;
}
}
