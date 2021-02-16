package com.book.model;

public class Scrap {
	
	private int id;
	private String name;
	private String rel;
	private String date;
	private String zodiacsign;
	private String contactno;
	private String lyrics;
	
	
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRel() {
		return rel;
	}


	public void setRel(String rel) {
		this.rel = rel;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getZodiacsign() {
		return zodiacsign;
	}


	public void setZodiacsign(String zodiacsign) {
		this.zodiacsign = zodiacsign;
	}


	public String getContactno() {
		return contactno;
	}


	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public String getLyrics() {
		return lyrics;
	}


	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}


	public Scrap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Scrap [id=" + id + ", name=" + name + ", rel=" + rel + ", date=" + date + ", zodiacsign=" + zodiacsign
				+ ", contactno=" + contactno + ", lyrics=" + lyrics + "]";
	}
	public Scrap(int id, String name, String rel, String date, String zodiacsign, String contactno, String lyrics) {
		super();
		this.id = id;
		this.name = name;
		this.rel = rel;
		this.date = date;
		this.zodiacsign = zodiacsign;
		this.contactno = contactno;
		this.lyrics = lyrics;
	}
	
	
	public Scrap( String name, String rel, String date, String zodiacsign, String contactno, String lyrics) {
		super();
		this.name = name;
		this.rel = rel;
		this.date = date;
		this.zodiacsign = zodiacsign;
		this.contactno = contactno;
		this.lyrics = lyrics;
	}
	
	

}
