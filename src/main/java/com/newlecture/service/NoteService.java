package com.newlecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.dao.NoteDao;
import com.newlecture.dao.mybatis.MyBatisNoteDao;
import com.newlecture.entity.Note;

public class NoteService {

	@Autowired
	private NoteDao noteDao;//인터페이스,객체생성은 설정파일로. 느슨한 결합을 위해(dispatcher).
	
	public List<Note> getNoteList(Integer page) {
		
		//noteDao = new MyBatisNoteDao();//객체생성은 설정파일로. 느슨한 결합을 위해.이거를 디스패쳐에다가 빈으로 객체생성
		List<Note> list = noteDao.getList(page);//노트리스트를 가져오는게 아니라 리스트를 가져와야함.
		return list;
	}

	public Note getNote(Integer id) {
		
		noteDao.get(id);
		
		return null;
	}

	
}
