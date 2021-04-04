package DBconnect;
import java.sql.*;


public class ConnectionMySql {

	private static final String username="root";
	private static final String password="12345";
	private static final String url="jdbc:mysql://localhost:3306/travelbybus";

	private Statement statement;
	private PreparedStatement preparedStatement;
	private static Connection conn=null;
	public static ConnectionMySql db;

	public ConnectionMySql() {
		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection(url, username, password);

				System.out.println("Connection successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static synchronized ConnectionMySql getCon() {


		if (db == null) {
			db = new ConnectionMySql();
		}
		return db;


	  }

	/**
	 *
	 * @param query String The query to be executed
	 * @return a ResultSet object containing the results or null if not available
	 * @throws SQLException
	 */
	public ResultSet selectQuery(String query) throws SQLException{
		statement = db.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
	}
	/**
	 * @desc Method to insert data to a table
	 * @param insertQuery String The Insert query
	 * @return boolean
	 * @throws SQLException
	 */
	public int insertAndUpdate(String insertQuery) throws SQLException {
		statement = db.conn.createStatement();
		int result = statement.executeUpdate(insertQuery);
		return result;

	}
	/**
	 *
	 * Edited by kaushirajapakshe
	 *
	 */
	public PreparedStatement selectResult(String insertQuery) throws SQLException{
		preparedStatement = db.conn.prepareStatement(insertQuery);
		return preparedStatement;
	}

}
