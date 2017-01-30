package aula114.springmvc.service;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aula114.springmvc.domain.Contact;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<Contact> listIdEmployee() {
        String sql = "select * from Contact";
		List <Contact> contact = jdbcTemplate.query(sql, new EmployeeMapper()); 
        return contact;
	}
/*
	@Override
	public Contact show(String id) {

          //  Se obtiene desde MySQL

          return;
	}*/
}
