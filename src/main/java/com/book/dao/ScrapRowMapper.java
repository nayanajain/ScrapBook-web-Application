package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.model.Scrap;

public class ScrapRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Scrap s=new Scrap();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setRel(rs.getString("rel"));
		s.setContactno(rs.getString("contactno"));
		s.setZodiacsign(rs.getString("zodiacsign"));
		s.setLyrics(rs.getString("lyrics"));
		return s;
	}

}
