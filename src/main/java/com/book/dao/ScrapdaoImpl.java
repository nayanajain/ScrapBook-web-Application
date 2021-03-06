package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.book.model.Scrap;
@Component
public class ScrapdaoImpl implements Scrapdao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ScrapdaoImpl(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
		// TODO Auto-generated constructor stub
	}
	
	public int save(Scrap s) {
		String sql="insert into scrap(name,rel, date, zodiacsign, contactno, lyrics) values(?,?,?,?,?,?)";
		Object[] sqlparams=	{s.getName(),s.getRel(), s.getDate(), s.getContactno(), s.getZodiacsign(), s.getLyrics()};
		return jdbcTemplate.update(sql,sqlparams );
	}

	public int update(Scrap s) {
		String sql="update scrap set name=?, rel=?,date=?,zodiacsign=?,contactno=?,lyrics=? where id=?";
		return jdbcTemplate.update(sql, s.getName(),s.getRel(), s.getDate(), s.getZodiacsign(),s.getContactno(),s.getLyrics() ,s.getId());
	}

/*	public Scrap get(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from scrap where id="+id;
		   ResultSetExtractor<Scrap> rs=new ResultSetExtractor<Scrap>() {

			public Scrap extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next())
				{
					String name=rs.getString("name");
					String rel=rs.getString("rel");
					String dates=rs.getString("date");
					String zs=rs.getString("zodiacsign");
					String cn=rs.getString("contactno");
					String lyrics=rs.getString("lyrics");
					
					
					return new Scrap(name,rel,dates, zs, cn, lyrics);
				}
				return null;
			}
			
		   };
			
			return jdbcTemplate.query(sql, rs);
	}  */
			
			
			public Scrap get(Integer id)
			{
				String sql="select * from scrap where id=?";
				Scrap scrap=jdbcTemplate.queryForObject(sql, new ScrapRowMapper(),id);
				return scrap;
				
			}  
		
		

	public int delete(Integer id) {
		// TODO Auto-generated method stub
		String sql="Delete from scrap where id="+id;
		return jdbcTemplate.update(sql);
	}

	public List<Scrap> list() {
		// TODO Auto-generated method stub
		String sql="Select * from scrap";
		RowMapper<Scrap> rowMapper= new RowMapper<Scrap>() {

			public Scrap mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Integer id=rs.getInt("id");
				String name=rs.getString("name");
				String rel=rs.getString("rel");
				String dates=rs.getString("date");
				String zs=rs.getString("zodiacsign");
				String cn=rs.getString("contactno");
				String lyrics=rs.getString("lyrics");
				
				
				return new Scrap(id,name,rel,dates, zs, cn, lyrics);
			
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
			}


}
