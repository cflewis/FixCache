package Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class DBOperation {

	String database;
	String username;
	String password;

	public DBOperation(String database, String username, String password)
	{
		this.database= database;
		this.username = username;
		this.password =password;
	}
	public Connection getConnection()
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(database,username,password);

		}
		catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		return conn;

	}

	public ResultSet ExeQuery(Connection conn, String sqlStatement)
	{
		Statement s = null;
		ResultSet r = null;
		try {
			s = conn.createStatement();
			r = s.executeQuery(sqlStatement);
		}
		catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}

		return r;
	}


	public static void main(String [] args) {
		DBOperation dbOp = new DBOperation("jdbc:mysql://localhost/mydb","root",null);
		Connection conn = dbOp.getConnection();
		int id = 1;
		int fileID = 1;
		int commitID = 2;
		String sql = "SELECT id from actions where id="+fileID+" and commit_id <="+commitID;
		ResultSet r = dbOp.ExeQuery(conn, sql);
		try{
			while(r.next()) {
				System.out.println(r.getInt(1));
			}
		}  
		catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}

	}
}