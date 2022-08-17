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
//  public String main(@ModelAttribute("myDate") MyDate date, Model m) { // �Ʒ��� ���� 
    public String main(MyDate date, BindingResult result) { 
    	
//    	BindingResult : ���ε� �� ��ü �ٷ� �ڿ� ��ġ�� �־����.
//    	���� : 1.Ÿ�Ժ�ȯ(TypeCasting),  2.������ ����(Validation)
//    	URL�� ���� ������Ʈ���� key�� value�� ��ü�� ���� �ֱ� ���� Ÿ�Ժ�ȯ�� ���� �־���.
//    	�ؼ� �� ����� �������� ������ ����.
//    	�̰��� �ٽ� ��Ʈ�ѷ��� �Ѱ��� �� �ְ� �̰ɷ� �۾�ó���� ������.
    	
    	System.out.println("22222222222222 //result = "+result);
//    	System.out.println("myDate = "+date);

    	// 1. ��ȿ�� �˻� 
    	if(!isValid(date))
    		return "yoilError";
    	
        // 2. ó��
    	char yoil = getYoil(date);

    	// 3. Model�� �۾��� ����� ���� 
        // @ModelAttribute ���п� MyDate�� ������ص� ��. View�� �ڵ� ���޵�.
//      m.addAttribute("myDate", date);     	
//    	m.addAttribute("yoil", yoil);        
        
      	// 4. �۾� ����� ������ ���� �̸��� ��ȯ  
      	return "yoil";
    }
    
    private @ModelAttribute("yoil") char getYoil(MyDate date) {
    	// ��ȯ Ÿ�� �տ��� ModelAttribute ��� ����. Stringó��
    	// �̶� ��ȯŸ���� ȣ�� ����� �ʿ� ����
    	// ex) Key = yoil , Value = ��ȯ���
    	return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
    }

    private boolean isValid(MyDate date) {
    	return isValid(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // ������ üũ 
    }
}