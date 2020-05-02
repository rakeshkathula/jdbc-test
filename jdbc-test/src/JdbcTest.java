import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// 1. Get a connection to database

			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");

			System.out.println("Database connection sucuessfull!\n");

			// 2. Create a statement
			myStmt = myConn.createStatement();

			// 3. Execute SQL query

			myRs = myStmt.executeQuery("select * from employees");

			// 4. Process the result Set

			while (myRs.next()) {

				System.out.println(myRs.getString("last_name") + "," + myRs.getString("first_name"));

			}

		} catch (Exception exc) {

			exc.printStackTrace();
		}

	}
}
