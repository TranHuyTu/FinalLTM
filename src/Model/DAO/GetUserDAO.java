package Model.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.Bean.user;

public class GetUserDAO {

	public static user GetUser(String username) {
		user user = new user();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/pdf2word";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM user where username = '" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int uid = rs.getInt("uid");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");

				user = new user(uid, username, password, fullname, email);
			}
		} catch (Exception a) {
			return null;
		}
		return user;
	}

}