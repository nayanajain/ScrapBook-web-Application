package com.book.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.Scrapdao;
import com.book.model.Scrap;

@Service
public class ScrapService {
	
	@Autowired
	private Scrapdao scrapdao;

	public List<Scrap> list() {
		// TODO Auto-generated method stub
		List<Scrap> list=scrapdao.list();
		return list;
	}

	public void save(Scrap scrap) {
		// TODO Auto-generated method stub
		scrapdao.save(scrap);
		
	}

	public void update(Scrap scrap) {
		// TODO Auto-generated method stub
		scrapdao.update(scrap);
		
	}

	public Scrap get(Integer id) {
		// TODO Auto-generated method stub
		Scrap s=scrapdao.get(id);
		return s;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		scrapdao.delete(id);
		
	}

}
