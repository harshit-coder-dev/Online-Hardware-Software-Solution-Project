package com.project.bean;

public class Problem {
	private int pid;
	private String pname;
	private String pcategory;
	private String pstatus;

	public Problem() {
		// TODO Auto-generated constructor stub
	}

	public Problem(int pid, String pname, String pcategory, String pstatus) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcategory = pcategory;
		this.pstatus = pstatus;
	}

	public String getPcategory() {
		return pcategory;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}

	@Override
	public String toString() {
		return "Problem [pid=" + pid + ", pname=" + pname + ", pcategory=" + pcategory + ", pstatus=" + pstatus + "]";
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

}
