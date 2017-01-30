package aula114.springmvc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import aula114.springmvc.domain.Contact;

public class EmployeeMapper implements RowMapper<Contact> {
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact(); 
		contact.setName(rs.getString("name"));
		contact.setEmail(rs.getString("email"));
		contact.setAddress(rs.getString("address"));
		contact.setPhone(rs.getString("telephone"));
		return contact;
	}
}