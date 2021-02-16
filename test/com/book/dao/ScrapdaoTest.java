package com.book.dao;



//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;



import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.book.model.Scrap;

class ScrapdaoTest {
	
	private DriverManagerDataSource dataSource;
	private Scrapdao scrapdao;

	@BeforeEach
	public void setBefore()
	{
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3300/scrapbook"); 
		dataSource.setPassword("aptech");
		dataSource.setUsername("root");
		
		scrapdao=new ScrapdaoImpl(dataSource);
		
	}


	@Test
	void testSave() {
		Scrap s= new Scrap("nancy","me", "24-12-2000","scorpion","8765","chanda chamke");
		int res=scrapdao.save(s);
		
		assertTrue(res>0);
		
		//fail("Not yet implemented");
	}

    @Test
	public void testUpdate() {
		
		Scrap s= new Scrap(5,"updateddd","me only","24-89-9878", "abc", "77778888","all izz well");
		int res=scrapdao.update(s);
		assertTrue(res>0);
		
		//fail("Not yet implemented");
	}

	@Test
    public void testGet() {
		Integer id=4;
		Scrap s= scrapdao.get(id);
		if(s!=null)
		{
			System.out.println(s);
		}
		assertNotNull(s);
		//fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		int id=3;
		
		int res=scrapdao.delete(id);
		assertTrue(res>0);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testList() {
		List<Scrap> lists= scrapdao.list();
		for(Scrap s: lists)
		{
			System.out.println(s);
		}
		
		assertTrue(!lists.isEmpty());
		
		//fail("Not yet implemented");
	}


}
