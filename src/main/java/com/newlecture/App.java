package com.newlecture;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.newlecture.ui.ExamConsole;
import com.newlecture.ui.FlowExamConsole;
import com.newlecture.ui.GridExamConsole;

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
    	
    	//GridExamConsole console = new GridExamConsole();
        //FlowExamConsole console = new FlowExamConsole();
        
    	Properties properties = new Properties();
    	FileInputStream fis = new FileInputStream("app.properties");//상대경로지정../../../(root에있어서 그냥씀.)
    	properties.load(fis);//읽는거
    	ExamConsole console = (ExamConsole) Class
    							.forName(properties.getProperty("console"))
    							.newInstance();
          	
        console.input();
        console.print();
        fis.close();
    }
}
