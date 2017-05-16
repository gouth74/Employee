	package dao;
	 
	import java.util.List;

import model.Employee;
	 
	public class TestEmployeeDAO {
	 
	    public static void main(String[] args) {
	 
	    	
	    	testInsert();
	        testUpdate();
	        testDelete(); 
	        testFindAll();
	        testFindByEmployee();
	    }
	
	    private static void testFindAll() {
	        List<Employee> list = EmployeeDAO.findAll();
	        for (Employee e : list) {
	        	System.out.println("Employee" + e.id +"-"+ e.name);
	        }
	    }
  
        
	    private static void testFindByEmployee() {
	    	String name = "Goutham";
	        Employee e = EmployeeDAO.findByName(name);
		    System.out.println("Employee" + e.id +"-"+ e.name);
		}

		private static void testInsert() {
	        String name = "Naresh";
	        EmployeeDAO.insert(name);
	    }
	 
	    private static void testUpdate() {
		        String name = "Dr. Anbarasu";
				int id = 5;
				EmployeeDAO.update(id, name);
		    }
	    private static void testDelete() {
		        int id = 9;
				EmployeeDAO.delete(id);
		    }
	}