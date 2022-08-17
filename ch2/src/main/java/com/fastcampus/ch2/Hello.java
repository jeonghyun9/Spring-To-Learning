package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // 1. 원격 호출이 가능한 프로그램으로 등록
public class Hello {
	
	int iv =10;
	
	static int cv = 20;
	
	@RequestMapping("/hello")  // 2. URL과 메서드를 연결
	
	private void main() {   // 인스턴스 메서드 - iv, cv를 둘 다 사용 가능
		// 3. 톰캣 내부에서 메서드를 자동생성 해줌
		//    따라서 static을 안써도 됨.  (자바의 정석: 인스턴스 메서드) 검색
		System.out.println("Hello - static ");
		System.out.println(cv); // OK
		System.out.println(iv); // OK

		System.out.println("Hello");
	}
	
	
	public static void main2() {  // static 메서드 - cv만 사용 가능
		
		System.out.println(cv); // OK
//		System.out.println(iv); // ERROR
	}

}
