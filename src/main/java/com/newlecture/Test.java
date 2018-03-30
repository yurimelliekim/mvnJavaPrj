package com.newlecture;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)//annotaion을 엄한데에 설정하지않도록하는것. 메소드에만써라!!!!!!클래스에 쓰면에러남.
public @interface Test {
	String name() default "";//기본값""(null)
	
}
