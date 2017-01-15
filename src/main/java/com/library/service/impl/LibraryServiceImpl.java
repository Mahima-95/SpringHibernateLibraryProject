package com.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.LibraryDAO;
import com.library.pojo.LibraryPojo;
import com.library.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryDAO libraryDAO;

	public String addBooks(LibraryPojo libraryPojo) {
		return libraryDAO.addBooks(libraryPojo);
	}

	public String updateBooks(LibraryPojo libraryPojo) {
		return libraryDAO.updateBooks(libraryPojo);
	}

	public List<LibraryPojo> getBooks(LibraryPojo libraryPojo) {
		return libraryDAO.getBooks(libraryPojo);
	}

	public String deleteBooks(int bookId) {
		return libraryDAO.deleteBooks(bookId);
	}
}
