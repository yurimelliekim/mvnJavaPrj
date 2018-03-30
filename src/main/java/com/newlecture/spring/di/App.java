package com.newlecture.spring.di;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Hello world!
 *
 */
public class App 
{

	
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
    {
    	
    	//강한 결합을 느슨하기위해 객체를 바로 사용하는 것이 아니라 인터페이스를 사용
    	//	->객체로부터 분리되에 기능을 씀
    	
    	
    	//이걸 안하고 부품 생성과 조립을 Spring에게 주문생산을 위탁하겠다. app-context.xml에 명세함.
    	/*Exam exam = new Exam();
        FlowExamConsole console = new FlowExamConsole();
        console.setExam(exam);//조립*/
    	
    	
    	
    	//결합력을 낮추는 작업
     	/*ExamConsole console = (ExamConsole) Class
    							.forName(className)//생성할 개체를 선택하는 부분
        						.newInstance();//객체를 생성하는 부분
        						*/       
    	//app-context에서 (주문서 작성 파일)
    	
    	//ExamConsole console = 콩자루.getBean("결과물");
    	ApplicationContext 콩자루 = 
    			new ClassPathXmlApplicationContext("com/newlecture/spring/di/app-context.xml");
    	
    	
    	
    	
    	//함수내에서는 autowired할 수 없음
    	ExamConsole console = (ExamConsole)콩자루.getBean("console");
    	
    	
        console.input();
        console.print();
        
    }
}
