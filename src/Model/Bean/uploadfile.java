package Model.Bean;

public class uploadfile {
	int fid;
	int uid;
	String fname;
	int fstatus;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFstatus() {
		return fstatus;
	}
	public void setFstatus(int fstatus) {
		this.fstatus = fstatus;
	}
	public uploadfile(int fid, int uid, String fname, int fstatus) {
		super();
		this.fid = fid;
		this.uid = uid;
		this.fname = fname;
		this.fstatus = fstatus;
	}
	public uploadfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}