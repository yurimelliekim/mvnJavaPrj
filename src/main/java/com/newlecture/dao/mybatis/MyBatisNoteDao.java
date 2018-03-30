package com.newlecture.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.dao.NoteDao;
import com.newlecture.entity.Note;

public class MyBatisNoteDao implements NoteDao {

	@Autowired
	private SqlSession sqlSession;//이름을 아무거나해도?된다?고함
	
	@Override
	public List<Note> getList(Integer page) {
		
		NoteDao noteDao = sqlSession.getMapper(NoteDao.class);
		List<Note> result = noteDao.getList(page);
		
		return result;
	}

	@Override
	public Note get(Integer id) {
		
		NoteDao noteDao = sqlSession.getMapper(NoteDao.class);
		Note result = noteDao.get(id);
		
		return result;
	}

	@Override
	public int insert(Note note) {//노트다오매퍼가서하기.
		NoteDao noteDao = sqlSession.getMapper(NoteDao.class);
		int result = noteDao.insert(note);
		
		return result;
		
	}

}
