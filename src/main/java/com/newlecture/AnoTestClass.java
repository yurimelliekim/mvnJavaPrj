package com.newlecture;

@Haha
public class AnoTestClass {

	@Test(name="hello")//name ="" value="" 이런 속성도 붙을 수 있음, 없어도됨 ""
	public void f1() {
		System.out.println("Hello f1");	
	}
	
	@Test(name="okay")
	public void f2() {
		System.out.println("okayyyy f2");
	}
	
	public void f3() {
		System.out.println("okayyyy f3");
	}
	
}
