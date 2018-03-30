package com.newlecture.controller.member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.entity.Note;
import com.newlecture.service.member.NoteService;



@Controller("MemberNoteController")//같은이름의충돌을 막기위해.
@RequestMapping("/member/note/")
public class NoteController {

	@Autowired //지금 패키지명이 달라서 dispatcher가서 하나더 만들어야함.
	private NoteService service;//동명이라도 *따로* 만들어놔야함!!(이건 집중화가 안필요)
					//create로 
	
	
	@RequestMapping("list")
	public String list() {
		
		
		return "member.note.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		
		return "member.note.detail";
	}
	
	@RequestMapping("edit")
	public String edit() {
	
		return "member.note.edit";
	}
	
	@RequestMapping(value="reg",method=RequestMethod.GET)
	public String reg() {
		
		return "member.note.reg";//forward
	}
	
	@RequestMapping(value="reg", method=RequestMethod.POST)
	public String reg(Note note,MultipartFile file, HttpServletRequest request) {//알아서 객체를 생성해주고 setter에 담아준다(String title,String content)
		
		
		String memberId ="newlec";
		
		ServletContext ctx = request.getServletContext();//요청 url획득
	    String path = ctx.getRealPath("/resources/note/"+memberId);//비공개영역으로안하기위해 리소스에다가넣기,메타데이터에있는 곳에 들어감.여기이클립스에 경로엔 안보임.
	    File f = new File(path);
	    if(!f.exists())
	    	f.mkdir();
	    	
	    
							
		
		if(!file.isEmpty()){//파일이 전송되었냐 안되었냐 (조건문에서 씀)
		try {
			String fname = file.getOriginalFilename();
			InputStream fis = file.getInputStream();//파일이 전송안되면 오류가됨.
			FileOutputStream fos = new FileOutputStream(path+File.separator+fname);//물리경로path/구분자 File.separator

			int size = 0;
			byte[] buf = new byte[1024];
			
			while((size = fis.read(buf,0,1024))!=-1)
				fos.write(buf,0,size);
			
			fis.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		//int result = 
				service.insertNote(note);
		
		return "redirect:list";//redirect(=./list현재디렉토리에 리스트)
	}
	@RequestMapping("data")
	@ResponseBody//뷰로리턴하는게 아니라 리턴값으로 *출력*
	public String data() {
		
		return "안녕하세욤";
	}
	
	
}
