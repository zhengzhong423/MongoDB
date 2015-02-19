package MangoDB.MANGO;

import java.sql.Connection;
import java.sql.DriverManager;



public class connectMySQL {
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/root?user=root&password=123456";
			Connection conn=DriverManager.getConnection(url);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
