package com.newlecture.spring.di;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Component//("exam1")//구성, 콩자루에 담아주세요.콩자루 생성 이것만있으면 xml에 빈이없어서 따로
				//<context:component-scan base-package="com.newlecture.spring.di"/>설정해야함
//@Controller //이걸로해도됨.객체를 생성해달라고 하는 annotation
//@Repository//이걸로해도됨.객체를 생성해달라고 하는 annotation
public class Exam {
private int kor;
private int eng;
private int math;

public int total() {
return kor + eng + math;
}

public float avg() {

return total()/3.0f;
}

public Exam() {

}

public Exam(int kor, int eng, int math) {
super();
this.kor = kor;
this.eng = eng;
this.math = math;
}

public int getKor() {
return kor;
}

public void setKor(int kor) {
this.kor = kor;
}

public int getEng() {
return eng;
}

public void setEng(int eng) {
this.eng = eng;
}

public int getMath() {
return math;
}

public void setMath(int math) {
this.math = math;
}


}