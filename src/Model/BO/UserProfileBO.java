package Model.BO;

import java.util.ArrayList;

import Model.Bean.uploadfile;
import Model.DAO.UserProfileDAO;

public class UserProfileBO {

	public static ArrayList<uploadfile> GetProcessedFile(int uid) {
		return UserProfileDAO.GetProcessedFile(uid);
	}

}