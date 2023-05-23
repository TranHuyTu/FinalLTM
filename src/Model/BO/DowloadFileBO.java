package Model.BO;

import Model.Bean.uploadfile;
import Model.DAO.DownloadFileDAO;

public class DowloadFileBO {

	public static uploadfile GetFile(int fid) {
		return DownloadFileDAO.GetFile(fid);
	}

}