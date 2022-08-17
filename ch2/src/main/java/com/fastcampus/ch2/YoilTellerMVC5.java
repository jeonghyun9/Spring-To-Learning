package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC5 {
    @ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		System.out.println("ex="+ex);
		
		return "yoilError";
	}
    
    @RequestMapping("/getYoilMVC5") 
    // http://localhost/ch2/getYoilMVC5?year=2021&month=10&day=1
//  public String main(@ModelAttribute("myDate") MyDate date, Model m) { // 아래와 동일 
    public String main(@ModelAttribute MyDate date, Model m) { 
    	// @ModelAttribute사용, 반환 타입은 String  
    	// @ModelAttribute사용시 ("key")값을 따로 설정하지 않으면 
    	// 객체의 첫번째 문자를 소문자로 한 키값 자동 생성
    	// ex)@ModelAttribute (ComeOn come => comOn come)
    	// ex)@ModelAttribute (MyDate date => myDate date)
    	// 근데 생략 가능 ㅋ
    	
    	// @RequestParam() :  반환타입이 기본형,String 일때 생략되어있다고 보면됨. 이땐 굳이 안해도 됨.
    	// @ModelAttribute() : 반환타입이 참조형 일때 생략되었다고 보면됨. 이때도 굳이 안써도 됨.
    	
    	System.out.println("myDate="+date);

    	// 1. 유효성 검사 
    	if(!isValid(date))
    		return "yoilError";
    	
        // 2. 처리
    	char yoil = getYoil(date);

    	// 3. Model에 작업한 결과를 저장 
        // @ModelAttribute 덕분에 MyDate를 저장안해도 됨. View로 자동 전달됨.
//      m.addAttribute("myDate", date);     	
//    	m.addAttribute("yoil", yoil);        
        
      	// 4. 작업 결과를 보여줄 뷰의 이름을 반환  
      	return "yoil";
    }
    
    private @ModelAttribute("yoil") char getYoil(MyDate date) {
    	// 반환 타입 앞에도 ModelAttribute 사용 가능. String처리
    	// 이때 반환타입의 호출 결과를 맵에 저장
    	// ex) Key = yoil , Value = 반환결과
    	return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }

    private boolean isValid(MyDate date) {
    	return isValid(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}