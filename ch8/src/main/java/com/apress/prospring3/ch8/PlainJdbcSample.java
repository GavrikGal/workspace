package com.apress.prospring3.ch8;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.apress.prospring3.ch8.dao.ContactDao;
import com.apress.prospring3.ch8.dao.plain.PlainContactDao;
import com.apress.prospring3.ch8.domain.Contact;

public class PlainJdbcSample {

	private static ContactDao contactDao = new PlainContactDao();

	public static void main(String[] args) {

		System.out.println("Listing initial contact data:");
		listAllContacts();
		System.out.println();

		System.out.println("Insert a new contact");
		Contact contact = new Contact();
		contact.setFirstName("Jackky");
		contact.setLastName("Chan");
		contact.setBirthDate(new Date((new GregorianCalendar(2001, 10, 1))
				.getTime().getTime()));
		contactDao.insert(contact);
		System.out.println("Listing contact data after new contact created:");
		listAllContacts();
		
		System.out.println();
		System.out.println("Deleting the previous created contact");
		contactDao.delete(contact.getId());
		System.out.println("Listing contact data after new contact deleted:");
		listAllContacts();

	}

	private static void listAllContacts() {
		List<Contact> contacts = contactDao.findAll();

		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

}
