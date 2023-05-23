package Model.BO;

import Model.DAO.CheckLoginDAO;

public class CheckLoginBO {

	public static boolean CheckLogin(String username, String password) {
		return CheckLoginDAO.CheckLogin(username, password);
	}



}