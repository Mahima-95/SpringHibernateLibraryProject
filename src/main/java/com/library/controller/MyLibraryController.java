package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.pojo.LibraryPojo;
import com.library.service.LibraryService;

@RestController
public class MyLibraryController {
	
	@Autowired
	private LibraryService libraryService;

	@RequestMapping(value = "/addBooks")
	public String addBooks() {
		LibraryPojo libraryPojo = new LibraryPojo();
		System.out.println(libraryPojo);
		libraryPojo.setBookId(2);
		libraryPojo.setBookname("2 states");
		libraryPojo.setBookAuthor("chetan bhagat");
		return libraryService.addBooks(libraryPojo);
	}
	
	@RequestMapping(value="/updateBooks")
	public String updateBooks(){
		LibraryPojo libraryPojo = new LibraryPojo();
		libraryPojo.setBookId(2);
		libraryPojo.setBookname("3 idiots");
		libraryPojo.setBookAuthor("Bhagat");
		return libraryService.updateBooks(libraryPojo);
	}
	
	@RequestMapping(value="/getBooks")
	 public List<LibraryPojo> getBooks(LibraryPojo libraryPojo){
		libraryPojo.getBookId();
		return libraryService.getBooks(libraryPojo);
	}
	@RequestMapping("/deleteBooks")
	public String deleteBooks() {
		return libraryService.deleteBooks(2);
	}
}
