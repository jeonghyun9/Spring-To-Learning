package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller { // http://localhost:8080/ch2/getYoil?year=2021&month=10&day=1
	
	
//	@RequestMapping("/getYoil") //  ����========================
//	public static void main(HttpServletRequest request, HttpServletResponse response)
//		throws Exception{
//	
//	String year = request.getParameter("year");
//	String month = request.getParameter("month");
//	String day = request.getParameter("day");
	
	
//	@RequestMapping("/getYoil") //  MVC ���ɻ� �и� 1=========================
//	public static void main(String year, String month, String day, HttpServletResponse response)
//		throws Exception{
//		
//		// 1. �Է�
//		int yyyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day);
	
		
	@RequestMapping("/getYoil") //  MVC ���ɻ� �и� 2  (�Է��� ����ο� �ۼ������μ� �ڵ��� �и�)==========
	public void main(int year, int month, int day, HttpServletResponse response)
		throws IOException{

		
		// 2. �۾�
		Calendar cal = Calendar.getInstance();
//		cal.set(yyyy, mm -1 , dd);
		cal.set(year, month -1 , day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������ ...
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		// 3. ���
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(year +"�� "+ month +"�� "+ day +"���� ");
		out.println(yoil + "�����Դϴ�.");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
