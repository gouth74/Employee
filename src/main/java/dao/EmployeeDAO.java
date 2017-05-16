package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Employee;
import util.ConnectionUtil;

	public class EmployeeDAO {
		 
	    private static JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	 
	    public static void insert(String name) {
	        String sql = "insert into employee ( name ) values ( ? ) ";
	        int rows = jdbcTemplate.update(sql, name);
	        System.out.println("Insert:" + sql + ", no of rows inserted: " + rows);
	    }

	    public static void update(int id, String name) {
	        String sql = "update employee set name=? where id = ?";
	        int rows = jdbcTemplate.update(sql, name, id);
	        System.out.println("Update:" + sql + ", no of rows update:" + rows);
	    }
	    
	    public static void delete(int id) {
	        String sql = "delete from employee where id = ? ";
	        int rows = jdbcTemplate.update(sql, id);
	        System.out.println("Delete :" + sql + ", no of rows delete:" + rows);
	    }
	 
	    public static List<Employee> findAll() {
	        String sql = "select id, NAME from employee";
	        System.out.println("FindAll:" + sql);
	 
			List<Employee> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
	            Employee emp = new Employee();
	            emp.id = rs.getInt("id");
	            emp.name = rs.getString("name");
	            return emp;
	        });
	        return list;
	    }
	    
  
	    public static Employee findByName(String name) {
	        String sql = "select id, NAME from employee where NAME= ?";
	        System.out.println("FindByName:" + sql);
	 
	        Employee emp = jdbcTemplate.queryForObject(sql, new Object[]{name},(rs, rowNum) -> {
	            Employee en = new Employee();
	            en.id = rs.getInt("id");
	            en.name = rs.getString("NAME");
	            return en;
	        });
	        return emp;
	    }
	    
	}