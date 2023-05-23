package Model.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.Bean.uploadfile;

public class DownloadFileDAO {

	public static uploadfile GetFile(int fid) {
		uploadfile file = new uploadfile();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/pdf2word";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "SELECT * FROM uploadfile where fid = " + fid + "";
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				int _fid = rs.getInt("fid");
				int _uid = rs.getInt("uid");
				String fname = rs.getString("fname").split("\\.")[0] + ".docx";
				int status = 2;
				
				file = new uploadfile(_fid, _uid, fname, status);
			}
		}
		catch(Exception a)
		{
			return null;
		}
		return file;
	}

}