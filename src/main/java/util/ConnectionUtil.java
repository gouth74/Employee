package util;
		 
import java.sql.Connection;
import java.sql.SQLException;
		 
import javax.sql.DataSource;
		 
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
		 
		public class ConnectionUtil {
		 
		    public static DataSource getDataSource() {
		 
		        BasicDataSource ds = new BasicDataSource();
		        ds.setDriverClassName("com.mysql.jdbc.Driver");
		        ds.setUrl("jdbc:mysql://localhost:3306/training_db");
		        ds.setUsername("root");
		        ds.setPassword("root");     
		        return ds;
		    }
		     
		    public static JdbcTemplate getJdbcTemplate(){
		        JdbcTemplate jdbcTemplate = new JdbcTemplate();
		        DataSource dataSource = getDataSource();
		        jdbcTemplate.setDataSource(dataSource);
		        return jdbcTemplate;
		    }
		 
		    public static Connection getConnection() throws Exception {
		 
		        Connection con = null;
		 
		        try {
		            DataSource dataSource = getDataSource();
		            con = dataSource.getConnection();
		        } catch (SQLException e) {
		            throw new Exception("Unable to connect");
		        }
		 
		        return con;
		 
		    }
	}
