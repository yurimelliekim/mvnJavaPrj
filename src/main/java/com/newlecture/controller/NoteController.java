package com.newlecture.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.entity.Note;
import com.newlecture.service.NoteService;

@Controller
@RequestMapping("/note/")
public class NoteController {
	
	
	@Autowired
	private NoteService service;//= new NoteService();dispatcher에서 설정으로 객체생성
	
	@RequestMapping("list")//동적,여기에 /note/list로 반복되므로 /note/부분을 위로 빼줌
	public String list(@RequestParam(value="p",defaultValue="1") Integer page//인티저는 정수, null 둘다 받음 (nullable)
						,Model model) {//모델객체생성(스프링이알아서해줌)
		
		//System.out.println(page);//알기 편하기 위해서 이함수안에서 page라고 씀.parameter로는 ?p=1이런식으로 표기
		
		
		List<Note> notes = service.getNoteList(page);
		model.addAttribute("notes", notes);//모델에 정보들을 담아주기
		
		
		return "note/list";//뷰정보
	}
	/*
	http://www.notepubs.com/note/detail?id=3 param을 id를 읽다
	http://www.notepubs.com/note/3	param을 id를 못 읽는다.
	*/
	
	@RequestMapping("{id}")//동적인거 제외하고 이리로감,1,2,3,4,...페이지
	public String detail(@PathVariable("id")Integer id
						,Model model) {//경로로 오는 매개변수, 파라미터가 아니라고 알려주는거
		
		Note note = service.getNote(id);
		model.addAttribute("note", note);
		return "note/detail";
	}
}