package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // 1. ���� ȣ���� ������ ���α׷����� ���
public class Hello {
	
	int iv =10;
	
	static int cv = 20;
	
	@RequestMapping("/hello")  // 2. URL�� �޼��带 ����
	
	private void main() {   // �ν��Ͻ� �޼��� - iv, cv�� �� �� ��� ����
		// 3. ��Ĺ ���ο��� �޼��带 �ڵ����� ����
		//    ���� static�� �Ƚᵵ ��.  (�ڹ��� ����: �ν��Ͻ� �޼���) �˻�
		System.out.println("Hello - static ");
		System.out.println(cv); // OK
		System.out.println(iv); // OK

		System.out.println("Hello");
	}
	
	
	public static void main2() {  // static �޼��� - cv�� ��� ����
		
		System.out.println(cv); // OK
//		System.out.println(iv); // ERROR
	}

}
