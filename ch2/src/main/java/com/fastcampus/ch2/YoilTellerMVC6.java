package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC6 {
	
    @ExceptionHandler(Exception.class)
	public String catcher(Exception ex, BindingResult result) {
		System.out.println("ex="+ex);
		System.out.println("1111111111111  //result = "+result);
		FieldError error = result.getFieldError();
		System.out.println("CODE =======" + error.getCode());
		System.out.println("FIELD =======" + error.getField());
		System.out.println("MASSAGE =======" + error.getDefaultMessage());
		return "yoilError";
	}
    
    @RequestMapping("/getYoilMVC6") 
    // http://localhost/ch2/getYoilMVC6?year=2021&month=10&day=1
//  public String main(@ModelAttribute("myDate") MyDate date, Model m) { // 아래와 동일 
    public String main(MyDate date, BindingResult result) { 
    	
//    	BindingResult : 바인딩 할 객체 바로 뒤에 위치해 있어야함.
//    	역할 : 1.타입변환(TypeCasting),  2.데이터 검증(Validation)
//    	URL에 쓰인 쿼리스트링의 key와 value를 객체의 변수 넣기 위해 타입변환을 시켜 넣어줌.
//    	해서 그 결과와 에러들을 변수에 저장.
//    	이것을 다시 컨트롤러로 넘겨줄 수 있고 이걸로 작업처리가 가능함.
    	
    	System.out.println("22222222222222 //result = "+result);
//    	System.out.println("myDate = "+date);

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