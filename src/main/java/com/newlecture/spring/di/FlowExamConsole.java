package com.newlecture.spring.di;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



public class FlowExamConsole implements ExamConsole{
   
	@Autowired//꺼내오기 위해서 씀 , 부품으로 되어있어야 autowired를 할 수 있음.이거때문에 app-context에 있는거 주석처리해도 널포인트나오지않아야.근데 왜 널포인트오류가나오냐. 설정을 따로해야함.
	//함수내에서는 autowired할 수 없음
	//@Qualifier("exam1")
   private Exam exam;//이름이아니라 자료형으로 찾아서 가져옴
   
   public FlowExamConsole() {
     // exam = new Exam();
   }
   
   public FlowExamConsole(Exam exam) {//app-context.xml에서 <constructor-arg ref="exam"/>
	
	this.exam = exam;
}

   public void setExam(Exam exam) {//app-context.xml에서 <property name="exam"  ref="exam"/>
	   this.exam = exam;
	
}
   
public void input() {
      Scanner scan = new Scanner(System.in);
      int kor;
      int eng;
      int math;
      
      System.out.println("┌──────────────────────────────────────────┐");
      System.out.println("│                  Exam Input              │");
      System.out.println("└──────────────────────────────────────────┘");
      
      System.out.print("kor : ");
      kor = scan.nextInt();
      System.out.print("eng : ");
      eng = scan.nextInt();
      System.out.print("math : ");
      math = scan.nextInt();
      
      exam.setKor(kor);
      exam.setEng(eng);
      exam.setMath(math);
   }
   
   public void print() {
      int kor = exam.getKor();
      int eng = exam.getEng();
      int math = exam.getMath();
      int total = exam.total();
      float avg = exam.avg();
      
      System.out.println("┌──────────────────────────────────────────┐");
      System.out.println("│                Exam Print                │");
      System.out.println("└──────────────────────────────────────────┘");
      
      System.out.printf("kor : %3d\n", kor);      
      System.out.printf("eng : %3d\n", eng);
      System.out.printf("math : %3d\n", math);
      System.out.printf("total : %3d\n", total);
      System.out.printf("avg : %+6.2f\n", avg);      
   }

  

   
}
