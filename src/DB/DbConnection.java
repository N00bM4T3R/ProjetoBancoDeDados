package DB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;






public class DbConnection {
	
public static  Connection conn ;
	

	
	public  static Connection getConnection()  {
		if(conn == null) {
			try {
			Properties prop = loadProperties();
			String url = prop.getProperty("dburl");
			conn = DriverManager.getConnection(url, prop);

			}
			catch (SQLException e) { 
		 throw new DbException(e.getMessage());
				
			}
			
		}
		return conn;
	}
	public static Properties loadProperties() {
		try(FileInputStream fl = new FileInputStream("Db.properties")) {
			Properties prop = new Properties();
			prop.load(fl);
			return prop;
		
		}
		catch (Exception e) {
		throw new DbException(e.getMessage());
		}
		
	}
	public static void closeconnection() {
		if ( conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
				
			}
			
		}
	}
	public static void closeStatmen(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
				
			}
		}
		
	}
	public static void closeRsult(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch (SQLException  e) {
				throw new DbException(e.getMessage());
			}

}}}
