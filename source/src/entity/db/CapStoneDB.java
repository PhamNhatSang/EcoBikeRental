package entity.db;
import java.sql.*;
 
import java.util.logging.Logger;

import utils.Utils;
    /**
     * this is CapStoneDB class
     * @author NhatSang
     * @version 1.0
     */
public class CapStoneDB {
	private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
	private static Connection connect;
	public static Connection getConnection() {
		if (connect != null) return connect;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			connect=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/capstoneproject","root","yasuo1234gg"); 
			LOGGER.info("Connect database successfully");
		}
		catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return connect;
		}

	
public static void main(String[] args) {
		CapStoneDB.getConnection();     
}
}
	
