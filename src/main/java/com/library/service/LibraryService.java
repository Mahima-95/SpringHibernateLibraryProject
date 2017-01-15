package com.library.service;

import java.util.List;

import com.library.pojo.LibraryPojo;

public interface LibraryService {
	String addBooks(LibraryPojo libraryPojo);

	public String updateBooks(LibraryPojo libraryPojo);

	public List<LibraryPojo> getBooks(LibraryPojo libraryPojo);

	public String deleteBooks(int bookId);
}
