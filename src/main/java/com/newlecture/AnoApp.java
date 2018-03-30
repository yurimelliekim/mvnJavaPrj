package com.newlecture;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AnoApp {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		Scanner scan = new Scanner(System.in);
		System.out.print("호출하고 싶은 함수의 이름은: ");
		String testName = scan.nextLine();
		
		//RTTI(RunTime Type Information) -> meta data -> RunTime Type Information
		//어노테이션이 되어있는 메서드찾기
		AnoTestClass cls = new AnoTestClass();
		
		//Class<?> clsInfo = cls.getClass();
		
		Haha haha = cls.getClass().getAnnotation(Haha.class);
		
		if(haha !=null) {
			Method[] methods = cls.getClass().getDeclaredMethods();//이걸 변수선언해서 적으면 주석처리한 두줄.
			//Method[] methods = clsInfo.getDeclaredMethods();
			for(Method m : methods) {
				Test test = m.getAnnotation(Test.class);
				if(test != null) {
					//name 속성을 확인해서 testName과 일치한다면
					if(test.name().equals(testName))
						m.invoke(cls,null);//void라서 null
						//System.out.println(m.getName()+"()");
					
				}
			}
		
		}
		//annotation얻기
		//객체라서 getClass() 개체는 .class
		//RTTI객체(RTTI:// 런타임 시 객체의 자료형에 관한 정보를 드러내는 메커니즘
		/*Test test = cls.getClass().getAnnotation(Test.class);
		System.out.println(test);
		Haha haha = cls.getClass().getAnnotation(Haha.class);
		System.out.println(haha);
		
		
		Annotation[] anos = cls.getClass().getAnnotations();

		
		//anos.length;
		
		System.out.println(anos.length);
		 
		
		for(int i=0;i<anos.length;i++) {
			System.out.println(anos[i].annotationType().getName());
			System.out.println(anos[i].annotationType().getSimpleName());
			
		}*/

	}

}
