package Model.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.Bean.user;

public class UploadFileDAO {

	public static void Upload(String filename, user user, int fstatus) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/pdf2word";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "";
			if (!IsFileExist(filename)) {
				sql = "INSERT INTO `uploadfile`(`uid`, `fname`, `fstatus`) VALUES (" + user.getUid() + ",'" + filename
						+ "'," + fstatus + ")";
			} else {
				sql = "UPDATE uploadfile set fstatus = " + fstatus + " where fname = " + filename;
			}
			stmt.execute(sql);
		} catch (Exception a) {

		}
	}

	private static boolean IsFileExist(String filename) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/pdf2word";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM uploadfile WHERE fname = '" + filename + "'";
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

}