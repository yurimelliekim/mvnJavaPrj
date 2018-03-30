package com.newlecture.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newlecture.entity.Note;

public interface NoteDao {
	
	@Select("select * from Note" + 
			"		limit ${(page-1)*15},15")//여기서 바로하면 NoteDaoMapper.xml에서 select문을 쓸필요가없음
	List<Note> getList(@Param("page")Integer page);
	
	Note get(Integer id);

	int insert(Note note);

}
