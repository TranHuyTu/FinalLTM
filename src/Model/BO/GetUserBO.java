package Model.BO;

import Model.Bean.user;
import Model.DAO.GetUserDAO;

public class GetUserBO {

	public static user GetUser(String username) {
		return GetUserDAO.GetUser(username);
	}

}