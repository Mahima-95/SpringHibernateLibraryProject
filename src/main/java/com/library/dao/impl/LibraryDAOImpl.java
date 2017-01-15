package com.library.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.library.dao.LibraryDAO;
import com.library.pojo.LibraryPojo;

@Repository
public class LibraryDAOImpl implements LibraryDAO {

	private Session session;
	private Transaction transaction;

	public LibraryDAOImpl() {
		super();
	}

	@Autowired
	public SessionFactory sessionFactory;

	public String addBooks(LibraryPojo libraryPojo) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		System.out.println(transaction);
		session.save(libraryPojo);
		transaction.commit();
		session.close();
		return "successfully inserted...!!!!";
	}

	private Session getSession() {
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		return session;

	}

	public String updateBooks(LibraryPojo libraryPojo) {
		String response = null;
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		if (libraryPojo.getBookId() > 0) {
			LibraryPojo pojo = session.get(LibraryPojo.class, libraryPojo.getBookId());

			if (!StringUtils.isEmpty(pojo)) {
				if (!StringUtils.isEmpty(libraryPojo.getBookname())) {
					pojo.setBookname(libraryPojo.getBookname());
				}
				if (!StringUtils.isEmpty(libraryPojo.getBookAuthor())) {
					pojo.setBookAuthor(libraryPojo.getBookAuthor());
				}
				try {
					session.update(pojo);
					transaction.commit();
					response = "Successfully updated...!!!!";

				} catch (Exception exception) {
					response = "Exception occurs";
					exception.printStackTrace();
				} finally {
					session.close();
				}
			}
		} else {
			response = "No data exist for given ID";
		}
		return response;

	}

	public List<LibraryPojo> getBooks(LibraryPojo libraryPojo) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		return (List<LibraryPojo>) session.createCriteria(LibraryPojo.class).list();
	}

	public String deleteBooks(int bookId) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		LibraryPojo libraryPojo= (LibraryPojo)session.get(LibraryPojo.class, bookId);
		System.out.println(libraryPojo);
		session.delete(libraryPojo);
		transaction.commit();
		session.close();
		System.out.println("Successfully Deleted ID..!!!!");
		return "Successfully deleted ID...!!!!!";
	}

}
