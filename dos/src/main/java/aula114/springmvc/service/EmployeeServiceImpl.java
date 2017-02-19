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

	@Autowired
    	private RedisTemplate<String, String> redisTemplate;
	
	private List<String> listId = new ArrayList<String>();

	@Override
	public List<String> listIdEmployee() {
        //  Se obtiene desde Redis
        	String KEY = "Contact"; //Tomado del proyecto springLoadDataRedis
	    	Set<Object> list = redisTemplate.opsForHash().keys(KEY);
	    
		List<String> listId1 = new ArrayList(list);

	    	listId = listId1;
        	return listId;
	}

	@Override
	public Contact show(String id) {
        //  Se obtiene desde MySQL
		Contact contact = new Contact();
		String sql = "select name, email, address, telephone from contact where contact_id = ?";
  		
		contact = (Contact) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Contact>(Contact.class));
        	return contact;
	}

	public int insert(Contact c){
		System.out.println(c.getName()+c.getEmail()+c.getAddress()+c.getTelephone());
		String SQL = "insert into contact (name, email, address, telephone) values (?, ?, ?, ?)";
		int fila=jdbcTemplate.update( SQL, new Object[]{c.getName(),c.getEmail(),c.getAddress(),c.getTelephone()});
		System.out.println(SQL);
		System.out.println(fila);

		return fila;
	}

	public int delete(String id){
		
		Contact c=show(id);	
	
		String sql="delete from contact where contact_id=?";
		int fila=jdbcTemplate.update(sql,id);

		return fila;
	}

	public int edit(Contact c,String id){
		
		c=new Contact();

		String SQL = "update contact set name = ?,email=?,address=?,telephone=? where id = ?";
		int fila=jdbcTemplate.update( SQL, new Object[]{c.getName(),c.getEmail(),c.getAddress(),c.getTelephone(), id} );

		return fila;
	}

}
