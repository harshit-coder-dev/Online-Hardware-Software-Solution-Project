package com.project.bean;

public class ProblemPro {
	
	private int eid;
	private int pid;
	private String engname;
	private String pname;
	private String pcategory;
	private String pstatus;

	
	
	public ProblemPro(int eid, int pid, String engname, String pname, String pcategory, String pstatus) {
		super();
		this.eid = eid;
		this.pid = pid;
		this.engname = engname;
		this.pname = pname;
		this.pcategory = pcategory;
		this.pstatus = pstatus;
	}


	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getEngname() {
		return engname;
	}


	public void setEngname(String engname) {
		this.engname = engname;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPcategory() {
		return pcategory;
	}


	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}


	public String getPstatus() {
		return pstatus;
	}


	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}


	@Override
	public String toString() {
		return "ProblemPro [eid=" + eid + ", pid=" + pid + ", engname=" + engname + ", pname=" + pname + ", pcategory="
				+ pcategory + ", pstatus=" + pstatus + "]";
	}

}
