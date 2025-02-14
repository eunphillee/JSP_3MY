package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDao {
	
	private static CustomerDao dao = new CustomerDao();
	private CustomerDao() {}
	public static CustomerDao getInstance() {
		return dao;
	}
	
	  private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	  private static final String USERNAME ="c##idev";
	  private static final String PASSWORD ="1234";
	  private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";

	  private Connection open() throws SQLException {
		  try {
		  Class.forName(DRIVER);
		  }catch(ClassNotFoundException e) {
			  
		  }
		  return DriverManager.getConnection(URL,USERNAME, PASSWORD);
	  }
	  
	  public int delete(String customId) {
	      int result =0;
	      String sql="DELETE FROM tbl_customer WHERE custom_id = ?";
	      try (Connection connection = open();
	           PreparedStatement pstmt = connection.prepareStatement(sql);
	          ) {
	            pstmt.setString(1, customId);
	            result = pstmt.executeUpdate();
	      } catch (Exception e) {
	        System.out.println("예외 : " + e.getMessage());
	      }
	      return result;
	    }

	  
	  
}
