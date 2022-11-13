package com.project.bean;

public class EngineerDTO {
	
	private int engid;
	private String engName;
	private String category;
	private String pname;
	

	public EngineerDTO(int engid, String engName, String category, String pname) {
		super();
		this.engid = engid;
		this.engName = engName;
		this.category = category;
		this.pname = pname;
	}

	public int getEngid() {
		return engid;
	}

	public void setEngid(int engid) {
		this.engid = engid;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "EngineerDTO [engid=" + engid + ", engName=" + engName + ", category=" + category + ", pname=" + pname
				+ "]";
	}

}
