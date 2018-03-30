package com.newlecture.service.member;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.dao.NoteDao;
import com.newlecture.entity.Note;

public class NoteService {
	
	@Autowired
	private NoteDao noteDao;

	public int insertNote(Note note) {//결과값을 두는게 좋음 void말고.!
									//insert, update,,,,,,,,
		
		noteDao.insert(note);
		
		return 0;
	}

}
