package com.project.bean;

public class Engineer {

	private int EngId; 
	private String EngName; 
	private String EngUserName;
	private String EngPassword ;
	private String EngCategory ;
	
	public Engineer() {
		// TODO Auto-generated constructor stub
	}
	
	public Engineer(int engId, String engName, String engUserName, String engPassword, String engCategory) {
		super();
		EngId = engId;
		EngName = engName;
		EngUserName = engUserName;
		EngPassword = engPassword;
		EngCategory = engCategory;
	}
	public int getEngId() {
		return EngId;
	}
	public void setEngId(int engId) {
		EngId = engId;
	}
	public String getEngName() {
		return EngName;
	}
	public void setEngName(String engName) {
		EngName = engName;
	}
	public String getEngUserName() {
		return EngUserName;
	}
	public void setEngUserName(String engUserName) {
		EngUserName = engUserName;
	}
	public String getEngPassword() {
		return EngPassword;
	}
	public void setEngPassword(String engPassword) {
		EngPassword = engPassword;
	}
	public String getEngCategory() {
		return EngCategory;
	}
	public void setEngCategory(String engCategory) {
		EngCategory = engCategory;
	}

	@Override
	public String toString() {
		return "Engineer [EngId=" + EngId + ", EngName=" + EngName + ", EngUserName=" + EngUserName + ", EngPassword="
				+ EngPassword + ", EngCategory=" + EngCategory + "]";
	}
	
	
	
}