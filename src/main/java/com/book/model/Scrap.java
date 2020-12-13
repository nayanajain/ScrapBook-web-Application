package com.book.model;

public class Scrap {
	
	int id;
	String name;
	String date;
	String zodiacsign;
	String contactno;
	String lyrics;
	
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
	public Scrap(int id, String name, String date, String zodiacsign, String contactno, String lyrics) {
		
		this(name,date,zodiacsign,contactno,lyrics);
		this.id = id;
		
	}
	public Scrap(String name, String date, String zodiacsign, String contactno, String lyrics) {

		this.name = name;
		this.date = date;
		this.zodiacsign = zodiacsign;
		this.contactno = contactno;
		this.lyrics = lyrics;
	}
	@Override
	public String toString() {
		return "Scrap [id=" + id + ", name=" + name + ", date=" + date + ", zodiacsign=" + zodiacsign + ", contactno="
				+ contactno + ", lyrics=" + lyrics + "]";
	}
	
	
	

}
