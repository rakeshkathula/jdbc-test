import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;;

public class JdbcInsertDemo {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dbUrl = "jdbc:mysql://localhost:3306/demo?useSsl=false";
		String user = "student";
		String pass = "student";

		try {
			myConn = DriverManager.getConnection(dbUrl, user, pass);

			myStmt = myConn.createStatement();

			int rowsAffected = myStmt
					.executeUpdate("insert into employees" + "(last_name,first_name,email,department,salary)" + "values"
							+ "('wright','eric','eric@mail.com','HR',3300.00)");

			myRs = myStmt.executeQuery("select * from employees order by last_name");

			while (myRs.next()) {

				System.out.println(myRs.getString("last_name") + "," + myRs.getString("first_name"));
			}

		}

		catch (Exception exc) {

			exc.printStackTrace();

		}

		finally {
			if (myRs != null) {
				myRs.close();
			}

		}

	}
}
