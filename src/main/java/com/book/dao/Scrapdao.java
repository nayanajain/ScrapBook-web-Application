package com.book.dao;

import java.util.List;

import com.book.model.Scrap;
//import com.contactapp.model.Contact;

public interface Scrapdao {
	
public int save(Scrap s);
	
	public int update(Scrap s);
	
	public Scrap get(Integer id);
	

	public int delete(Integer id);
	
	public List<Scrap> list(); 

}
