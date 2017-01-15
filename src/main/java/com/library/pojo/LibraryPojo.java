package com.library.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class LibraryPojo {
	@Id
	@Column(name = "bookId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	@Column(name = "bookname", nullable = false)
	private String bookname;
	@Column(name = "bookAuthor", nullable = false)
	private String bookAuthor;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

}
