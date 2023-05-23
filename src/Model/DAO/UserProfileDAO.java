package Model.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.Bean.uploadfile;

public class UserProfileDAO {

	public static ArrayList<uploadfile> GetProcessedFile(int uid) {
		ArrayList<uploadfile> files = new ArrayList<uploadfile>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/pdf2word";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "select * from uploadfile where uid = "+ uid;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int fid = rs.getInt("fid");
				String fname = rs.getString("fname").split("\\.")[0] + ".docx";
				if(fname.length() > 20)
					fname = fname.substring(0, 20) + "...docx";
				int fstatus = rs.getInt("fstatus");
				
				files.add(new uploadfile(fid, uid, fname, fstatus));
			}
		}
		catch(Exception a)
		{
			return null;
		}
		
		return files;
	}
	
}
